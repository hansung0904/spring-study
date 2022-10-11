package hello.core.discount;

import hello.core.member.Member;

public interface DiscountPolicy {

    /**
     * @return 할인 대상 금액
     **/
    int discount(Member member, int price); // member를 파라미터로 넘기기만 함 어떤한 의존관계도 없음

}
