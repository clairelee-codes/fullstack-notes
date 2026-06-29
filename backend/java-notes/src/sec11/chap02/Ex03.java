package sec11.chap02;

import java.util.Scanner;

public class Ex03 {
    static void main(String[] args) {

        Thread tarzanSong = new Thread(new TarzanRun(10));
        tarzanSong
                // .run(); // 타잔 노래가 끝나야 입력에 응답 가능
                .start(); // ⭐ 입력 응답과 동시 진행 가능해짐

        try (Scanner sc = new Scanner(System.in)) {
            while (sc.hasNext()) {
                String line = sc.nextLine();

                if (line.equalsIgnoreCase("check")) {
                    System.out.println("아직 안 끝났니?");
                    System.out.println(
                            //  💡 isAlive : 해당 쓰레드가 진행중인지 여부
                            tarzanSong.isAlive() ? "ㅇㅇ" : "끝났어."
                    );
                }

                if (line.equalsIgnoreCase("enjoy")) {

                    System.out.println("감상할 가치가 있는 노래다.");

                    try {
                        //  💡 해당 쓰레드의 차로로 들어가서(join) - 비유적 표현
                        //  그 쓰레드의 작업이 다 끝날 때까지 기다림
                        //  ⚠️ catch 블록 요구됨 - InterruptedException 처리
                        tarzanSong.join();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    // tarzanSong.join(5000); // 일정시간 동안만 조인 가능
                }

                if (line.equalsIgnoreCase("stop")) {

                    System.out.println("아 제발 좀 닥쳐봐!");

                    //  TarzanRun 클래스의 🛑 아래 코드 주석해제해야 함
                    //  💡 해당 쓰레드의 run에 InterruptedException 발생시킴
                    //  - sleep 등에 의해 정지 상태에 있을 때
                    //    - sleep 메소드가 해당 예외를 던지는 이유
                    //  - 강제하는 것이 아니라 메시지를 던지는 것
                    //    - 해당 쓰레드에서 받아주어야 함
                    tarzanSong.interrupt();

                    //  ⭐️ 과거에는 쓰레드를 강제종료하는 stop을 사용했음
                    //  - 위험했기 때문에 deprecated
                    //    - 데이터 오염, 리소스 누수 등
                    //  - suspend, resume 등도 마찬가지
                }

                if (line.equalsIgnoreCase("quit")) break;
                System.out.println(line);
            }
        }
    }
}
