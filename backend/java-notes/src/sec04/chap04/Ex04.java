package sec04.chap04;
// while & do while
public class Ex04 {
    static void main() {

        int LINE_WIDTH = 5;

        int lineWidth = LINE_WIDTH;

        while (lineWidth > 0) {
            int starsToPrint = lineWidth--;
            while (starsToPrint-- > 0) {
                System.out.print("*");
            }
            System.out.println();
        }

        //  for 문으로 다시 작성
        for (int i = LINE_WIDTH; i > 0; i--) {
            for (int j = i; j > 0; j--) {
                System.out.print("@");
            }
            System.out.println();
        }
    }
}

