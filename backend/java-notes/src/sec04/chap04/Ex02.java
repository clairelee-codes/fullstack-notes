package sec04.chap04;
// while & do while
public class Ex02 {
    static void main() {

        //  100보다 작은 3의 배수들 출력해보기
        //int i = 1;

        // ⚠️ 의도대로 작동하지 않음. 이유는?
        // while (true) {
        //     if (i % 3 != 0) continue;
        //     System.out.println(i);
        //
        //     if (i++ == 100) break;
        // }

        // int i = 1;
        //
        // while (true) {
        //     if (i++ == 100) break;
        //     if ((i - 1) % 3 != 0) continue;
        //
        //     System.out.println(i - 1);
        // }

        int i = 1;

        //  보다 가독성을 높이고 의도를 잘 드러낸 코드
        while (true) {
            int cur = i++;

            if (cur == 100) break;
            if (cur % 3 != 0) continue;

            System.out.println(cur);

        }
    }
}

