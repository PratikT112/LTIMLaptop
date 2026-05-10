package org.example.Generics;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        ArrayList list = new ArrayList();
        list.add("Hello");
        list.add(123);
        list.add(3.14);

        Object o = list.get(0);
        System.out.println(o);
    }
}
