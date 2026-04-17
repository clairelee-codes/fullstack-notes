package sec03.chap01;

public class Ex05 {
    static void main() {

        // 복합연산자
        int a = 1;
        a = a + 2;
        a += 3; // 🔴
        // 값을 반환하기도 함
        int b = a += 4; // �

        // 💡 추가
        // - 일반 대입 연산자도 값을 반환함
        int i1 = 0;
        int i2 = 1;
        int i3 = (i1 = i2); // 괄호 제거해도 같음
        String s1 = "ABC";
        String s2 = "가나다";
        String s3 = (s1 = s2);
    }
}
