package com.osori.mvc.playground.springcore

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
    fun memberService(): MemberService {
        return MemberServiceImpl(memberRepository())
    }

    fun orderService(): OrderService {
        return OrderServiceImpl(discountPolicy())
    }

    fun memberRepository(): MemberRepository {
        return MemoryMemberRepository()
    }

    fun discountPolicy(): DiscountPolicy {
        return FixedDiscountPolicy(1000)
    }
}