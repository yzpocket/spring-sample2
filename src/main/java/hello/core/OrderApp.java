package hello.core;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.order.Order;
import hello.core.order.OrderService;

public class OrderApp {
    public static void main(String[] args) {
        AppConfig appConfig = new AppConfig();
        OrderService orderService = appConfig.orderService();
        MemberService memberService = appConfig.memberService();
        //MemberService memberService = new MemberServiceImpl(memberRepository);
        //OrderService orderService = new OrderServiceImpl(memberRepository, discountPolicy);

        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "itemA", 10000);

        System.out.println("order = "+ order);
        System.out.println("price = "+ order.calculatePrice());
    }
}
