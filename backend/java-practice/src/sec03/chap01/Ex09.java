package sec03.chap01;

public class Ex09 {
    static void main() {

        //비교 연산자
        // 값을 바꿔가면서 실행해 볼 것
        int int1 = 3;
        int int2 = 3;
        // 다른 정수 자료형끼리 사용 가능
        boolean bool1 = int1 == int2;
        boolean bool2 = int1 != int2;
        boolean bool3 = int1 > int2;
        boolean bool4 = int1 >= int2;
        boolean bool5 = int1 < int2;
        boolean bool6 = int1 <= int2;
        // 💡 우선순위에 따른 연산
        boolean bool7 = int1 * int2 > int1 + int2;
    }
}
