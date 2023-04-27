package com.osori.mvc.playground.springcore.repository

import com.osori.mvc.playground.springcore.domain.Grade
import com.osori.mvc.playground.springcore.domain.LectureMember

class MemoryMemberRepository : MemberRepository {
    companion object {
        private val repo: MutableMap<Long, LectureMember> = mutableMapOf()
    }

    override fun save(member: LectureMember): LectureMember {
        repo[member.id] = member
        return member
    }

    override fun findByMemberId(memberId: Long): LectureMember {
        return repo.getOrDefault(memberId, LectureMember(0, "empty", Grade.GENERAL))
    }
}