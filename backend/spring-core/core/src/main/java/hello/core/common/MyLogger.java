package hello.core.common;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
// @Scope(value = "request")   // HTTP 요청 당 하나씩 생성되고 HTTP 요청이 끝나는 시점에 소명 -> 처음에 의존성에 지연해야함.
@Scope(value = "request", proxyMode = ScopedProxyMode.TARGET_CLASS) // 가짜 프록시 객체 생성 -> 의존관계 주입 (또는 ObjectProvider 사용)
public class MyLogger {
    private String uuid;
    private String requestURL;

    // `requestURL`는 이 빈이 생성되는 시점을 알 수 없으므로 외부에서 setter로 입력 받는다.
    public void setRequestURL(String requestURL) {
        this.requestURL = requestURL;
    }

    public void log(String message) {
        System.out.println("[" + uuid + "]" + "[" + requestURL + "]" + message);
    }

    @PostConstruct
    public void init() {
        uuid = UUID.randomUUID()
                .toString();
        System.out.println("[" + uuid + "] request scope bean create:" + this);

    }

    @PreDestroy
    public void close() {
        System.out.println();
        System.out.println("[" + uuid + "] request scope bean close:" + this);
    }

}
