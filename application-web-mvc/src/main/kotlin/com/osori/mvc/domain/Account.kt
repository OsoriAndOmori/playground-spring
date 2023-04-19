package com.osori.mvc.domain

import org.springframework.security.crypto.password.PasswordEncoder
import javax.persistence.*

@Entity
data class Account(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int? = null,

    @Column(unique = true)
    val username: String? = null,
    var password: String? = null,
    val role: String? = null
) {
    fun encodePassword(passwordEncoder: PasswordEncoder) {
        password = passwordEncoder.encode(password)
    }
}