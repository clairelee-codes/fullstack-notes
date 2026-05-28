package sec09.chap01;
// 람다식과 함수형 인터페이스
@FunctionalInterface
public interface  Printer {
    void print();

    // void say (); // ⚠️ 둘 이상의 메소드는 불가
}
