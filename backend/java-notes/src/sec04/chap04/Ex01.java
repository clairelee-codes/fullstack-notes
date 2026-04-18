package sec04.chap04;
// while & do while
public class Ex01 {
    static void main() {

        int i = 0;

        //  💡 while 문의 괄호에는 종료조건만
        while (i < 10) {
            // 종료조건 충족을 위한 값 변화는 외적으로
            System.out.println(i++);
        }

        //  💡 의도적인 무한 루프에 널리 쓰이는 코드
        // while (true) {
        //     System.out.println("인간의 욕심은 끝이 없고");
        //     System.out.println("같은 실수를 반복한다.");
        // }

        double popInBillion = 7.837;

        //  ⭐️ break 를 통한 반복 탈출
        while (true) {
            System.out.println("세계인구: " + (popInBillion -= 0.1));
            if (popInBillion <= 0) break;

            System.out.println("인간의 욕심은 끝이 없고");
            System.out.println("같은 실수를 반복한다.");
        }

        System.out.println("인류 멸종");
    }
}

