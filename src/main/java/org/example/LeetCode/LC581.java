package org.example.LeetCode;

public class LC581 {

    public static void main(String[] args) {
//        int[] arr = {1,2,3,3,3};
        int[] arr = {2,6,4,8,10,9,15};
        System.out.println(findUnsortedSubarrayOpt(arr));
    }


    public static int findUnsortedSubarray(int[] nums) {
        int i = 0;
        int j = nums.length-1;
        int leftBound = -1;
        int rightBound = -1;
        while(i < j && (leftBound==-1 || rightBound==-1)){
            if(nums[i] < nums[i+1]){
                i++;
            } else{
                leftBound = i;
            }
            if(nums[j] > nums[j-1]){
                j--;
            } else {
                rightBound = j;
            }
        }
        if(leftBound == -1 && -1 == rightBound){
            return 0;
        } else {
            return leftBound - rightBound +1;
        }
    }


    public static int findUnsortedSubarrayOpt(int[] nums) {
        int n = nums.length, beg = -1, end = -2, min = nums[n-1], max = nums[0];
        for(int i = 1; i < n; i++){
            max = Math.max(max, nums[i]);
            min = Math.min(min, nums[n-1-i]);
            if(nums[i] < max) {
                end = i;
            }
            if(nums[n-1-i] > min) {
                beg = n-1-i;
            }
        }
        return end - beg + 1;
    }
}
