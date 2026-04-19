package sec05.chap04.ex01;
// 접근 제어자 (접근 제한자, access modifier)
public class Main {
    static void main(String[] args) {

        SmartPhone phone = new SmartPhone();

        String pb = phone.powerButton;
        String ss = phone.sdCardSlot;
        // String cu = phone.cpu; // ⚠️ 접근불가
    }
}
