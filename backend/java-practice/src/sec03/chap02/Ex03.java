package sec03.chap02;

public class Ex03 {
    static void main() {

        // float은 뒤에 f 또는 F를 붙여 표현
        float flt1 = 3.14f;
        double dbl1 = 3.14;
        // ⚠ float에는 double을 담을 수 없음
        //float flt2 = dbl1;
        // 반대는 가능
        double dbl2 = flt1;

        long lng1 = 123;
        // 정수를 대입할 시 묵시적 변환
        // 💡 float(4바이트)에도 long(8바이트)의 값 담을 수 있음
        float flt3 = lng1;
        double dbl3 = lng1;
        long lng2 = Long.MAX_VALUE;
        // ⭐ 큰 수(정확히 표현가능한 한도를 넘어서는)일 경우
        // 가능한 최대 정확도로
        float flt4 = lng2;
        double dbl4 = lng2;

        // 💡 복합 대입 연산자와 단항 연산자
        float fl5 = 123.45F;
        fl5 += 6.78;
        //fl5++
        fl5++;
        fl5--;
    }
}
