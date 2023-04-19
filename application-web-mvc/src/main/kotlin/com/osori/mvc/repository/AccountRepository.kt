package com.osori.mvc.repository

import com.osori.mvc.domain.Account
import org.springframework.data.jpa.repository.JpaRepository

interface AccountRepository : JpaRepository<Account?, Int?> {
    fun findByUsername(username: String?): Account?
}