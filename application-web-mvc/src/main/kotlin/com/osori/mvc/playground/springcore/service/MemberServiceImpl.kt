package com.osori.mvc.playground.springcore.service

import com.osori.mvc.playground.springcore.annotation.앞뒤로로그찍을래
import com.osori.mvc.playground.springcore.domain.LectureMember
import com.osori.mvc.playground.springcore.repository.MemberRepository

open class MemberServiceImpl(private val memberRepository: MemberRepository) : MemberService {
    @앞뒤로로그찍을래
    override fun addMember(member: LectureMember): LectureMember {
        return memberRepository.save(member)
    }

    override fun fetchMember(memberId: Long): LectureMember {
        return memberRepository.findByMemberId(memberId)
    }
}