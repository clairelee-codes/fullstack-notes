package sec06.chap01;
// 블록과 스코프
public class Ex04 {

    public static void main(String[] args) {
        // 바깥의 변수 재선언 불가
        new Ex04().printKings();
    }

    String king = "사자";

    void printKings () {
        String king = "여우"; // 💡 그럼 이건 뭔가요??

        //  ⭐️ 인스턴스의 필드는 다른 영역으로 간주
        System.out.printf(
                "인스턴스의 왕은 %s, 블록의 왕은 %s%n",
                this.king, king
        );
    }
}
