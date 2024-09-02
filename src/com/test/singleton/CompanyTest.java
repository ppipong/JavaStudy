package com.test.singleton;

public class CompanyTest {

  public static void main(String[] args) {
    Company myCompany01 = Company.getInstance();
    Company myCompany02 = Company.getInstance();
    System.out.println(myCompany01 == myCompany02); // 동일한 주소의 값을 비교 하였기에 --> true
  }
}
