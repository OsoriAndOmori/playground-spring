package com.osori.mvc.playground.springcore.service

import com.osori.mvc.playground.springcore.SpringCoreAppConfig
import com.osori.mvc.playground.springcore.domain.LectureMember
import com.osori.mvc.playground.springcore.repository.MemberRepository

class MemberServiceImpl : MemberService {
    private val memberRepository: MemberRepository = SpringCoreAppConfig().memberRepository()

    override fun addMember(member: LectureMember): LectureMember {
        return memberRepository.save(member)
    }

    override fun fetchMember(memberId: Long): LectureMember {
        return memberRepository.findByMemberId(memberId)
    }
}