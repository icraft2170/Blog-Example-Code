package me.hero.springfeignorder.service;

import me.hero.springfeignorder.domain.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "USER-SERVICE")
public interface UserService {
    @GetMapping("/user/{userId}")
    User getUser(@PathVariable Long userId);
}
