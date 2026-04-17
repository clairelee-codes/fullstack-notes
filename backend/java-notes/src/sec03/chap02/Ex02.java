package sec03.chap02;

public class Ex02 {
    static void main() {

        // float : 4byte
        // double : 8byte

        // float의 최대값과 최소값
        float fMin = -Float.MAX_VALUE;
        float fMax = Float.MAX_VALUE;

        // double의 최대값과 최소값
        double dMin = -Double.MAX_VALUE;
        double dMax = Double.MAX_VALUE;

        // 최소 절대값
        float fAbsMin = Float.MIN_VALUE;
        double dAbsMin = Double.MIN_VALUE;

        // ⭐ double이 범위도 넓고, 정밀도도 높음 확인
        boolean bool1 = Float.MAX_VALUE < Double.MAX_VALUE;
        boolean bool2 = Float.MIN_VALUE > Double.MIN_VALUE;

        // 최대 정밀도 테스트
        double dblNum = 0.123456789123456789;   // 0.12345678912345678
        float fltNum = 0.123456789123456789f;   // 0.12345679
        // float은 f붙여야함.
    }
}
