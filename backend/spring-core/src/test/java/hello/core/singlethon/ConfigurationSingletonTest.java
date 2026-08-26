package hello.core.singlethon;

import hello.core.AppConfig;
import hello.core.member.MemberRepository;
import hello.core.member.MemberServiceImpl;
import hello.core.order.OrderServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ConfigurationSingletonTest {

    @Test
    void configurationTest() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

        MemberServiceImpl memberService = ac.getBean("memberService", MemberServiceImpl.class);
        OrderServiceImpl orderService = ac.getBean("orderService", OrderServiceImpl.class);
        MemberRepository memberRepository = ac.getBean("memberRepository", MemberRepository.class);

        MemberRepository memberRepository1 = memberService.getMemberRepository();
        MemberRepository memberRepository2 = orderService.getMemberRepository();

        System.out.println("memberService -> memberRepository = " + memberRepository1);
        System.out.println("orderService -> memberRepository = " + memberRepository2);
        System.out.println("memberRepository = " + memberRepository);
    }

    @Test
    void configurationDeep() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
        AppConfig bean = ac.getBean(AppConfig.class);
        // @Configuration을 붙이면 바이트코드 조작하는 CGLIB기술을 사용해서 싱글톤을 보장.
        // 출력 결과: AppConfig$$SpringCGLIB
        System.out.println("been = " + bean.getClass());
        // 만약 @Bean만 적용한다면 순수한 AppConfig로 스프링 빈에 등록됨을 확인할 수 있음.
        // 싱글톤 보장 안됨.
        // call AppConfig.memberService
        // call AppConfig.memberRepository
        // call AppConfig.memberRepository
        // call AppConfig.orderService
        // call AppConfig.memberRepository
        // been = class hello.core.AppConfig
    }
}
