package hello.core.web;

import hello.core.common.MyLogger;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LogDemoService {
    private final MyLogger myLogger;
    // private final ObjectProvider<MyLogger> myLoggerProvider;

    public void logic(String testId) {
        // LogDemoController, LogDemoService에서 각각 한번씩 호출해도
        // 같은 HTTP요청이면 같은 스프링 빈이 반환됨.
        // MyLogger myLogger = myLoggerProvider.getObject();
        myLogger.log("service id = " + testId);

    }
}
