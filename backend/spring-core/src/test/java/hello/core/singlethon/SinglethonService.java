package hello.core.singlethon;

public class SinglethonService {
    // 1. static 영역에 객체를 딱 1개만 생성한다.
    private static final SinglethonService instance = new SinglethonService();

    // 2. public으로 열어서 객체 인스턴스가 필요하면 이 static 메서드를 등해서만 조회하도록 허용한다.
    private SinglethonService() {

    }

    // 3. 생성자를 private으로 선언해서 외부에서 new 키워드를 사용한 객체 생성을 못하게 막는다.
    public static SinglethonService getInstance() {
        return instance;
    }


    public void logic() {
        System.out.println("싱글톤 객체 로직 호출");
    }
}
