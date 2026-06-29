package sec11.chap03;

import java.util.Scanner;

public class Ex02 {
    static void main(String[] args) {

        ThreadGroup groupA = new ThreadGroup("A");
        ThreadGroup groupB = new ThreadGroup("B");
        ThreadGroup groupBB = new ThreadGroup(groupB, "BB");
        ThreadGroup groupC = new ThreadGroup("C");

        for (ThreadGroup tg : new ThreadGroup[]{groupA, groupB, groupBB, groupC}) {
            for (int i = 0; i < 3; i++) {
                new Thread(tg, new PrintThread(tg.getName())).start();
            }
        }

        try (Scanner sc = new Scanner(System.in)) {
            while (sc.hasNext()) {
                String line = sc.nextLine();

                if (line.length() == 1) {
                    ThreadGroup[] groups = new ThreadGroup[]{
                            groupA, groupB, groupC
                    };

                    if ("abc".contains(line)) {
                        ThreadGroup group = groups["abc".indexOf(line)];

                        //  💡 그룹의 현황 파악
                        //  - 다른 메소드들도 살펴볼 것
                        System.out.printf(
                                "%s : %d / %d%n",
                                group.getName(),
                                group.activeCount(),
                                //  내부의 쓰레드들이 멈춰도 active로 카운트
                                group.activeGroupCount()
                        );
                    }

                    if ("ABC".contains(line)) {
                        //  그룹 일괄 종료
                        ThreadGroup group = groups["ABC".indexOf(line)];
                        group.interrupt();
                    }
                }

                if (line.equalsIgnoreCase("quit")) break;
            }
        }
    }
}
