package org.example.Karat.courseEnrollmentProblem;

import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        EnrollmentList list = new EnrollmentList();
        list.addEnrollment(new Enrollment("58", "Linear Algebra"));
        list.addEnrollment(new Enrollment("94", "Art History"));
        list.addEnrollment(new Enrollment("94", "Software Design"));
        list.addEnrollment(new Enrollment("94", "Operating Systems"));
        list.addEnrollment(new Enrollment("17", "Software Design"));
        list.addEnrollment(new Enrollment("58", "Mechanics"));
        list.addEnrollment(new Enrollment("58", "Economics"));
        list.addEnrollment(new Enrollment("17", "Linear Algebra"));
        list.addEnrollment(new Enrollment("17", "Political Science"));
        list.addEnrollment(new Enrollment("94", "Economics"));
        list.addEnrollment(new Enrollment("25", "Economics"));
        list.addEnrollment(new Enrollment("25", "Software Design"));
        list.addEnrollment(new Enrollment("58", "Software Design"));

//        List<Float> workoutDuration = List.of(10.1F, 10.2, 11, 13);
        
        //1. Get a list of students 
        List<String> stuList2 = list.enrollmentList.stream().map(x -> x.studentId).distinct().toList();

        //2. Get a map of students with their courses
        Map<String, List<String>> courseByStudents2 = list.enrollmentList.stream().collect(Collectors.groupingBy(x -> x.studentId, Collectors.mapping(e -> e.courseName, Collectors.toList())));

        //3. Calculate the common courses

        System.out.println(stuList2);
        System.out.println(courseByStudents2);
        HashMap<String, List<String>> res = new HashMap<>();
        List<String> stuPairs2 = new ArrayList<>();


        for(int i = 0; i < stuList2.size(); i++){
            for(int j = i+1; j < stuList2.size(); j++){
                StringJoiner sj = new StringJoiner("-");
                sj.add(stuList2.get(i));
                sj.add(stuList2.get(j));
                stuPairs2.add(sj.toString());

                List<String> s1Course = courseByStudents2.get(stuList2.get(i));
                List<String> s2Course = courseByStudents2.get(stuList2.get(j));

                List<String> sharedForPair2 = new ArrayList<>();
                for(String course: s1Course){
                    if(s2Course.contains(course)){
                        sharedForPair2.add(course);
                    }
                }
                res.put(sj.toString(), sharedForPair2);
            }
        }

        System.out.println(res);

//        List<String> stuList = list.enrollmentList.stream().map(x -> x.studentId).distinct().toList();
//        System.out.println(stuList);
//
//        Map<String, List<String>> courseByStudents = list.enrollmentList.stream().collect(Collectors.groupingBy(x -> x.studentId, Collectors.mapping(e -> e.courseName, Collectors.toList())));
//        System.out.println(courseByStudents);
//
//        List<String> stuPairs = new ArrayList<>();
//        HashMap<String, List<String>> sharedList = new HashMap<>();  //To store the result in form of a map of String->List<String>
//
//        for(int i = 0; i < stuList.size(); i++){
//            for(int j = i+1; j < stuList.size(); j++){
//                StringJoiner sj = new StringJoiner("-");
//                sj.add(stuList.get(i));
//                sj.add(stuList.get(j));
//                stuPairs.add(sj.toString());
//
//                List<String> s1List = courseByStudents.get(stuList.get(i));
//                List<String> s2List = courseByStudents.get(stuList.get(j));
//
//                List<String> sharedForPair = new ArrayList<>();
//                for(String course: s1List){
//                    if(s2List.contains(course)){
//                        sharedForPair.add(course);
//                    }
//                }
//
//                sharedList.put(sj.toString(), sharedForPair);
//            }
//        }
//
//        System.out.println(stuPairs);
//        System.out.println("Answer below");
//        System.out.println(sharedList);
//        List<String> courseList = list.enrollmentList.stream().map(x -> x.courseName).distinct().toList();
//        System.out.println(courseList);
    }
}
