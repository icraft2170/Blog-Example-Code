package me.hero.springhystrix.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import lombok.RequiredArgsConstructor;
import me.hero.springhystrix.domain.User;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{
    private final UserService userService;
    @Override
    @HystrixCommand(fallbackMethod = "fallbackGetUser")
    public User getUser(Long userId) {
        return userService.getUser(userId);
    }

    public User fallbackGetUser(Long userId) {
        return User.builder()
                .id(0L).name("유저 없음").build();
    }
}
