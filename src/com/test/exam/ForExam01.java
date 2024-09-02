package com.test.exam;

public class ForExam01 {

  public static void main(String[] args) {

    // 인스턴트 변수
    int i = 0;
    int sum = 0;

    for (i = 0; i <= 100; i++) {
      sum = sum + i;
    }
    System.out.println("\n" + "#1 for문을 이용한 계산 sum = " + sum);

    // 초기화
    i = 0;
    sum = 0;

    while (i <= 100) {
      sum += i++;
    }
    System.out.println("\n" + "#2 while 문을 이용한 계산 sum = " + sum);

    i = 0;
    sum = 0;

    while (true) { // Boolean을 만났을때 조건 끝
      sum += i++; // break 해주지 않았을시 무한 loop 상태임
      if (i > 100)
        break;
    }
    System.out.println("\n" + "#3 while 문을 이용한 계산 sum = " + sum);

    i = 0;
    sum = 0;

    while (true) {
      sum += i++;
      if (i <= 100)
        continue;
      else
        break;
    }
    System.out.println("\n" + "#4 while 문을 이용한 계산 sum = " + sum);

    i = 0;
    sum = 0;

    do {
      sum += i++;
    } while (i <= 100);
    System.out.println("\n" + "#5 do-while 문을 이용한 계산 sum = " + sum);

  }
}
