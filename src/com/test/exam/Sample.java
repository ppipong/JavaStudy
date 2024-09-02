package com.test.exam;

public class Sample {

  /*
   * 클래스의 내부에 선언된 변수 --> 인스턴스 변수
   * 인스턴스 변수의 scope는 이 변수가 선언된 클래스 전체에 미친다
   * 단, main 메소드 내에서 영향을 미치기 위해서는 인스턴스 선언이 필요
   * 인스턴스 변수의 라이프타임은 이 객체가 존재 할때까지
   */
  int x, y;

  /*
   * 클래스의 내부에 선언된 static 변수 --> 클래스 변수
   * 클래스 변수의 scope는 이 변수가 선언된 클래스 전체에 미친다
   */
  static int result;

  void add(int a, int b) { // 메소드의 매개변수 a, b
    // x는 인스턴스 변수로 이미 선언이 된 상태
    // 매개변수 a의 값이 인스턴스 변수 x에 할당된다
    x = a;
    y = b;
    int sum = x + y; // 선언과 동시에 할당 --> 초기화
    // result = 88; // 클래스 변수에 88을 할당
    result = 44; // 클래스 변수에 44을 할당
    
    System.out.println("add : result = " + result);
    System.out.println("Sum = " + sum);
  }

  void add2() {
    // 매소드 내의 변수명이 같을 때에 영향 x
    int a = 3;
    int b = 4;
  }

  public static void main(String[] args) {
    Sample obj = new Sample(); // 인스턴스 선언
    obj.add(10, 20);

    System.out.println("x = " + obj.x);
    System.out.println("y = " + obj.y);
    result = 20; // main에서 변수 재정의
    System.out.println("main : result = " + result);

    System.out.println("안녕");
    System.out.print("반가\n");
    System.out.print("\"히히\"");

    
  }

}
