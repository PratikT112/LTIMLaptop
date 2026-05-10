package org.example.LeetCode;

import java.util.*;
import java.util.stream.Collectors;

public class LC75 {
    public static void main(String[] args) {
        int[] colors = {2,0,2,1,1,0};
        sortColors(colors);
    }

    public static void sortColors(int[] nums) {
        Map<Integer, Integer> count = new LinkedHashMap<>();
        for(int i: nums){
            count.merge(i, 1, Integer::sum);
        }
        List<Integer> list = Arrays.stream(nums).boxed().toList();
        Map<Integer, Integer> count2 = list.stream().collect(Collectors.toMap(x -> x, x -> 1, Integer::sum));
        System.out.println(count);
        System.out.println(count2);
        for(Map.Entry<Integer, Integer> entry: count2.entrySet()){

        }
    }
}
