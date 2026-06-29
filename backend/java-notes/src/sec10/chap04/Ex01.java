package sec10.chap04;

import java.util.Random;

public class Ex01 {

    //  💡 RuntimeException 과 그 자손들 : unchecked 예외
    //  - 주로 개발자의 실수로 일어나는 예외 (실수 안 하면 됨)
    //  - 예외처리가 필수가 아님 (하지 않아도 컴파일 가능)
    public static void maybeException1() {
        if (new Random().nextBoolean()) {
            throw new RuntimeException();
        }
    }

    //  ⚠️ 다른 예외들은 checked 예외
    //  - 해당 메소드 내에서, 또는 호출한 곳에서 예외처리 필수
    //  - 외적 요인으로 발생하는 예외 (조심해도 소용없으므로 대비해야 함)
    //  - ⭐️ IDE의 안내에 따라 두 가지 옵션 실행해보기
    public static void maybeException2() {
        if (new Random().nextBoolean()) {
            // throw new FileNotFoundException();
        }
    }
}
