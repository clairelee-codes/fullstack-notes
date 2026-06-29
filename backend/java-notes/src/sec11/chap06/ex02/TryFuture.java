package sec11.chap06.ex02;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.stream.IntStream;

public class TryFuture {
    static void main(String[] args) {
        //  💡 쓰레드 풀과 Future를 사용해서 여러 Callable 동시에 실행
        ExecutorService es = Executors.newFixedThreadPool(4);

        List<Future<Integer>> futList = new ArrayList<>();
        IntStream.range(0, 10)
                .forEach(i -> {
                    futList.add(
                            es.submit(new RollDiceCall())
                    );
                });

        es.shutdown(); // 💡 제거하면 프로그램이 끝나지 않음

        ArrayList<Integer> intList = new ArrayList<>();
        for (Future<Integer> future : futList) {
            try {
                intList.add(future.get());
            } catch (InterruptedException | ExecutionException e) {
            }
        }

        System.out.println(String.join(
                ",",
                intList.stream()
                        .map(String::valueOf)
                        .toArray(String[]::new)
        ));


    }
}
