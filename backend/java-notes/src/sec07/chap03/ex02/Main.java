package sec07.chap03.ex02;
// 제네릭
public class Main {
    static void main(String[] args) {

        //  선언시 아래와 같이 자료형에 각 타입변수의 자료형을 명시
        //  - 제내릭에는 원시값이 아닌 참조타입(클래스)만 사용 가능 (double X / Double O)
        //  - 내부적으로 Object기반으로 동작하기 때문
        //  - (래퍼 클래스의 또 다른 존재 이유 -> 제네릭에 쓸려고)
        Pocket<Double, Double, Double> size3d1 =
                new Pocket<>(123.45, 234.56, 345.67);

        //  타입추론도 가능은 함
        var size3d2 =
                new Pocket<>(123.45, 234.56, 345.67);

        double width = size3d1.getFieldA();
        double height = size3d1.getFieldB();
        double depth = size3d1.getFieldC();

        Pocket<String, Integer, Boolean> person =
                new Pocket<>("홍길동", 20, false);

        //  제네릭 클래스는 배열 생성시 new로 초기화 필수
        Pocket<String, Integer, Boolean>[] people = new Pocket[] {
                new Pocket<>("홍길동", 20, false),
                new Pocket<>("전우치", 30, true),
                new Pocket<>("임꺽정", 27, true),
        };
    }
}
