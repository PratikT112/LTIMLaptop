package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

public class LC {
    public static void main(String[] args) {
        int[] nums = {2,7,11,15,17,19,23};
        int target = 38;
        int[] ints = twoSum(nums, target);
        System.out.println("Thing");

        String test = "29";
        System.out.println(letterCombinations(test));
    }

    public static int[] twoSum(int[] nums, int target) {
        LinkedHashMap<Integer, Integer> store = new LinkedHashMap<>();
        for(int i = 0; i < nums.length; i++){
            int key = target - nums[i];
            if(store.containsKey(key)){
                return new int[]{store.get(key), i};
            } else{
                store.put(nums[i], i);
            }
        }
        return new int[]{0,0};
    }

    public static List<String> letterCombinations(String digits) {
        HashMap<String, List<String>> map = new HashMap<>();
        map.put("2", List.of("a", "b", "c"));
        map.put("3", List.of("d", "e", "f"));
        map.put("4", List.of("g", "h", "i"));
        map.put("5", List.of("j", "k", "l"));
        map.put("6", List.of("m", "n", "o"));
        map.put("7", List.of("p", "q", "r", "s"));
        map.put("8", List.of("t", "u", "v"));
        map.put("9", List.of("w", "x", "y", "z"));

        List<String> res = new ArrayList<>();

        String[] split = digits.split("");
        for(String a: map.get(split[0])){
            for(String b: map.get(split[1])){
                for(String c: map.get(split[2])){
                    StringBuilder sb = new StringBuilder();
                    sb.append(a);
                    sb.append(b);
                    sb.append(c);
                    res.add(sb.toString());
                }
            }
        }
        return res;
    }
}
