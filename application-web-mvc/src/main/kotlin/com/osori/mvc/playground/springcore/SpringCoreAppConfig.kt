package com.osori.mvc.playground.springcore

import com.osori.mvc.playground.springcore.`interface`.BeanCustomDefinition
import com.osori.mvc.playground.springcore.policy.DiscountPolicy
import com.osori.mvc.playground.springcore.policy.FixedDiscountPolicy
import com.osori.mvc.playground.springcore.repository.MemberRepository
import com.osori.mvc.playground.springcore.repository.MemoryMemberRepository
import com.osori.mvc.playground.springcore.service.MemberService
import com.osori.mvc.playground.springcore.service.MemberServiceImpl
import com.osori.mvc.playground.springcore.service.OrderService
import com.osori.mvc.playground.springcore.service.OrderServiceImpl

//얘가 이제 나만의 ApplicationContext 임
class SpringCoreAppConfig {
    private val container = mutableMapOf<String, BeanCustomDefinition>()

    fun memberService(): MemberService {
        if (container["memberService"] == null) {
            container["memberService"] = MemberServiceImpl(memberRepository())
        }

        return container["memberService"] as MemberService
    }

    fun orderService(): OrderService {
        if (container["orderService"] == null) {
            container["orderService"] = OrderServiceImpl(discountPolicy())
        }

        return container["orderService"] as OrderService
    }

    fun memberRepository(): MemberRepository {
        if (container["memberRepository"] == null) {
            container["memberRepository"] = MemoryMemberRepository()
        }

        return container["memberRepository"] as MemberRepository
    }

    fun discountPolicy(): DiscountPolicy {
        if (container["discountPolicy"] == null) {
            container["discountPolicy"] = FixedDiscountPolicy(1000)
        }

        return container["discountPolicy"] as DiscountPolicy
    }
}