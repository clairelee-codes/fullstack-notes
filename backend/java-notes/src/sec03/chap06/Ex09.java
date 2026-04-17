package sec03.chap06;
// 문자열의 메소드들
public class Ex09 {
    static void main() {

        // 배열 반환
        String str1 = "가나다라마";
        String str2 = "010-1234-5678";
        String str3 = "하나 둘 셋 넷 다섯";

        //  💡 toCharArray : 문자열을 분할하여 문자의 배열로 반환
        char[] chAry1 = str1.toCharArray();
        char[] chAry2 = str3
                .replace(" ", "")
                .toCharArray();

        //  💡 split : 주어진 기준으로 (~개까지) 분할하여 문자열 배열로 반환
        String[] strAry1 = str1.split("");
        String[] strAry2 = str2.split("-");
        String[] strAry3 = str3.split(" ");
        String[] strAry4 = str3.split(" ", 3);

    }
}
