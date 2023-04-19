package com.osori.mvc.custom

import org.springframework.security.core.userdetails.UserDetails

/**
 * 같은 쓰레드에서만 공유함
 */
class AccountContext {
    companion object {
        val ACCOUNT_THREAD_LOCAL = ThreadLocal<UserDetails>()
        fun setAccount (account: UserDetails) : Unit {
            ACCOUNT_THREAD_LOCAL.set(account)
        }

        fun getAccount () : UserDetails {
            return ACCOUNT_THREAD_LOCAL.get()
        }
    }
}