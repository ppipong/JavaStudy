package com.test.oop;

interface InterfaceTest {
  void InterfaceTest_i1();
  int InterfaceTest_i2(int a, int b);
}

class I1 implements InterfaceTest{

  @Override
  public void InterfaceTest_i1() { System.out.println("InterFaaceTest 인터페이스의 i1 메소드 구현");}

  @Override
  public int InterfaceTest_i2(int a, int b) { 
    System.out.println("InterFaaceTest 인터페이스의 i2 메소드 구현");
    return a+b;
  }
}
class I2 {}

public class interfaceExam {

  public static void main(String[] args) {
    I1 i1 = new I1();
    i1.InterfaceTest_i1();
    System.out.println(i1.InterfaceTest_i2(10, 20));
  }
  
}