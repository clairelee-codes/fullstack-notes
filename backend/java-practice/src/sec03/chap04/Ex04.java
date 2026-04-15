package sec03.chap04;
// 불리언 자료형과 관련 연산자
public class Ex04 {
    static void main() {

        // 삼항 연산자
        int num1 = 3, num2 = 4;

        char num1OE = num1 % 2 == 1 ? '홀' : '짝';
        char num2OE = num2 % 2 == 1 ? '홀' : '짝';



        int num = 3;
        boolean mult2 = true;
        //mult2 = false;
        boolean plus5 = true;
        //plus5 = false;

        System.out.println(
                (!mult2 && !plus5) ? num
                        : (mult2 && plus5) ? num * 2 + 5
                        : mult2 ? num * 2
                        : num + 5
        );



        int x = 1, y = 2;

        //  💡 단축평가 적용됨
        int changed1 = x < y ? (x += 2) : (y += 2);
        int changed2 = x < y ? (x += 2) : (y += 2);
        int changed3 = x < y ? (x += 2) : (y += 2);
        int changed4 = x < y ? (x += 2) : (y += 2);
        int changed5 = x < y ? (x += 2) : (y += 2);
    }
}
