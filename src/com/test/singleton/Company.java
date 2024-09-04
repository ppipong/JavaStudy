package com.test.singleton;

public class Company {

  private static  Company instance;
  private Company() {} // 생성자 선언 및 정의

  public static Company getInstance() {
    if(instance == null)
    instance = new Company(); // 인스턴스 생성
    return instance; 
  }
}
