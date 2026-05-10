package org.example;

import java.util.EnumMap;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
//        HashMap<Employee, String> map = new HashMap<>();
//        Employee e1 = new Employee(101, "Pratik");
//        Employee e2 = new Employee(101, "Pratik");
//        map.put(e1, "Developer");
//        System.out.println(map.get(e1));
//        System.out.println(map.get(e2));
//        map.put(e2, "Tester");
//        System.out.println(map.get(e1));
//        System.out.println(map.get(e2));

        Set<Person> set = new HashSet<>();
        Person p1 = new Person("111-22-3333");
        Person p2 = new Person("111-22-3333");

        set.add(p1);
        set.add(p2);


        System.out.println("Set size = " + set.size());
        System.out.println("Contains p1? " + set.contains(p1));
        System.out.println("Contains p2? " + set.contains(p2));
        System.out.println("Elements: " + set);


    }
}