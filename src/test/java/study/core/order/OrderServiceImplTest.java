package study.core.order;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import study.core.discount.FixDiscountPolicy;
import study.core.member.Grade;
import study.core.member.Member;
import study.core.member.MemberRepository;
import study.core.member.MemoryMemberRepository;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class OrderServiceImplTest {

    @Test
    void createOrder() {
        MemberRepository memberRepository = new MemoryMemberRepository();
        memberRepository.save(new Member(1L, "nameA", Grade.VIP));

        OrderServiceImpl orderService = new OrderServiceImpl(memberRepository, new FixDiscountPolicy());
        Order order = orderService.createOrder(1L, "itemA", 10000);

        assertThat(order.getDiscountPrice()).isEqualTo(1000);

    }

}