package com.osori.mvc.playground.springcore.repository

import com.osori.mvc.playground.springcore.domain.LectureMember

interface MemberRepository {
    fun save(member: LectureMember): LectureMember

    fun findByMemberId(memberId: Long): LectureMember
}