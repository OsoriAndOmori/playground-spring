package com.osori.mvc.playground.springcore.service

import com.osori.mvc.playground.springcore.domain.Grade
import com.osori.mvc.playground.springcore.domain.LectureMember
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.DisplayName

internal class MemberServiceImplTest {
    private val memberService: MemberService = MemberServiceImpl()

    @Test
    @DisplayName("만들어 넣고, 꺼낸 다음 테스트")
    fun memberTest() {
        val member = LectureMember(1, "오소리", Grade.VIP)
        memberService.addMember(member);

        val fetchMember = memberService.fetchMember(1)

        assertEquals(1, fetchMember.id)
        assertEquals("오소리", fetchMember.name)
        assertEquals(Grade.VIP, fetchMember.grade)

        // memory member repo 쓰는 경우 map 에 넣었다 꺼내는거라 ref 가 같음
        // assertEquals(member, fetchMember)
    }
}