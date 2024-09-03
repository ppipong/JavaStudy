package com.test.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import com.test.exam.ArrayExam01;

public class StreamExam01 {

    public static void main(String[] args) {
        /*
         * stream API의 정의 및 등장 배경
         * - 자바에서는 많은 양의 데이터를 저장하기 위해서는 배열이나 컬렉션을 사용
         * - 배열이나 컬렉션에 저장된 데이터에 접근하기 위해서는
         * - 반복문을 사용해서 매번 새로운 코드를 작성해야 함.
         * - 하지만, 이렇게 작성된 코드는 길이가 너무 길고 가독성도 떨어지며,
         * - 코드의 재사용이 거의 불가능.
         * - 이러한 문제점을 극복하기 위해서 Java SE 8부터 함수형 프로그래밍의
         * - 특성을 가진 stream API가 도입.
         * - 스트림 API는 데이터를 추상화하여 다루므로, 다양한 방식으로
         * - 저장된 데이터를 읽고 쓰기 위한 공통된 방법을 제공.
         * 
         * *** stream API의 특성
         * 1. 스트림은 외부 반복을 통해 작업하는 컬렉션과는 달리 
         *    내부 반복(internal iteration)을 통해 작업을 수행.
         * 2. 스트림은 재사용이 가능한 컬렉션과는 달리 단 한 번만 사용.
         * 3. 스트림은 원본 데이터를 변경하지 않음.
         * 4. 스트림의 연산은 필터-맵(filter-map) 기반의 API를 사용하여
         *    지연(lazy) 연산을 통해 성능을 최적화.
         * 5. 스트림은 parellelStream() 메소드를 통한 손쉬운 병렬 처리를 지원.
         * 
         * *** stream API 동작 흐름
         *  데이터 소스 --> 스트림 생성 --> 중개연산(필터) --> 중개연산(map)
         *      --> 최종 연산(출력)
         */

        //스트림 API 예제
        //1~10까지의 정수를 갖는 list 컬렉션에서 6보다 작고, 짝수인 요소를 찾아
        //이 값들을 10배 증가시킨 결과물을 리스트 형태로 출력

        //asList --> 배열 형태로 입력된 값을 list 형태로 변환
        //1. 데이터 소스 생성
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        //2. 스트림을 생성 --> 중개연산 -->
        list.stream().filter(i -> i < 6)
                     .filter(i -> i % 2 == 0)
                     .map(i -> i * 10)
                     .collect(Collectors.toList())
                     .forEach(result -> System.out.println(result + " "));
        
        //1. 스트림 생성
        /* 
         - 자바에서 제공하는 모든 컬렉션의 최고 상위 객체인 Collection 인터페이스에는
           stream() 메소드가 정의되어 있음.
         - 따라서, Collection 인터페이스를 구현한 List와 Set 컬렉션 클래스에서도
           stream 메소드를 생성할 수 있음.
         - 배열에 관한 스트림을 생성하기 위해서는 Arrays 클래스를 이용해서
           stream 메소드로 스트림을 생성할 수 있음.
         - 자바 스트림 생성용 메소드는 기본 타입인 int, long, double을 저장할 수 있는
           스트림이 별도로 정의되어 있음
         - 이 러한 스트림은 java.util.stream 패키지의 IntStream, LongStream, DoubleStream이라는
           인터페이스로 각각 제공...
         */

        System.out.println("\n <--- 리스트 객체로부터 스트림 생성 --->");
        ArrayList<Integer> arrayList = new ArrayList<Integer>();

        arrayList.add(4);
        arrayList.add(2);
        arrayList.add(3);
        arrayList.add(1);

        Stream<Integer> stream = arrayList.stream(); // 컬렉션에서 스트림 생성
        stream.forEach(System.out::println); // forEach() 메소드를 이용한 스트림 요소

        arrayList.stream().forEach(e-> System.out.println("arrayList 요소값 : " + e));

        System.out.println("<!--- 배열로부터 스트림 생성 --->");
        int[] Arr = {1,2,3,4,5,6,7,8,9,10};
        IntStream stream2 = Arrays.stream(Arr);
        stream2.forEach(System.out::println);

        System.out.println("<!--- 가변매개변수로부터 스트림 생성 --->");

        Stream<Double> stream3 = Stream.of(4.2, 2.5, 3.1, 1.9);
        stream3.forEach(System.out::println);

        // 2. 스트림 중개 연산
        /* 
         * 스트림 API에 의해 생성된 초기 스트림은 중개 연산을 통해 또 다른 스트림으로 변환
         * 이러한 중개 연산은 스트림을 전달 받아 스트림을 반환하므로, 중개 연산을 연속으로 연결해서 사용 가능
         * 스트림의 중개 연산은 필터 - 맵(filter-map) 기반의 API를 사용함으로서 지연(lazy) 연산을 통해 성능을 최적화 한다
         * 
         * 1) 스트림 필터링 : filter(), distinct()
         * 2) 스트림 변환 : map(), flatMAp()
         * 3) 스트림 제한 : limit(), skip()
         * 4) 스트림 정렬 : sorted()
         * 5) 스트림 연산 결과 확인 : peek()
         * 
         */

        System.out.println("<!--- 스트림 필터링 : 스트림에서 중복된 요소를 제거하고 홀수만을 고라내어 출력 --->");
        IntStream stream4 = IntStream.of(7,5,5,2,1,2,3,5,4,6);
        stream4.distinct().filter(n -> n%2 != 0).forEach(System.out::println);

        System.out.println("<!--- 스트림 변환 : 문자열로 이루어진 스트림을 map() 메소드를 이용하여 각 문자열의 길이로 이루어진 스트림으로 변환 --->");
        Stream<String> stream5 = Stream.of("HTML", "CSS", "JAVA", "JAVASCRIPT");
        stream5.map(s -> s.length()).forEach(System.out::println);

        System.out.println("<!--- 스트림 변환 : 여러 문자열이 저장된 배열을 각 문자열에 각 문자열에 포함된 단어로 이루어진 스트림으로 변환 --->");
        String[] arr1 = {"I study hard", "you study java", "I am hungru"};
        Stream<String> stream6 = Arrays.stream(arr1);
        stream6.flatMap(s -> Stream.of(s.split(" "))).forEach(System.out::println);

        System.out.println("<!--- 스트림 제한 --->");
        /* limit() : 해당 스트림의 첫번째 요소부터 전달된 갯수만큼의 요소만으로 이루어진 새로운 스트림을 반환 
         * skip() : 해당 스트림의 첫번째 요소부터 전달된 갯수만큼의 요소를 제외한 나머지 요소만으로 이루어진 새로운 스트림으로 반환
        */

        IntStream stream7 = IntStream.range(0, 10); // 0부터 시작된 10개의 수를 리턴
        stream7.skip(4).forEach(n -> System.out.print(n + " "));

        // stream7.limit(5).forEach(n -> System.out.print(n + " "));

        System.out.println("<!--- 스트림 정렬 --->");
        // 오름차순
        Stream<String> stream8 = Stream.of("Park", "kim", "Lee", "Choi");
        stream8.sorted().forEach(s-> System.out.print(s + " "));

        System.out.println();

        // 내림차순
        Stream<String> stream9 = Stream.of("Park", "kim", "Lee", "Choi");
        // stream9.sorted(Comparator.reverseOrder()).forEach(s-> System.out.print(s + " "));

        /* 스트림 최종 연산
         * 
         * 1. 요소의 출력 : forEach()
         * 2. 요소의 소모 : reduce() -> reduce() 메소드는 첫번째와 두번째 요소를 가지고 
         *                연산을 수행한 뒤, 첫번째 및 요소의 값을 삭제 시키고,
         *                그 결과와 세번째 요소를 가지고 또 다시 연산을 수행
         *                이런 식으로 해당 스트림의 모든 소모를 차례차례 소모하면서
         *                연산을 수행하고 그 결과를 반환
         * 3. 요소의 검색 : findFirst(), findAny()
         * 4. 요소의 검사 : anyMatch(), allMatch, noneMatch()
         * 5. 요소의 통계 : count(), min(), max()
         * 6. 요소의 연산 : sum(), average()
         * 7. 요소의 수집 : collect --> 
         *                  1) 스트림의 요소들을 List 또는 Set 자료형로 변환
         *                  2) 스트림의 요소들을 정렬해서 가장 큰 객체 리턴
         *                  3) 스트림 요소들의 평균 값을 리턴
         */

        System.out.println("<!--- reduce() 메소드를 이용하여 1부터 100까지의 합을 구하기 --->");
        Stream<Integer> numbers = Stream.of(1,2,3,4,5,6,7,8,9,10);
        Optional<Integer> sum = numbers.reduce((x,y)-> x + y);
        sum.ifPresent(s -> System.out.println("sum = " + s));
        
    }

}