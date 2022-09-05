package me.hero.springfeignuser.controller;

import lombok.RequiredArgsConstructor;
import me.hero.springfeignuser.domain.User;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
    static HashMap<Long, User> mockData = new HashMap<>();
    static {
        mockData.put(1L, User.builder().id(1L).name("Hero").build());
        mockData.put(2L, User.builder().id(2L).name("Chad").build());
        mockData.put(3L, User.builder().id(3L).name("Peter").build());
    }

    @GetMapping("/{userId}")
    public User getUser(@PathVariable("userId") Long userId) {
        return mockData.get(userId);
    }
}
