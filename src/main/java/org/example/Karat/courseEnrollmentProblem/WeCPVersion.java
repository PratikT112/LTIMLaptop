package org.example.Karat.courseEnrollmentProblem;

import jdk.jshell.EvalException;

import java.util.*;

public class WeCPVersion {

    public static void main(String[] args) {
        String[][] enr = {
                {"58", "Linear Algebra"},
                {"94", "Art History"},
                {"94", "Operating Systems"},
                {"17", "Software Design"},
                {"58", "Mechanics"},
                {"58", "Economics"},
                {"17", "Linear Algebra"},
                {"17", "Political Science"},
                {"94", "Economics"},
                {"25", "Economics"},
                {"25", "Linear Algebra"},
                {"58", "Software Design"},
        };

        List<String> pairs = findPairs(1, enr);
        System.out.println(pairs);
    }

    public static List<String> findPairs(int n, String[][] enrollments){
        HashMap<String, Set<String>> coursesByStudents = new HashMap<>();
        List<String> result = new ArrayList<>();
        for(String[] enrollment: enrollments){
            String key = enrollment[0];
            String value = enrollment[1];

//            if(coursesByStudents.containsKey(key)){
//                coursesByStudents.get(key).add(value);
//            } else {
//                coursesByStudents.put(key, new HashSet<String>());
//                coursesByStudents.get(key).add(value);
//            }
            coursesByStudents.putIfAbsent(key, new HashSet<>());
            coursesByStudents.get(key).add(value);
        }

        List<String> students = new ArrayList<>(coursesByStudents.keySet());

        for(int i = 0; i < students.size(); i++){
            for(int j = i + 1; j < students.size(); j++){
                String s1 = students.get(i);
                String s2 = students.get(j);

                Set<String> s1Courses = coursesByStudents.get(s1);
                Set<String> s2Courses = coursesByStudents.get(s2);

                Set<String> common = new HashSet<>(s1Courses);
                common.retainAll(s2Courses);


                String commonStr = String.join(",", common);

                result.add(s1 + "," + s2 + ":" + commonStr);

            }
        }
        System.out.println("Hi");
        return result;
    }
}
