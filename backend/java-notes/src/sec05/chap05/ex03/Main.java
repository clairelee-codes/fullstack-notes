package sec05.chap05.ex03;

// 상속
public class Main {
    static void main(String[] args) {

        Slime slime = new Slime();
        FireSlime fireSlime = new FireSlime();

        slime.attack(fireSlime); // ⭐ 클래스가 다른데 가능한 이유 : chap06. 다형성 참고
        fireSlime.attack(slime);

    }
}
