package com.test.exam;

public class ExceptionExam {

  public static void main(String[] args) throws Exception { // 메인에 바로 예외처리 해주는 방법
    int b;
    int c;
    b = 0;
    c = 0; // ** Line : 18 참조

    /* try {
      c = 4/b;
    } catch (ArithmeticException e) {
      b = -1; // 에러가 발생시
    } finally { // 에러가 발생하더라도 반드시 수행 해준다
      System.out.println("예외x"); 
    }
    System.out.println("c = " + c); // 값의 할당을 해주지 않으면 print 해주지 x
    */

    // c = 12/b;

    // System.out.println("c = " + c); 

    ExceptionExam exam = new ExceptionExam();
    // exam.sayNickname("홍길동");
    exam.sayNickname("fool"); // 주소 값이 다르기 때문에 그대로 값을 배출
    
  }

  public void sayNickname(String nickname) {
    if(nickname.equals("fool"))
    // if(nickname.equals(nickname))
      try {
        throw new Exception();
      } catch (Exception e) {
        e.printStackTrace();
      }
    System.out.println("당신의 별명은" + nickname + "입니다");
  }

}


