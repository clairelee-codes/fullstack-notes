package sec05.chap09.ex02;

public interface FoodSafety {
    //  ⭐️
    //  static 제거하면 컴파일 오류
    //  static abstract는 역시 불가 (추상 클래스처럼)
    static void announcement () {
        System.out.println("식품안전 관련 공지");
    }

    //  ⭐️
    //  default 제거하면 컴파일 오류
    default void regularInspection () {
        System.out.println("정기 체크");
    }

    // 추상 메소드
    void cleanKitchen ();
    void employeeEducation ();
}
