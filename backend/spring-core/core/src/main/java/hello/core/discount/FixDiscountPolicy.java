package hello.core.discount;

import hello.core.member.Grade;
import hello.core.member.Member;
import org.springframework.stereotype.Component;

@Component
// @Qualifier("fixDiscountPolicy")    // 타입 중복빈있을 경우 Qualifier주입

public class FixDiscountPolicy implements DiscountPolicy {

    private int discountFixAmout = 1000; // 1000원 할인

    @Override
    public int discount(Member member, int price) {
        if (member.getGrade() == Grade.VIP) {
            return discountFixAmout;
        } else {
            return 0;
        }
    }
}
