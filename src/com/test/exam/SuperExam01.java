package com.test.exam;

class Point {
  int x = 10;
  int y = 20;

  Point(int x2, int y2) {
    this.x = x;
    this.y = y;
  }

}

class Point3D extends Point {
  int z = 30;
  Point3D() {
    this(100,200,300); // 값을 초기화
  }
  Point3D(int x, int y, int z) { 
    super(x, y); // 부모 클래스의 인자를 호출
    this.z = z;
  }
}
public class SuperExam01 {

  public static void main(String[] args) {
    Point3D point3d = new Point3D();
    System.out.println("point3D의 값 = " 
      + point3d.x + " " 
      + point3d.y + " "
      + point3d.z);
  }
}
