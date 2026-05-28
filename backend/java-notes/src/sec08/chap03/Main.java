package sec08.chap03;

import sec07.chap04.Knight;
import sec07.chap04.Side;
import sec07.chap04.Swordman;

import java.util.*;

// 셋
public class Main {
    static void main(String[] args) {

        Set<Integer> intHSet1 = new HashSet<>();
        intHSet1.add(1);
        intHSet1.add(1);
        intHSet1.add(2);
        intHSet1.add(3);

        List<Integer> ints1 = new ArrayList<>(
                Arrays.asList(1,1,2,2,3,3,4,5,6,7)
        );
        Set<Integer> intHSet2 = new HashSet<>(ints1);

        // for=each문 사용 가능
        for (Integer i:intHSet1){
            System.out.println(i);
        }

        // 아래와 같이 응용 가능
        // - 중복을 제것한 ArrayList
        ints1.clear();
        ints1.addAll(intHSet2);

        // 포함 여부
        boolean has2 = intHSet1.contains(2);
        boolean has4 = intHSet1.contains(4);

        // 요소 삭제, 있었는지 여부 반환
        boolean rm3 = intHSet1.remove(3);
        boolean rm4 = intHSet1.remove(4);

        // 다른 콜렉션 기준으로 내용 삭제
        intHSet2.removeAll(intHSet2);

        // 그 외 size, isEmpty, clear, clone 등의 메소드들

        // 참조형 관련
        Set<Swordman> swordmenSet = new HashSet<>();
        Swordman swordman = new Swordman(Side.RED);

        swordmenSet.add(swordman);
        swordmenSet.add(swordman);
        swordmenSet.add(new Swordman(Side.RED));
        swordmenSet.add(new Swordman(Side.RED));
        swordmenSet.remove(swordman);

        HashSet<Integer> intHashSet = new HashSet<>();
        LinkedHashSet<Integer> intLinkedHashSet = new LinkedHashSet<>();
        TreeSet<Integer> intTreeSet = new TreeSet<>();

        for(int i : new int[] {3,1,8,5,4,7,2,9,6}){
            intHashSet.add(i);
            intLinkedHashSet.add(i);
            intTreeSet.add(i);
        }

        for(Set s : new Set[] {intHashSet, intLinkedHashSet, intTreeSet}){
            System.out.println(s);
        }
        // ⭐️ LinkedHashSet : 입련된 순서대로 / TreeSet : 오름차순
        // ⚠️ HashSet이 정렬된 것처럼 보이지만 보장된 것이 아님
        // -  Hash 방식에 의한 특정 조건에서의 정렬일 뿐

        Set<String> strHashSet = new HashSet<>();
        Set<String> strLinkedHashSet = new LinkedHashSet<>();
        TreeSet<String> strTreeSet = new TreeSet<>();

        for(String s : new String[]{
                "Fox", "Banana", "Elephant", "Car", "Apple", "Game", "Dice"
        }){
            strHashSet.add(s);
            strLinkedHashSet.add(s);
            strTreeSet.add(s);
        }

        for(Set s : new Set[] {strHashSet, strLinkedHashSet,strTreeSet}){
            System.out.println(s);
        }

        // LinkedHashSet은 추가적인 메소드는 없음.

        // 💡 TreeSet의 주요 메소드들
        int firstInt = intTreeSet.first();
        String lastStr = strTreeSet.last();

        // 같은 것이 없다면 트리구조상 바로 위의 것 (바로 더 큰 것) 반환 (>=x)
        String foxCeiling = strTreeSet.ceiling("Fox");
        String creamCeiling = strTreeSet.ceiling("Cream");

        // 같은 것이 없다면 트리구조상 바로 아래의 것 (바로 더 작은 것) 반환 (<=x)
        String foxFloor = strTreeSet.floor("Fox");
        String diceFloor = strTreeSet.floor("Cream");

        // 맨 앞에서/뒤에서 제거
        int pollFirst1 = intTreeSet.pollFirst();
        int pollFirst2 = intTreeSet.pollFirst();

        int pollLast1 = intTreeSet.pollLast();
        int pollLast2 = intTreeSet.pollLast();

        // 순서가 뒤집힌 NavigableSet 반환
        Set<String> strTreeSetDesc = (TreeSet<String>) strTreeSet.descendingSet();

        //  ⚠️ 요소로 추가 불가
        // knight는 서열이 없기 때문에 TreeSet으로 넣을 수 없음.
        //  - 이후 배울 Comparable 또는 Comparator 필요

        TreeSet<Knight> knightSet1 = new TreeSet<>();
        // knightSet1.add(new Knight(Side.BLUE));  // ⚠️ 예외 발생
        // knightSet1.add(new Knight(Side.BLUE));
        // knightSet1.add(new Knight(Side.BLUE));


    }
}
