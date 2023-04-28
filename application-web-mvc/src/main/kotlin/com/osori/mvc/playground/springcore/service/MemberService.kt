package com.osori.mvc.playground.springcore.service

import com.osori.mvc.playground.springcore.domain.LectureMember
import com.osori.mvc.playground.springcore.`interface`.BeanCustomDefinition

interface MemberService : BeanCustomDefinition {
    fun addMember(member: LectureMember): LectureMember

    fun fetchMember(memberId: Long): LectureMember
}