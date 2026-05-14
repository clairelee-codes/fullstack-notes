package sec07.chap03.ex03;

import sec05.chap09.ex01.*;

public class Main {
    static void main(String[] args) {

        double sum1 = add2Num(12, 34.56);
        // double sum2 = add2Num("1" + true); // ⚠️ 불가
        
        descHuntingMamal(new PolarBear());
        // descHuntingMamal(new GlidingLizard()); // ⚠️ 불가

        descFlyingHunter(new Eagle());
        descFlyingHunter(new GlidingLizard());
        // descFlyingHunter(new PolarBear()); // ⚠️ 불가


    }

    //  💡 T는 Number를 상속한 클래스이어야 한다는 조건
    public static <T extends Number> double add2Num(T a, T b) {
        return a.doubleValue() + b.doubleValue();
    }
    //  ❓ 그냥 Number를 인자 자료형으로 하면 되지 않을까?

    //  ⭐ 상속받는 클래스와 구현하는 인터페이스(들)을 함께 조건으로
    //  여기서는 클래스와 인터페이스 모두 extends 뒤에 &로 나열
    public static <T extends Mammal & Hunter & Swimmer>
    void descHuntingMamal (T animal)  {
        //  ⭐️ 조건에 해당하는 필드와 메소드 사용 가능
        System.out.printf("겨울잠 %s%n", animal.hibernation ? "잠" : "자지 않음");
        animal.hunt();
    }

    public static <T extends Flyer & Hunter>
    void descFlyingHunter (T animal) {
        animal.fly();
        animal.hunt();
    }
}
