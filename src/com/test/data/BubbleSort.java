package com.test.data;

import java.util.Arrays;

public class BubbleSort {
  public static void main(String[] args) {
    System.out.println("<<정렬 전>>");
    int[] nums = {1,7,2,4,3,5,0,9,8,6};
    System.out.println(Arrays.toString(nums));
    for(int i = nums.length-1; i>0; i--) {
      for(int j = 0; j < i; j++) {
        if(nums[j] > nums[j+1]) {
          int temp = nums[j];
          nums[j] = nums[j+1];
          nums[j+1] = temp;
        }
      }
    }
    System.out.println("<<정렬 후>>");
    System.out.println(Arrays.toString(nums));
  }
}
