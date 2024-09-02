package com.test.oop;

class Family {
  void hello() {
    System.out.println("가족과 인사");
  }
}
class KimFamilly extends Family {
  void hello() { System.out.println("김씨네 가족인사"); }
  void dinner() { System.out.println("밥먹자"); }
  void drink() { System.out.println("술도 한잔"); }
}
class ParkFamily extends Family {
  void hello() { System.out.println("박씨네 가족인사"); }
  void fishing() { System.out.println("낚시ㄱㄱ");}
}
class ChoidFamily extends Family {
  void hello() { System.out.println("조씨네 가족인사"); }
  void meeting() { System.out.println("가족모임ㄱㄱ");}
}

public class PolymorphismExam01 {

  public static void main(String[] args) {
    
    // Upcasting의 경우는 생성된 인스턴스의 메소드를 실행 --> 가상 메소드
    /* 
      Parent p = new Child(); 
      p.hello() 부모와 자식이 동시에 가진 hellow메소드를 자식 인스턴스 메소드가 실행됨
      Parent p = new Child1(); Parent p = new Child2(); …
     */
    Family f; 
    f = new KimFamilly();
    f.hello();

    f = new ParkFamily();
    f.hello();

    f = new ChoidFamily();
    f.hello();
    
  }

}
