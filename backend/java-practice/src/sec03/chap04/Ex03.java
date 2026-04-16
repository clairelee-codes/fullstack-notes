package sec03.chap04;
// 불리언 자료형과 관련 연산자
public class Ex03 {
    static void main() {

        // 단축평가 short circuit
        int a = 1, b = 2, c = 0, d = 0, e = 0, f = 0;

        boolean bool1 = a < b && c++ < (d += 3);
        boolean bool2 = a < b || e++ < (f += 3);

        boolean bool3 = a > b && c++ < (d += 3);
        boolean bool4 = a > b || e++ < (f += 3);
    }
}
