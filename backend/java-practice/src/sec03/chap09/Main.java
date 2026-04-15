package sec03.chap09;
// 타입 추론 (Java 10+)
public class Main {
    static void main() {

        // var 연산자로 변수 선언
        // 지역 변수에서만 사용 가능
        var intNum = 1;
        var doubleNum = 3.14;
        var charLet = 'A';
        var StringWord = "안녕하세요";

        //  ⚠️ 아래와 같이는 사용 불가
        //  컴파일러가 타입을 추론할 수 없는 상황
        // var notInit; // 초기화가 안 됨
        // var nullVar = null; // null로 초기화

        //  ⚠️ 자료형을 변경 불가
        // intNum = 1.23;
        // StringWord = 123;

        // 반복문에서 편리하게 사용
        for (var i = 0; i < 10; i++) {
            System.out.println(i);
        }

        //  배열의 경우 초기화시에 명시
        var chars = new char[] {'A', 'B', 'C', 'D', 'E'};
        //  var chars2 = {'A', 'B', 'C', 'D', 'E'}; // ⚠️ 불가

        for (var c : chars) {
            System.out.println(c);
        }
    }
}
