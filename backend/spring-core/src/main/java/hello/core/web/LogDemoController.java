package hello.core.web;

import hello.core.common.MyLogger;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequiredArgsConstructor    // final 필드 생성자 의존성 자동 주입
public class LogDemoController {

    private final LogDemoService logDemoService;
    // private final MyLogger myLogger;
    // request 스코프는 http요청이 와야 빈이 생성됨 -> 처음 스트링부트가 의존성 주입할때 안됨.
    // -> Provider으로 해결
    // private final ObjectProvider<MyLogger> myLoggerProvider;
    // proxyMode 사용으로 간단히
    private final MyLogger myLogger;

    @RequestMapping("log-demo")
    @ResponseBody
    public String logDemo(HttpServletRequest request) {
        // MyLogger myLogger = myLoggerProvider.getObject();
        String requestURL = request.getRequestURI()
                .toString();

        // 가짜 프록시 객체 확인 MyLogger$$SpringCGLIB$$0
        System.out.println("myLogger = " + myLogger.getClass());

        myLogger.setRequestURL(requestURL);

        myLogger.log("controller test");
        logDemoService.logic("testId");
        return "OK";
    }

}
