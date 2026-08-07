package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor    // final 붙은 변수를 포함한 생성자 만들어줌
public class OrderServiceImpl implements OrderService {

    // private final DiscountPolicy discountPolicy = new FixDiscountPolicy();
    // private final DiscountPolicy discountPolicy = new RateDiscountPolicy();
    // 클라이언트인 OrderServiceImpl이 DiscountPolicy 인터페이스 뿐만아니라
    // FixDiscountPolicy, RateDiscountPolicy 구현체클래스도 함깨 의존하고 있음
    // DIP 위반 -> OCP 위반
    // AppConfig로 구현 객체 생성함으로써 해결.
    // 생성한 객체 인스턴스의 참조를 생성자를 통해서 주입해준다.
    // 이제 OrderServiceImpl를 수정할 필요 없음.

    // 기본으로 생성자 주입을 사용하고, 필수 값이 아닌경우에 수정자 주입 방식을 옵션으로 사용하는 것을 권장

    // 필드 의존관계 주입
    // @Autowired
    private final MemberRepository memberRepository;
    // @Autowired
    private final DiscountPolicy discountPolicy;

    // 수정자 의존관계 주입
    // @Autowired
    // public void setMemberRepository(MemberRepository memberRepository) {
    //     System.out.println("2. memberRepository : " + memberRepository);
    //     this.memberRepository = memberRepository;
    // }

    // 수정자 의존관계 주입
    // @Autowired(required = true)
    // public void setDiscountPolicy(DiscountPolicy discountPolicy) {
    //     System.out.println("2. discountPolicy : " + discountPolicy);
    //     this.discountPolicy = discountPolicy;
    // }

    // 생성자 의존관계 주입
    // 생성자에서 여러 의존관계도 한번에 주입받을 수 있음.
    // final사용 시 컴파일 오류로 실수 방지됨.
    // @Autowired  // 생성자가 하나일 경우 생략가능
    // public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
    //     // System.out.println("1. memberRepository : " + memberRepository);
    //     // System.out.println("1. discountPolicy : " + discountPolicy);
    //     this.memberRepository = memberRepository;
    //     this.discountPolicy = discountPolicy;
    // }

    // // 일반 메서드 의존관계 주입
    // @Autowired
    // public void init(MemoryMemberRepository memberRepository, DiscountPolicy discountPolicy) {
    //     this.memberRepository = memberRepository;
    //     this.discountPolicy = discountPolicy;
    // }


    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);


        return new Order(memberId, itemName, itemPrice, discountPrice);

    }

    // 싱글톤 테스트 용도
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}
