package com.osori.mvc.custom;

import org.springframework.security.core.userdetails.UserDetails;

/**
 * 같은 쓰레드에서만 공유함
 */
public class AccountContext {
    public static final ThreadLocal<UserDetails> ACCOUNT_THREAD_LOCAL = new ThreadLocal<>();

    public static void setAccount(UserDetails account) {
        ACCOUNT_THREAD_LOCAL.set(account);
    }

    public static UserDetails getAccount() {
        return ACCOUNT_THREAD_LOCAL.get();
    }
}
