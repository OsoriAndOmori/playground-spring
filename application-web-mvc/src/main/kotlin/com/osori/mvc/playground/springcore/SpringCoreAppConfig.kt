package com.osori.mvc.playground.springcore

import com.osori.mvc.playground.springcore.aop.LogMethodInterceptor
import com.osori.mvc.playground.springcore.`interface`.BeanCustomDefinition
import com.osori.mvc.playground.springcore.policy.DiscountPolicy
import com.osori.mvc.playground.springcore.policy.FixedDiscountPolicy
import com.osori.mvc.playground.springcore.repository.MemberRepository
import com.osori.mvc.playground.springcore.repository.MemoryMemberRepository
import com.osori.mvc.playground.springcore.service.MemberService
import com.osori.mvc.playground.springcore.service.MemberServiceImpl
import com.osori.mvc.playground.springcore.service.OrderService
import com.osori.mvc.playground.springcore.service.OrderServiceImpl
import org.springframework.cglib.proxy.Callback
import org.springframework.cglib.proxy.Enhancer

//얘가 이제 나만의 ApplicationContext 임
class SpringCoreAppConfig {

    private val container = mutableMapOf<String, BeanCustomDefinition>()

    fun memberService(): MemberService {

        if (container["memberService"] == null) {
            val enhancer = enhancer(MemberServiceImpl::class.java, LogMethodInterceptor())
            container["memberService"] =
                enhancer.create(arrayOf(MemberRepository::class.java), arrayOf(memberRepository())) as MemberServiceImpl
        }

        return container["memberService"] as MemberService
    }


    fun orderService(): OrderService {
        if (container["orderService"] == null) {
            val enhancer = enhancer(OrderServiceImpl::class.java, LogMethodInterceptor())
            container["orderService"] =
                enhancer.create(arrayOf(DiscountPolicy::class.java), arrayOf(discountPolicy())) as OrderServiceImpl
        }

        return container["orderService"] as OrderService
    }

    fun memberRepository(): MemberRepository {
        if (container["memberRepository"] == null) {
            val enhancer = enhancer(MemoryMemberRepository::class.java, LogMethodInterceptor())
            container["memberRepository"] = enhancer.create() as MemoryMemberRepository
        }

        return container["memberRepository"] as MemberRepository
    }

    fun discountPolicy(): DiscountPolicy {
        if (container["discountPolicy"] == null) {
            val enhancer = enhancer(FixedDiscountPolicy::class.java, LogMethodInterceptor())
            container["discountPolicy"] = enhancer.create(arrayOf(Int::class.java), arrayOf(1000)) as FixedDiscountPolicy
        }

        return container["discountPolicy"] as DiscountPolicy
    }

    private fun <T> enhancer(superClass: Class<T>, callBack: Callback): Enhancer {
        val enhancer = Enhancer()
        enhancer.setSuperclass(superClass)
        enhancer.setCallback(callBack)
        return enhancer
    }
}