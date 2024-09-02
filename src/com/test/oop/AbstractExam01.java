package com.test.oop;

abstract class A { 
  
  void Amethod01() { System.out.println("Amethod02 추상클래스의 일반 메소드");}
  
  abstract void Amethod02();
  
  void Amethod01_02() { System.out.println("Amethod02 추상클래스의 일반 메소드");}
}
class B extends A{

  int a = 10;
  int b = 20;
  int sum = a+b;

  @Override
  void Amethod02() { System.out.println("A클래스의 추상메소드");}; // 추상클래스 오버라이딩
  
  @Override
  void Amethod01_02() { // 가상매서드
     System.out.println("B클래스의 맴버 변수 의 합 = " + sum);
  }
  
}
public class AbstractExam01 {
  public static void main(String[] args) {
    B bclass = new B(); // 중복된 클래스에서 받아
    bclass.Amethod01();
    bclass.Amethod01_02();
  }
}
