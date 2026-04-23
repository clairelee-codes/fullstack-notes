package sec06.chap06.ex03;
// enum
public class Main {
    static void main(String[] args) {
        // enum의 추가 기능들
        // 클래스처럼 필드, 생성자, 메소드를 가질 수 있음
        YalcoChickenMenu menu1 = YalcoChickenMenu.YN;
        YalcoChickenMenu menu2 = YalcoChickenMenu.RS;
        YalcoChickenMenu menu3 = YalcoChickenMenu.XX;

        String menu1Name = menu1.getName();
        int menu2Price = menu2.getPrice();
        String menu3Desc = menu3.getDesc();

        menu2.setPrice(16000);
        int menu2NewPrice = menu2.getPrice();


        //  ⭐️ 열거형의 메소드들
        YalcoChickenMenu[] byNames = new YalcoChickenMenu[] {
                YalcoChickenMenu.valueOf("FR"),
                YalcoChickenMenu.valueOf("PP"),
                YalcoChickenMenu.valueOf("GJ"),
                //  YalcoChickenMenu.valueOf("NN"), // ⚠️ 런다임 에러
        };

        //  💡 name 메소드 : 각 항목의 이름 반환
        String[] names = new String[] {
                menu1.name(), menu2.name(), menu3.name()
        };

        //  💡 ordinal 메소드 : 순번 반환
        int[] orders = new int[] {
                menu1.ordinal(), menu2.ordinal(), menu3.ordinal()
        };

        //  💡 values 메소드 : 전체 포함된 배열 반환
        //  YalcoChickenMenu[] 자료형
        YalcoChickenMenu[] menus = YalcoChickenMenu.values();

        for (YalcoChickenMenu menu : menus) {
            System.out.println(menu.getDesc());
        }

        System.out.println("\n- - - - -\n");

        YalcoChicken store1 = new YalcoChicken();

        for (String menuName : "양념치킨,능이백숙,땡초치킨".split(",")) {
            store1.takeOrder(menuName);
        }
    }
}
