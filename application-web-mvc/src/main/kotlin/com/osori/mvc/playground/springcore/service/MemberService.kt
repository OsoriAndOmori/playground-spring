package com.osori.mvc.playground.springcore.service

import com.osori.mvc.playground.springcore.domain.LectureMember

interface MemberService {
    fun addMember(member: LectureMember): LectureMember

    fun fetchMember(memberId: Long): LectureMember
}