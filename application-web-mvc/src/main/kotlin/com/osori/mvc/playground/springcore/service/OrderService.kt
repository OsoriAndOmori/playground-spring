package com.osori.mvc.playground.springcore.service

import com.osori.mvc.playground.springcore.domain.LectureItem
import com.osori.mvc.playground.springcore.domain.LectureMember
import com.osori.mvc.playground.springcore.domain.LectureOrder
import com.osori.mvc.playground.springcore.`interface`.BeanCustomDefinition

interface OrderService : BeanCustomDefinition {
    fun createOrder(member: LectureMember, item: LectureItem): LectureOrder
}