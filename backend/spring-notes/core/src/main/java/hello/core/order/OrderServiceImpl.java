package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import org.springframework.stereotype.Component;

@Component
// @RequiredArgsConstructor    // final 붙은 필드를 모아서 생성자를 자동으로 만들어줌
public class OrderServiceImpl implements OrderService {


    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);

    }

    // private final DiscountPolicy discountPolicy = new FixDiscountPolicy();
    // private final DiscountPolicy discountPolicy = new RateDiscountPolicy();
    // 클라이언트인 OrderServiceImpl이 DiscountPolicy 인터페이스 뿐만아니라
    // FixDiscountPolicy, RateDiscountPolicy 구현체클래스도 함깨 의존하고 있음
    // DIP 위반 -> OCP 위반
    // AppConfig로 구현 객체 생성함으로써 해결.
    // 생성한 객체 인스턴스의 참조를 생성자를 통해서 주입해준다.
    // 이제 OrderServiceImpl를 수정할 필요 없음.

    // 의존관계 주입 방법
    // 기본으로 생성자 주입을 사용하고, 필수 값이 아닌경우에 수정자 주입 방식을 옵션으로 사용하는 것을 권장
    // 1. 필드 의존관계 주입
    // @Autowired
    // private MemberRepository memberRepository;
    // @Autowired
    // private DiscountPolicy discountPolicy;
    //
    // 2.1 수정자 의존관계 주입
    // @Autowired
    // public void setMemberRepository(MemberRepository memberRepository) {
    //     System.out.println("2. memberRepository : " + memberRepository);
    //     this.memberRepository = memberRepository;
    // }
    //
    // 2.2 수정자 의존관계 주입(required 옵션)
    // @Autowired(required = true)
    // public void setDiscountPolicy(DiscountPolicy discountPolicy) {
    //     System.out.println("2. discountPolicy : " + discountPolicy);
    //     this.discountPolicy = discountPolicy;
    // }
    //
    // 3.생성자 의존관계 주입
    // 생성자에서 여러 의존관계도 한번에 주입받을 수 있음.
    // final사용 시 컴파일 오류로 실수 방지됨.
    // private final MemberRepository memberRepository;
    // private final DiscountPolicy discountPolicy;
    // @Autowired  // 생성자가 하나일 경우 생략가능
    // public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
    //     // System.out.println("1. memberRepository : " + memberRepository);
    //     // System.out.println("1. discountPolicy : " + discountPolicy);
    //     this.memberRepository = memberRepository;
    //     this.discountPolicy = discountPolicy;
    // }
    //
    // 4. 일반 메서드 의존관계 주입
    // @Autowired
    // public void init(MemoryMemberRepository memberRepository, DiscountPolicy discountPolicy) {
    //     this.memberRepository = memberRepository;
    //     this.discountPolicy = discountPolicy;
    // }


    // 타입 중복 빈
    // @Autowired : 타입 매칭을 시도하고, 이때 여러 빈이 있으면(중복빈) 필드 이름, 파라미터 이름으로 빈 이름을 추가 매칭한다.
    // 해결방법
    // 메인 데이터베이스의 커넥션을 획득하는 스프링 빈은 @Primary를 적용해서 조회하는 곳에서 @Qualifier지정 없이 편리하게 조회하고,
    // 서브 데이터베이스 커넥션 빈을 획득 할때는 @Qualifier를 지정해서 명시적으로 획득하는 방식으로 사용 추천
    // 우선순위 Qualifier 우선순위가 높음.
    //
    // 1. 타입 중복 빈이 있다면 파라미터 인젝션
    // public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy rateDiscountPolicy) {
    //     this.memberRepository = memberRepository;
    //     this.discountPolicy = rateDiscountPolicy;
    // }
    //
    // 2. 타입 중복빈일경우 필드 의존관계 주입에서 필드명으로 인젝션
    // @Autowired
    // private DiscountPolicy rateDiscountPolicy;
    //
    // 3. @Qualifier 주입
    // @Qualifier끼리매칭 -> (없으면) -> 빈 이름 매칭 -> NoSuchBeanDefinitionException 예외 발생
    // public OrderServiceImpl(MemberRepository memberRepository, @Qualifier("mainDiscountPolicy") DiscountPolicy discountPolicy) {
    //     this.memberRepository = memberRepository;
    //     this.discountPolicy = discountPolicy;
    // }
    //
    // 4. @Primary 주입
    // public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
    //     this.memberRepository = memberRepository;
    //     this.discountPolicy = discountPolicy;
    // }


    // 싱글톤 테스트 용도
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}
