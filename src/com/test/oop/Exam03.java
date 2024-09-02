package com.test.oop;

class Parent {
  int a; int b;
  public void parent() {}
}
// Parent의 클래스를 상속 받아서 a, b의 변수를 사용할 수 있다
class Child extends Parent { 
  int c; int d;
  public void child() {}
}
public class Exam03 {

  public static void main(String[] args) {
    
    Child c = new Child();
    
  }

}
