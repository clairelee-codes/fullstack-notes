package sec10.chap04;

import java.util.HashMap;
import java.util.Map;

public class Ex04 {
    static void main(String[] args) {
        Map<String, Integer> dutyRegMap = new HashMap<>();
        dutyRegMap.put("정핫훈", 3);
        dutyRegMap.put("김돌준", 8);

        dutyRegMap.forEach((name, month) -> {

            //  💡 실행부에서, 혹은 또 이를 호출한 외부에서 처리해주어야 함
            try {
                chooseDutyMonth(name, month);
            } catch (WrongMonthException we) {
                we.printStackTrace(); // ⭐️ 로그에서 Caused By 항목 확인해 볼 것
                System.out.printf("%s씨, 해보자는 거지?%n", name);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public static void chooseDutyMonth(String name, int index) throws WrongMonthException {
        int[] availables = {1, 3, 4, 7, 9, 12};

        try {
            int month = availables[index - 1];
            System.out.printf("%s씨 %d월 담당으로 배정되셨어요.%n", name, month);
        } catch (ArrayIndexOutOfBoundsException ae) {
            WrongMonthException we = new WrongMonthException(
                    "%d번은 없어요.".formatted(index)
            );

            //  💡 예외의 원인이 되는 예외를 지정 (이를 수행하는 생성자가 없을 경우)
            we.initCause(ae);

            //  이 예외는 cause를 입력받는 생성자를 지정해놓았음
            // WrongMonthException we = new WrongMonthException(
            //         "%d번은 없어요.".formatted(index),ae
            // );

            //  ⭐️ 다른 종류의 예외가 발생해도 이 예외의 원인으로 등록해서
            //  통일된 타입(WrongMonthException)의 예외로 반환 가능

            throw we;
        }
    }
}
