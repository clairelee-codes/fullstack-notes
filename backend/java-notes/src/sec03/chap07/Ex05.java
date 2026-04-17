package sec03.chap07;
// 문자열의 포캐팅과 null
public class Ex05 {
    static void main() {


        // null 문자열
        String emptyStr = "";
        String nullStr = null;

        //  ⭐️ 빈 문자열과 null은 다름
        boolean bool1 = emptyStr == nullStr;

        //  ⚠️ null은 문자열 인스턴스 메소드 사용 불가
        //  아래의 코드들은 모두 런타임 에러를 발생시킴
        //int int1 = nullStr.length();
        //boolean bool2 = nullStr.equals(emptyStr);
        //String str1 = nullStr.concat("ABC");


        //  💡 문자열을 외부로부터 받아올 경우 등...
        String defaultStr =
                (nullStr != null && !nullStr.isEmpty())
                        ? nullStr : "(기본값)";

        //  💡 초기화되지 않은 변수와 비교
        String notInitStr;
        String nullStr2 = null;

        //  ⚠️ 컴파일 오류 발생
        //System.out.println(notInitStr);

        //  코드에 따라 정상실행 또는 런타임 오류
        System.out.println(nullStr2);

        //  ⭐️ 이 외에도 참조 자료형의 인스턴스는 null 가능
        Object obj = null;
        System sys = null;

        //  ⭐️ 원시값들도 참조 자료형의 인스턴스로는 null 가능
        Integer nullInt1 = null;
        Double nullDbl1 = null;
        Boolean nullBool1 = null;
        Character nullChr1 = null;

        //  ⚠️  원시값은 불가
        //int nullInt2 = null;
        //double nullDbl2 = null;
        //boolean nullBool2 = null;
        //char nullChr2 = null;
    }
}
