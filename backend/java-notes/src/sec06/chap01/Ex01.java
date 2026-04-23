package sec06.chap01;
// 블록과 스코프
public class Ex01 {
    static void main(String[] args) {

        //  💡 { } 로 블록 생성
        {
            int x = 1;
            System.out.println(x);
        }


        //  💡 블록 안에서 선언된 것은 밖에서 사용 불가
        {
            int intNum = 123;
            String str = "블록 밖은 위험해";
        }

        // intNum = 234;
        // System.out.println(str);



        //  💡 블록 안쪽에서는 바깥의 것 사용 가능
        String x = "전국구 보스";

        {
            String y = "동네 양아치";
            System.out.println(x);
            System.out.println(y);
        }

        System.out.println(x);
        // System.out.println(y); // ⚠️ 불가



        int z = 1;

        for (int i = 0; i < 5; i++) {
            System.out.println(z + i);
        }

        // System.out.println(i); // ⚠️ 불가
    }
}
