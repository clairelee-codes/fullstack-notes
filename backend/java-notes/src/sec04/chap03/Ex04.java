package sec04.chap03;
// for & for-each
public class Ex04 {
    static void main() {

        // 중첩루프
        //  구구단 예제
        for (int i = 1; i < 10; i++) {
            for (int j = 1; j < 10; j++) {
                System.out.printf("%d X %d = %2d%n", i, j, i * j);
            }
        }

        String[][] quotesInLangs = {
                {
                        "I am vengeance.",
                        "I am night.",
                        "I am Batman.",
                },
                {
                        "나는 복수를 하지.",
                        "나는 밤이지.",
                        "나는 배트맨이지.",
                },
        };

        String result = "";
        for (String[] quotes : quotesInLangs) {
            for (String quote : quotes) {
                result += quote + " "; // 🔴
            }
            result = result.trim().concat("\n");
        }

        System.out.println(result);
    }
}
