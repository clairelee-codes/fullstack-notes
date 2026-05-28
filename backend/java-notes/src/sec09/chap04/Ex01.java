package sec09.chap04;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Ex01 {
    static void main(String[] args) {
        List<Integer> int0To9 = new ArrayList<>(
                 Arrays.asList(5,2,0,8,4,1,7,9,3,6)
        );

        // 홀수만 골라낸 다음 정렬하여 "1, 3, 5..."와 같은 문자열로 만들기

        // 기존 방식
        List<Integer> odds = new ArrayList<>();
        for (Integer i:int0To9){
            if(i%2==1)odds.add(i);
        }

        odds.sort(Integer::compare);

        List<String> oddsStrs = new ArrayList<>();
        for(Integer i: odds) {
            oddsStrs.add(String.valueOf(i));
        }
        String oddsStr = String.join(",",oddsStrs);

        // 스트림을 사용한 방식
        String oddsStrStreamed = int0To9
                .stream()
                .filter(i->i%2==1)
                .sorted(Integer::compare)
                .map(String::valueOf)
                .collect(Collectors.joining(","));

        // 함수형인터페이스 메소드참조형 풀어쓴것
        // String oddsStrStreamed = int0To9
        //         .stream()
        //         .filter(new Predicate<Integer>() {
        //             @Override
        //             public boolean test(Integer i) {
        //                 return i % 2 == 1;
        //             }
        //         })
        //         .sorted(new Comparator<Integer>() {
        //             @Override
        //             public int compare(Integer a, Integer b) {
        //                 return Integer.compare(a, b);
        //             }
        //         })
        //         .map(new Function<Integer, String>() {
        //             @Override
        //             public String apply(Integer i) {
        //                 return String.valueOf(i);
        //             }
        //         })
        //         .collect(Collectors.joining(","));
    }
}
