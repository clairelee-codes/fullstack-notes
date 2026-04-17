package sec04.chap02;
// switch
public class Ex01 {
    static void main() {

        byte fingersOut = 2;

        //  💡 switch : 괄호 안에 기준이 될 변수를 받음
        //  가능한 자료형: byte, short, int, char, String, enum(이후 배움)

        switch (fingersOut) {

            //  💡 case : 기준에 일치하는 case로 바로 이동
            //  💡 break : switch문 실행을 종료
            //  💡 default: 해당하는 case가 없을 때 - 마지막에 작성

            case 2:
                System.out.println("가위");
                break;
            case 0:
                System.out.println("바위");
                break;
            case 5:
                System.out.println("보");
                break;
            default:
                System.out.println("무효");
        }

    }
}
