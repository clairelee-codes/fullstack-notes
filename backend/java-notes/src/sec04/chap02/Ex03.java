package sec04.chap02;
// switch
public class Ex03 {
    static void main() {

        //  💡 break 관련 동작방식을 이용
        char yutnori = '윷';

        switch (yutnori) {
            case '모': System.out.println("앞으로");
            case '윷': System.out.println("앞으로");
            case '걸': System.out.println("앞으로");
            case '개': System.out.println("앞으로");
            case '도': System.out.println("앞으로"); break;
            default:
                System.out.println("무효");
        }
    }
}
