package hello.core;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(
        // basePackages: 탐색할 패키지의 시작위치를 지정. 하위 패키지까지 모두 탐색
        // 디폴트: @ComponentScan가 붙은 설정 정보 클래스의 패키지가 시작위치
        // basePackages = "hello.core",
        // basePackageClasses: 지정한 클래스의 패키지를 탐색 시작 위치로 지정
        // 설정 정보 클래스의 위치를 프로젝트 시작 루트 위치에 두는것이 관례

        // 실무에서는 제외안함. 예제코드 남기기위해 제외
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class)
)
public class AutoAppConfig {

    // 수동빈이 자동빈을 오버라이딩함.
    // @Bean(name = "memoryMemberRepository")
    // MemberRepository memberRepository() {
    //     return new MemoryMemberRepository();
    // }
}
