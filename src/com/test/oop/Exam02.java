package com.test.oop;

// ++ 생성자의 역활과 오버로딩의 이해를 위한 예제
class InnerA {

  // 변수 선언
  int a = 3;
  int b = 4;

  // 인자가 없는 생성자의 경우는 생성자를 클래스 내에 선언 하지 않아도 컴파일시 자동 생성
  public InnerA(){ 
    // 값 재설정
    a = 30; b = 30;
    System.out.println("클래스 innerA 생성자를 통해 인스턴스");
  } 
  public InnerA(int a, int b){
    this.a = a;
    this.b = b;
    System.out.println("두개의 인자를 가진 클래스 innerA 생성자를 통해 인스턴스");
  } 
  public int sum() { return a+b; }
  public int cal(int a, int b) { return a*b; }
  public int cal(int a, int b, int c) { return a+b+c; }
  
}

public class Exam02 {
  
  public static void main(String[] args) {
    
    // A 클래스 생성자를 통해 인스턴스를 생성하고, 생성된 인스턴스의 주소를 a에 할당 한다
    InnerA a = new InnerA(); 
    System.out.println("인자 값이 없는 맴버 변수의 합은 = " + a.sum() + "\n");
    
    InnerA a02 = new InnerA(100,200);
    System.out.println("인자 값을 가진 맴버 변수의 합 = "+ a02.sum());

    System.out.println(a.cal(3, 4));
    System.out.println(a.cal(3, 4, 5));
  }

}
