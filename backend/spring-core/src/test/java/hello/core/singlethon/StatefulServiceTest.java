package hello.core.singlethon;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

class StatefulServiceTest {

    @Test
    void statefulServiceSingleton() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);
        StatefulService statefulService1 = ac.getBean(StatefulService.class);
        StatefulService statefulService2 = ac.getBean(StatefulService.class);

        // // ThreadA: A사용자 10000원 주문
        // statefulService1.order("userA", 10000);
        // // ThreadB: B사용자 20000원 주문
        // statefulService2.order("userB", 20000);
        //
        // // TheadA: 사용자A 주문 금액 조회
        // int price = statefulService1.getPrice();
        // System.out.println("price = " + price);
        //
        // Assertions.assertThat(statefulService1.getPrice())
        //         .isEqualTo(20000);

        // 공유필드는 조심해야한다. 스프링 빈은 항상 무상태(stateless)로 설계하자.

        // ThreadA: A사용자 10000원 주문
        int useAPrice = statefulService1.order("userA", 10000);
        // ThreadB: B사용자 20000원 주문
        int useBPrice = statefulService2.order("userB", 20000);
        System.out.println("price = " + useAPrice);

    }

    static class TestConfig {
        @Bean
        public StatefulService statefulService() {
            return new StatefulService();
        }
    }

}