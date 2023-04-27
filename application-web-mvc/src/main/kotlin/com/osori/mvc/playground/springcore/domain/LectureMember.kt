package com.osori.mvc.playground.springcore.domain

data class LectureMember(val id: Long, val name: String, val grade: Grade)

enum class Grade {
    VIP,
    GENERAL
}
