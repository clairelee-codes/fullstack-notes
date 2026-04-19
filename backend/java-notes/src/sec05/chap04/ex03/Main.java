package sec05.chap04.ex03;
// 접근 제어자 (접근 제한자, access modifier)
public class Main {
    static void main(String[] args) {

        // Getter 와 Setter
        Product ballPen = new Product("볼펜", 1000);

        ballPen.setName("삼색볼펜");
        ballPen.setName("");

        int ballPenPrice = ballPen.getPrice();

        ballPen.setPrice(1500);
    }
}
