package com.test.oop;

interface Animal { public void move(); }
// 인터페이스를 상속받는 객체
class Human implements Animal {
  public void move() { System.out.println("사람 - 두발로 걷습니다");}
}
class Tiger implements Animal {
  public void move() { System.out.println("호랑이 - 네발로 뜁니다");}
}
class Eagle implements Animal {
  public void move() { System.out.println("독수리 - 하늘을 납니다");}
}

class AnimalMove {
  Animal animal; // Animal 인터페이스
  public AnimalMove(Animal animal) { // 생성자를 통한 인스턴스 주입
    this.animal = animal;
    animal.move();
  }
}
public class Polymorphism03 {

  public static void main(String[] args) {
    new AnimalMove(new Human());
    new AnimalMove(new Tiger());
    new AnimalMove(new Eagle());
  }

}
