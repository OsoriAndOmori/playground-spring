package com.osori.mvc.playground.springcore.service

import com.osori.mvc.playground.springcore.SpringCoreAppConfig
import com.osori.mvc.playground.springcore.domain.Grade
import com.osori.mvc.playground.springcore.domain.LectureItem
import com.osori.mvc.playground.springcore.domain.LectureMember
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

internal class OrderServiceImplTest {
    private var orderService: OrderService? = null
    private var memberService: MemberService? = null

    @BeforeEach
    fun before() {
        val springCoreAppConfig = SpringCoreAppConfig()
        memberService = springCoreAppConfig.memberService()
        orderService = springCoreAppConfig.orderService()

        memberService!!.addMember(LectureMember(1, "오소리1", Grade.VIP))
        memberService!!.addMember(LectureMember(2, "오소리2", Grade.GENERAL))
    }

    @Test
    fun createOrder() {
        val member = memberService!!.fetchMember(1)
        val item = LectureItem("item1", "아이템1", 10000)
        val order = orderService!!.createOrder(member, item)

        assertEquals(1, order.memberId)
        assertEquals(1000, order.discountPrice)
    }

    @Test
    fun createOrder2() {
        val member = memberService!!.fetchMember(2)
        val item = LectureItem("item1", "아이템1", 10000)
        val order = orderService!!.createOrder(member, item)

        assertEquals(2, order.memberId)
        assertEquals(0, order.discountPrice)
    }
}