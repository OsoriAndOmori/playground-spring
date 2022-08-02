package com.osori.mvc.service;

import com.osori.mvc.domain.Account;
import com.osori.mvc.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AccountService implements UserDetailsService {
    private final AccountRepository accountRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Account byUsername = accountRepository.findByUsername(username);
        if (byUsername == null) {
            throw new UsernameNotFoundException(username);
        }

        return User.builder()
                .username(byUsername.getUsername())
                .password(byUsername.getPassword())
                .roles(byUsername.getRole())
                .build();
    }

    public Account createNew(Account account) {
        account.encodePassword(passwordEncoder);
        return accountRepository.save(account);
    }
}
