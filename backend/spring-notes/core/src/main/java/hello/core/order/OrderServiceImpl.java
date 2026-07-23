package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;

public class OrderServiceImpl implements OrderService {

    // private final DiscountPolicy discountPolicy = new FixDiscountPolicy();
    // private final DiscountPolicy discountPolicy = new RateDiscountPolicy();
    // 클라이언트인 OrderServiceImpl이 DiscountPolicy 인터페이스 뿐만아니라
    // FixDiscountPolicy, RateDiscountPolicy 구현체클래스도 함깨 의존하고 있음
    // DIP 위반 -> OCP 위반
    // AppConfig로 구현 객체 생성함으로써 해결.
    // 생성한 객체 인스턴스의 참조를 생성자를 통해서 주입해준다.
    // 이제 OrderServiceImpl를 수정할 필요 없음.

    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;

    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }


    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);


        return new Order(memberId, itemName, itemPrice, discountPrice);

    }
}
