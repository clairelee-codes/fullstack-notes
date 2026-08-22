package hello.servlet.web.springmvc.old;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.jspecify.annotations.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.HttpRequestHandler;
import org.springframework.web.servlet.HandlerMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;
import org.springframework.web.servlet.mvc.HttpRequestHandlerAdapter;
import org.springframework.web.servlet.mvc.SimpleControllerHandlerAdapter;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;
import org.springframework.web.servlet.view.BeanNameViewResolver;

// HandlerMapping
// 0 = RequestMappingHandlerMapping : 애노테이션 기반의 컨트롤러인 @RequestMapping에서 사용
// 1 = BeanNameUrlHandlerMapping : 스프링 빈의 이름으로 핸들러(컨트롤러) 찾음

// HandleAdapter
// 0 = RequestMappingHandlerMapping : 애노테이션 기반의 컨트롤러인 @RequestMapping에서 사용
// 1 = HttpRequestHandlerAdapter : HttpRequestHandler 처리
// 2 = SimpleControllerHandlerAdapter : Controller 인터페이스(애노테이션X, 과거에 사용) 처리

@Component("/springmvc/old-controller")
public class OldController implements Controller {
    @Override
    public @Nullable ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        System.out.println("OldController.handleRequest");

        // 스프링 부트가 자동 등록하는 뷰 리졸버
        // 1 = BeanNameViewResolver : 빈 이름을 뷰를 찾아서 반환한다 (예: 엑셀 파일 생성 기능에 사용)
        // 2 = InternalResourceViewResolver:  JSP를 처리할 수 있는 뷰를 반환한다.
        return new ModelAndView("new-form");
    }

}
