package sec07.chap02;

public class Ex02 {
    static void main(String[] args) {


        //  💡 박싱 : 원시값을 래퍼 클래스의 인스턴스로
        //  ⭐ 과거에는 생성자를 사용했으나 deprecated
        int intPrim1 = 123;
        Integer intInst1 = Integer.valueOf(intPrim1);

        char chrPrim1 = 'A';
        Character chrInst1 = Character.valueOf(chrPrim1);

        //  💡 언박싱 : 래퍼 클래스의 인스턴스를 원시값으로
        Double dblInst1 = Double.valueOf(3.14);
        double dblPrim1 = dblInst1.doubleValue();

        Boolean blnInst1 = Boolean.valueOf(true);
        boolean blnPrim1 = blnInst1.booleanValue();


        //  💡 오토박싱
        Integer intInst2 = 234;
        Double dblInst2 = 1.414213;

        //  💡 오토언박싱
        char chrPrim2 = Character.valueOf('B');
        boolean blnPrim2 = Boolean.valueOf(false);

        //  원시값과 래핑 클래스 인스턴스끼리의 연산
        int intPrim2 = intPrim1 + intInst2;
        Integer intInst3 = intPrim2 + intInst2;

        //  메소드 등 사용처들에 혼용 가능
        Integer intInst4 = add(3, 5);

    }

    static int add(Integer a, Integer b) { return a + b; }

}
