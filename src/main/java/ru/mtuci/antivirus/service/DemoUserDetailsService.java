package ru.mtuci.antivirus.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
@RequiredArgsConstructor
public class DemoUserDetailsService implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // Заглушка. Здесь вы должны реализовать поиск пользователя в вашей БД
        if ("user".equals(username)) {
            return User.builder()
                    .username("user")
                    .password("{noop}password") // Используйте шифрование в реальных приложениях
                    .authorities(Collections.emptyList())
                    .build();
        }
        throw new UsernameNotFoundException("User not found: " + username);
    }
}
