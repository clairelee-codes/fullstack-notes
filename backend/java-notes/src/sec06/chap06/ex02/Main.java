package sec06.chap06.ex02;
// enum
public class Main {
    static void main(String[] args) {
        // 클래스 내부에 작성하여 오용 여지 제거하기
        Button button1 = new Button();

        button1.setMode(Button.Mode.DARK);
        button1.setSpace(Button.Space.DOUBLE);
    }
}
