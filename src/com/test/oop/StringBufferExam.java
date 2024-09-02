package com.test.oop;

public class StringBufferExam {

  /* StringBuffer은 멀티 스레드 환경에서 안전하다는 장점이 있고, 
   * StringBilder는 StringBuffer보다 성능이 우수한 장점이 있음
   */
  public static void main(String[] args) {
    StringBuilder sb = new StringBuilder();
    sb.append("Hellow"); 
    sb.append(" "); 
    sb.append("My world"); 
    String result1 = sb.toString();
    System.out.println(result1);

    sb.insert(0, "Everuone");
    String result2 = sb.toString();
    System.out.println(result2);
  }

}
