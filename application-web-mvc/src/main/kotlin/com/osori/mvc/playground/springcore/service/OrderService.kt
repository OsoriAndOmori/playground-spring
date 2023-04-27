package com.osori.mvc.playground.springcore.service

import com.osori.mvc.playground.springcore.domain.LectureItem
import com.osori.mvc.playground.springcore.domain.LectureMember
import com.osori.mvc.playground.springcore.domain.LectureOrder

interface OrderService {
    fun createOrder(member: LectureMember, item: LectureItem): LectureOrder
}