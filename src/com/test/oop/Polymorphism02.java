package com.test.oop;

class Animal {
  public void move() { System.out.println("동물이 움직임");}
}
class Human extends Animal {
  public void move() { System.out.println("사람 - 두발로 걷습니다");}
}
class Tiger extends Animal {
  public void move() { System.out.println("호랑이 - 네발로 뜁니다");}
}
class Eagle extends Animal {
  public void move() { System.out.println("독수리 - 하늘을 납니다");}
}

public class Polymorphism02 {

  public static void main(String[] args) {
    
    Polymorphism02 animalTest = new Polymorphism02();
    animalTest.moveAnimal(new Human()); // 인스턴스 주입 (Injection)
    animalTest.moveAnimal(new Tiger());
    animalTest.moveAnimal(new Eagle());
  }
  
  public void moveAnimal(Animal animal) {
    animal.move();
  }

}
