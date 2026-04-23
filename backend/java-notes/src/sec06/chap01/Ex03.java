package sec06.chap01;
// 블록과 스코프
public class Ex03 {
    static void main(String[] args) {
        // 바깥의 변수 재선언 불가
        String str = "바깥쪽";
        {
            //String str = "안쪽"; // ⚠️ 불가
        }

        while (true) {
            //String str = "안쪽"; // ⚠️ 불가
        }
    }
}
