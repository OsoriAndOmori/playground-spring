package com.osori.mvc.playground.springcore.repository

import com.osori.mvc.playground.springcore.domain.LectureMember
import com.osori.mvc.playground.springcore.`interface`.BeanCustomDefinition

interface MemberRepository : BeanCustomDefinition {
    fun save(member: LectureMember): LectureMember

    fun findByMemberId(memberId: Long): LectureMember
}