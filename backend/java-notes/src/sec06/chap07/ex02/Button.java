package sec06.chap07.ex02;

public class Button {
    public enum ClickedBy {
        LEFT('좌'), RIGHT('우') ;
        private char indicator;
        ClickedBy(char indicator) { this.indicator = indicator; }
        public char getIndicator() { return indicator; }
    }

    //  ⭐️
    //  다른 클래스에 내부로 포함 가능
    //  인터페이스 구현 가능 (클래스 상속은 불가)
    public record ClickInfo(
            int x, int y, ClickedBy clickedBy
    ) implements InfoPrinter {

        //  💡 클래스 필드를 가질 수 있음 (인스턴스 필드는 불가)
        static String desc = "버튼 클릭 정보";
        // string desc = "버튼 클릭 정보"; // 불가

        //  💡 인스턴스/클래스 메소드를 가질 수 있음
        @Override
        public void printInfo() {
            System.out.printf(
                    "%c클릭 (%d, %d)%n",
                    clickedBy.indicator, x, y
            );
        }
    }

    public ClickInfo func (int x, int y, ClickedBy clickedBy) {
        System.out.println("버튼 동작");
        return new ClickInfo(x, y, clickedBy);
    }
}
