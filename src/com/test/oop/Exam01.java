package com.test.oop;

/**
 * InnerClass
 */
class InnerClass {
  public int a = 1;
  public int b = 2;

  void value() {
    System.out.println("a = " + a + ", b = " + b);
  }
}

/**
 * InnerClass02
 */
class InnerClass02 {
  private int a = 4;
  int b = 4;
  void value() {
    a = 6;
    System.out.println("a = " + a + ", b = " + b);
  }

  public int getInnerClass02() {
    return this.a;
  }

  public void setInnerClass02(int a) {
    this.a = a;
  }

}

/**
 * InnerExam03
 */
class InnerClass03 {
  // int c = 33;
  static int c = 33; // static 맴버 변수를 사용하면 클래스의 모든 인스턴스가 같은 변수를 공유하게 됩니다.

  void value() {
    System.out.println("c = " + c);
  }
}
class InnerClass04 {
  static int d = 88; // static 은 
  final int k = 4; // 지역 변수

  static void Dvalue() {
    System.out.println("d = " + d);
    // k = 5; 상수의 값은 변경 할수 없다
  }
}

public class Exam01 {

  public static void main(String[] args) {
    InnerClass first = new InnerClass(); // 값을 사용 하기 위해 인스턴스화
    InnerClass first_next = new InnerClass(); // 같은 클래스라도 변수이름을 달리 지어 가져올 수 있다
    
    first.a = 10;
    first.b = 20;
    first.value();
    first_next.value(); // 같은 클래스를 인스턴스해서 받았지만 독립적인 객체로 설정이 되어 있어, 값의 영향을 받지 않습니다

    InnerClass02 too;
    too = new InnerClass02(); 

    System.out.println(too.getInnerClass02()); // a변수에 할당된 값이 : 4, a의 값이 value() 재정의
    too.setInnerClass02(100); // 값을 재할당
    System.out.println(too.getInnerClass02());

    InnerClass03 tree = new InnerClass03();
    InnerClass03 tree_next = new InnerClass03();
    
    tree.value();
    tree_next.value();

    tree.c = 55;
    tree.value();
    tree_next.value(); // static 변수를 사용 하였기에 55라는 값을 함께 할당 받는다

    InnerClass04.Dvalue();
    
  }
  
}
