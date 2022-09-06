package me.hero.springhystrix.service;

import me.hero.springhystrix.domain.User;
import org.springframework.stereotype.Component;

@Component
public class UserServiceImpl implements UserService{
    @Override
    public User getUser(Long userId) {
        return User.builder()
                .id(-1L).name("유저 없음").build();
    }
}
