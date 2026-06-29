package sec11.chap01;

public class Main {
    static void main(String[] args) {

        //  ⭐️ 생성 방식이 다름 주목!
        Thread thread1 = new Thread1(); // Thread 상속시
        Thread thread2 = new Thread(new MyRunnable()); // Runnable 구현시

        //  ⚡️ Runnable의 익명 클래스로 생성
        Thread thread3 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 20; i++) {
                    // 😴
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    System.out.print(3);
                }
            }
        });

        //  ⚠️ 해당 쓰레드에 지정된 run 메소드를
        //  현재 메인 쓰레드에서 실행
        //  - 쓰레드 사용 의미 없음
        // thread1.run();
        // thread2.run();
        // thread3.run();

        //  💡 각각 새로운 쓰레드를 생성하여 동시에 진행
        //  - 실행시마다 결과 다를 수 있음
        thread1.start();
        thread2.start();
        thread3.start();

        for (int i = 0; i < 20; i++) {
            // 😴
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.print('M');
        }
    }
}
