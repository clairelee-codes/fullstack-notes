package sec03.chap07;
// 문자열의 포캐팅과 null
public class Ex02 {
    static void main() {


        // 정수
        System.out.printf("%d, %5d, %05d%n- - - - -%n%n", 123, 123, 123);

        //  💡 정수 다양하게 포매팅하기
        String[] intFormats = {
                "%d",        // 1. 기본
                "%13d",      // 2. n 자리수 확보, 오른쪽 정렬
                "%013d",     // 3. 빈 자리수 0으로 채움
                "%+13d",     // 4. 양수는 앞에 + 붙임
                "%,13d",     // 5. 쉼표 사용
                "%-13d",     // 6. 자리수 확보, 왼쪽 정렬
                "%+,013d"    // 7.
        };

        String[] intResults = new String[intFormats.length];

        // 위의 형식들로 하나하나 출력해보는 코드
        for (var i = 0; i < intFormats.length; i++) {
            String format = (i + 1) + ". ";
            for (var j = 0; j < 4; j++) {
                format += intFormats[i] + " ";
            }
            format = format.trim() + "%n%n";  // "%d %d %d %d%n%n" ...
            //  System.out.println(format);

            //  🔍 이 숫자들을 스페이스로 구분해서 출력해 볼 것
            System.out.printf(format, 12, 2345, 67890, -1234567);

            //  ⭐️ formatted 메소드에서도 사용 가능
            intResults[i] = format.formatted(12, 2345, 67890, -1234567);
        }

    }
}
