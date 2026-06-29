package sec11.chap06.ex02;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class FutureExp {
    static void main(String[] args) {

        ExecutorService es = Executors.newSingleThreadExecutor();

        //  💡 submit 메소드 : Callable을 받아 Future 반환
        //  - 'String을 받아올 임무를 가진 것'이란 의미
        //  - execute 메소드(Runnable을 받음)와 비교
        Future<String> callAnswer = es.submit(() -> {
            Thread.sleep(2000);
            return "여보세요";
        });

        //  ⭐ get 메소드를 호출하기 전까지는 막히지 않고 동시에 진행
        //  - Future의 Callable은 다른 쓰레드에서 진행됨

        //  💡 isDone 메소드 : 퓨쳐의 태스크가 종료되었는지 여부 확인
        while (!callAnswer.isDone()) {
            System.out.println("📞 따르릉...");
            try {
                Thread.sleep(400);
            } catch (InterruptedException e) {
            }
        }

        String result = null;

        //  💡 get 메소드 : 해당 퓨쳐 쓰레드의 작업이 끝난 뒤 결과를 받아옴
        //  - ⭐ 이를 완료하기까지 그 뒤의 작업들이 막힘 (블로킹)
        //  - 대안을 위해 CompletableFuture가 나옴
        try {
            result = callAnswer.get();
        } catch (InterruptedException | ExecutionException e) {
        }

        System.out.println("✅ 통화 시작 - " + result);
        System.out.println("- - - 작업 종료 - - -");

        es.shutdown();
    }
}
