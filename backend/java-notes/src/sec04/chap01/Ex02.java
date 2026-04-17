package sec04.chap01;
// if/else
public class Ex02 {

    static void main() {

        boolean willOrderCoffee = true;
        boolean likeMilk = false;
        boolean likeIce = true;
        boolean likeSweet = false;
        boolean angry = false;
        int myRank = 2;

        //  💡 중첩 사용
        if (willOrderCoffee) {

            String toOrder = "";

            //  필요에 따라 적절한 것 사용
            toOrder = likeMilk ? "라떼" : "아메리카노";
            if (likeIce) toOrder = "아이스 " + toOrder;
            if (!likeSweet) toOrder += " 안단티노";

            System.out.printf("저는 %s 할게요%n", toOrder);
        } else {
            if (!angry || myRank > 3) {
                System.out.println("저는 괜찮아요.");
            } else {
                System.out.println("너님들끼리 드세요.");
            }
        }
    }
}
