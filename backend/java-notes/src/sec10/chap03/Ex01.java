package sec10.chap03;

import java.io.IOException;

public class Ex01 {
    static void main(String[] args) {
        //  ⭐️ 예외가 오류가 던져지면 그 아래의 코드는 작성할 수 없음
        // throw new RuntimeException();

        //  💡 메시지를 특정하여 던지기
        // throw new RuntimeException("뭔가 잘못됐어요!");

        //  💡 원인이 되는 다른 예외들을 명시하여 던지기
        throw new RuntimeException("얘네 때문임",
                new IOException(
                        new NullPointerException()
                )
        );
    }
}
