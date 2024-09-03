package com.test.stream;

import java.util.ArrayList;
import java.util.List;

class Member {
  private String name;
  private String gender;
  private int age;

  public Member(String name, String gender, int age){
    this.name = name;
    this.gender = gender;
    this.age = age;
  }

  public String getName() {
    return name;
  }
  public String getGender() {
    return gender;
  }
  public int getAge() {
    return age;
  }

}
public class Stream02 {

  public static void main(String[] args) {
    
    List<Member> list = new ArrayList<>();
    list.add(new Member("김철수", "male", 55));
    list.add(new Member("김민성", "male", 38));
    list.add(new Member("최지희", "female", 28));
    list.add(new Member("김현주", "female", 44));
    // list.stream().map(c->c.getName()).sorted().forEach(s->System.out.println("이름 : "+s));

    for(int i = 0; i < list.size(); i++) {
      System.out.println("이름 : " + list.get(i).getName() + "\t"
                         + "성별 : " + list.get(i).getGender() + "\t"
                         + "나이 : " + list.get(i).getAge() + "\t"
                        );
    }

    for(Member member : list) { // 컬렉터 전용 for 문 --> for(리스트 요소의 타입선언 : 리스트 객체명)
      System.out.println("이름 : " + member.getName() + "\t"
                         + "성별 : " + member.getGender() + "\t"
                         + "나이 : " + member.getAge() + "\t"
                        );
    }
    

  }
}
