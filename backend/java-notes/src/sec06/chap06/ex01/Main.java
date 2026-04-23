package sec06.chap06.ex01;
// enum
public class Main {
    static void main(String[] args) {

        Button button1 = new Button();

        button1.setButtonMode(ButtonMode.DARK);
        button1.setButtonSpace(ButtonSpace.TRIPLE);

        //  ⚠️ 아래와 같은 오용이 방지됨
        // button1.setButtonMode(ButtonSpace.DOUBLE);
    }
}
