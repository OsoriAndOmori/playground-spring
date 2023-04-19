package com.osori.mvc.service

import com.osori.mvc.domain.Account
import com.osori.mvc.repository.AccountRepository
import org.springframework.security.core.userdetails.User
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service

@Service
class AccountService(private val accountRepository: AccountRepository, private val passwordEncoder: PasswordEncoder) : UserDetailsService {
    @Throws(UsernameNotFoundException::class)
    override fun loadUserByUsername(username: String): UserDetails {
        val byUsername: Account =
            accountRepository.findByUsername(username) ?: throw UsernameNotFoundException(username)
        return User.builder()
            .username(byUsername.username)
            .password(byUsername.password)
            .roles(byUsername.role)
            .build()
    }

    fun createNew(account: Account): Account {
        account.encodePassword(passwordEncoder)
        return accountRepository.save(account)
    }
}