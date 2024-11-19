package study.core.discount;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import study.core.member.Grade;
import study.core.member.Member;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class RateDiscountPolicyTest {

    DiscountPolicy discountPolicy = new RateDiscountPolicy();

    @Test
    @DisplayName("VIP는 10% 할인이 되어야한다")
    void vip_o() {
        //given
        Member memeber = new Member(1L, "memeberVIP", Grade.VIP);

        //when
        int discount = discountPolicy.discount(memeber, 10000);

        //then
        assertThat(discount).isEqualTo(1000);
    }

    @Test
    @DisplayName("VIP가 아니면 할인이 적용되지 않아야한다.")
    void vip_x() {
        //given
        Member memeber = new Member(2L, "memeberBASIC", Grade.BASIC);

        //when
        int discount = discountPolicy.discount(memeber, 10000);

        //then
        assertThat(discount).isEqualTo(0);
    }

}