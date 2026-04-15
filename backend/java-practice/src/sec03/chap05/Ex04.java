package sec03.chap05;
// 문자열과 기초 사용법
public class Ex04 {
    static void main() {

        // 타 자료형간 변환
        //  💡 타 자료형으로부터 문자열로 변환
        String str1 = String.valueOf(true);
        String str2 = String.valueOf(false);
        String str3 = String.valueOf(123);
        String str4 = String.valueOf(3.14f);
        String str5 = String.valueOf('가');

        String str6 = true + "";
        String str7 = 123.45 + "";

        String str123 = "123";

        //  문자열을 정수 자료형으로 변환하기
        byte bytNum = Byte.parseByte(str123);
        short srtNum = Short.parseShort(str123);
        int intNum = Integer.parseInt(str123);
        long lngNum = Long.parseLong(str123);

        //  대소문자 무관 'true'일 때 true 반환
        boolean bool1 = Boolean.parseBoolean("TRUE");
        boolean bool2 = Boolean.parseBoolean("true");
        boolean bool3 = Boolean.parseBoolean("T");


        String strA = "A";
        char chr = strA.charAt(0);

        // byte bytNum2 = Byte.parseByte("12345");
        // int intNum2 = Integer.parseInt("123.45");
        // double dblNum2 = Integer.parseInt("하나");
    }
}
