package com.test.exam;

import java.util.Arrays;

public class ArrayExam01 {
  public static void main(String[] args) {
    int[] a = new int[]{1,2,3,4,5,6};
    for (int i = 0; i < a.length; i++) {
      System.out.print(a[i]+" ");
    }
    for (int i : a) {
      System.out.print(i + " ");
    }
    System.out.println("\n");
    System.out.println(Arrays.toString(a));

    int[][] b = {{1,2,3}, {4,5,6}, {7,8,9}};
    System.out.println("b[0][2] = " + b[0][2]);
    System.out.println("b[1][2] = " + b[1][2]);
    System.out.println("b[2][0] = " + b[2][0]);

    for (int i = 0; i < b.length; i++) {
      System.out.println(Arrays.toString(b[i]));
    }
    
  }
}
