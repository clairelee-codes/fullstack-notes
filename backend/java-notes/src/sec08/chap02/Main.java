package sec08.chap02;
// 리스트
import sec07.chap04.*;

import java.util.*;

public class Main {
    static void main(String[] args) {

        //  ⭐️ 제네릭을 사용하여 타입 지정
        //  - 붙이지 않을 시 <Object>와 동일
        LinkedList<Integer> ints1 = new LinkedList<>();
        LinkedList<String> strings = new LinkedList<>();
        LinkedList<Number> numbers = new LinkedList<>();
        LinkedList<Knight> knights = new LinkedList<>();

        //  add 메소드로 요소 추가
        ints1.add(11);
        ints1.add(22);
        ints1.add(33);
        ints1.add(44);
        ints1.add(55);

        //  요소 중복 허용
        for (var str : "바니 바니 바니 바니 당근 당근".split(" ")) {
            strings.add(str);
        }

        // for-each 문 사용 가능
        for (int i : ints1) {
        System.out.println(i);
        }


        int ints1Size = ints1.size(); // 요소 개수
        boolean ints1IsEmpty = ints1.isEmpty(); // size가 0인지 여부 반환
        int ints12nd = ints1.get(1); // 인덱스로 요소 접근
        boolean ints1Con3 = ints1.contains(33); // 포함 여부
        boolean ints1Con6 = ints1.contains(66);

        ints1.set(2, 444); // 위치의 요소 수정
        ints1.add(0, 11); // 위치에 요소 추가 (다음 요소들 밀어냄)

        //  ⭐️ 간략한 생성 및 초기화 방법들
        LinkedList<Integer> ints2A = new LinkedList<>(
                Arrays.asList(1, 2, 3, 4, 5)
        ); // 💡 Arrays 클래스 : 배열 관련 각종 기능 제공

        LinkedList<Integer> ints2B = new LinkedList<>(
                List.of(1, 2, 3, 4, 5)
        ); // 💡 자바9에서부터 가능

        LinkedList<Integer> ints2C = new LinkedList<>();
        Collections.addAll(ints2C, 1, 2, 3, 4, 5);

        //  💡 다른 Collection 인스턴스를 사용하여 생성
        LinkedList<Integer> ints3 = new LinkedList<>(ints1);

        //  스스로를 복제하여 반환 (⚠️ 얕은 복사)
        LinkedList<Integer> ints4 = (LinkedList<Integer>) ints3.clone();

        ints3.remove(4); // int: 인덱스로 지우기
        ints3.remove((Integer) 55); // 클래스 자료형: 요소로 지우기
        ints1.removeAll(ints3); // 주어진 콜렉션에 있는 요소들 지우기

        ints1.addAll(ints3); // 콜렉션 이어붙이기

        //  💡 toArray - Object 배열 반환
        Object[] intsAry2_Obj = ints1.toArray();

        //  ⭐️ 특정 타입의 배열로 반환하려면?
        //  Integer[] ints1Ary1 = (Integer[]) ints1.toArray(); // ⚠️ 이렇게는 불가
        //  💡 인자로 해당 타입 배열의 생성자를 넣어줌
        //  - 다음 섹션에 배울 메소드 참조 사용 (9-3강 수강 후 다시 볼 것)
        Integer[] ints1Ary2 = ints1.toArray(Integer[]::new);

        ints1.clear(); // 리스트 비움

        //  제네릭 적용
        numbers.add(Integer.valueOf(123));
        numbers.add(3.14);
        // numbers.add("Hello"); // ⚠️ 불가

        // knights.add(new Swordman(Side.BLUE)); // ⚠️ 불가
        knights.add(new Knight(Side.BLUE));
        knights.add(new MagicKnight(Side.RED));

        //  와일드카드 적용
        //  기사 이상의 그룹으로만 편성될 수 있는 정예분대
        LinkedList<? extends Knight> eliteSquad;

        // eliteSquad = new LinkedList<Swordman>(); // ⚠️ 불가
        eliteSquad = new LinkedList<Knight>();
        eliteSquad = new LinkedList<MagicKnight>();

        //  ⭐️ 인스턴스 요소를 지울 때는 참조를 기준으로
        //  - 내용이 같다고 같은 인스턴스가 아님
        Knight knight1 = new Knight(Side.RED);
        knights.add(knight1);

        //  요소가 하나 지워졌는지 여부 반환
        boolean removed1 = knights.remove(new Knight(Side.RED));    // 참조형은 값이 같다고 같은것이 아님 -> 안지워짐.
        boolean removed2 = knights.remove(knight1);


        //  ⭐️ ArrayList와 LinkedList 둘의 차이와 연관지어 생각해 볼 것

        //  💡 ArrayList에만 있는 메소드들 중...
        ArrayList<Attacker> attackers = new ArrayList<>();
        //  자주 쓰이지는 않음
        attackers.ensureCapacity(5); // 자리수 미리 확보
        attackers.trimToSize(); // 남는 자리 없애기 (메모리 회수)

        //  💡 LinkedList에만 있는 메소드들 중...
        LinkedList<Integer> intNums = new LinkedList<>();
        for (int intNum : new int[] {2, 3, 4}) { intNums.add(intNum); };

        intNums.addFirst(1);
        intNums.addFirst(0);
        intNums.addLast(5); // add와 반환값만 다름. 코드에서 확인해 볼 것
        intNums.addLast(6);

        //  💡 앞에서/뒤에서 꺼내지 않고 반환
        //  - peek~ : 비어있을 경우 null 반환
        //  - get~ : 비어있을 경우 익셉션
        int peekedFirst = intNums.peekFirst();
        int gottenFirst = intNums.getFirst();
        int peekedLast = intNums.peekLast();
        int gottenLast = intNums.getLast();

        //  💡 앞에서/뒤에서 꺼내어 반환
        //  - poll~ : 비어있을 경우 null 반환
        //  - remove~ : 비어있을 경우 익셉션
        int polledFirst = intNums.pollFirst();
        int removedSecond = intNums.removeFirst();
        int polledLast = intNums.pollLast();
        int removedLast = intNums.removeLast();

        //  ⭐️ 위의 기능들 활용하여 Stack/Queue 구현

        LinkedList<Character> charLList = new LinkedList<>();

        //  💡 push & pop : 스택 간편하게 구현
        //  - 클래스 코드에서 살펴볼 것

        charLList.push('A');
        charLList.push('B');
        charLList.push('C');
        charLList.push('D');
        charLList.push('E');

        char pop1 = charLList.pop();
        char pop2 = charLList.pop();
        char pop3 = charLList.pop();

        // Arrays의 ArrayList
        List<Integer> list1 = Arrays.asList(1, 2, 3, 4, 5); // ArrayList 반환
        ArrayList<Integer> list2 = new ArrayList<>(list1);

        String list1Type = list1.getClass().getName();
        String list2Type = list2.getClass().getName();

        // Arrays.asList 가 반환하는 ArrayList는 java.util.Arrays의 정적 내부 클래스
        // java.util.ArrayList 클래스와 다름.
        // list1.add(6); // ⚠️ 런타임 오류

        // 실무에서는 컬렉션 자료형을 인터페이스로
        List<Integer> intList = new ArrayList<>();
        intList = new LinkedList<>();

        Set<String> strSet = new HashSet<>();
        strSet = new TreeSet<>();

        Map<Integer, String> intStrMap = new HashMap<>();
        intStrMap = new TreeMap<>();
    }
}
