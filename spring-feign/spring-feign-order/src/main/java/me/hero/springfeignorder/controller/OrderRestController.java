package me.hero.springfeignorder.controller;

import lombok.*;
import me.hero.springfeignorder.domain.User;
import me.hero.springfeignorder.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
@RequestMapping("/order")
@RequiredArgsConstructor
public class OrderRestController {
    private final UserService userService;
    static HashMap<Long, Order> orderMap = new HashMap<>();
    static {
        orderMap.put(1L, Order.builder().id(1L).name("주문A").userId(2L).build());
        orderMap.put(2L, Order.builder().id(2L).name("주문B").userId(1L).build());
        orderMap.put(3L, Order.builder().id(3L).name("주문C").userId(3L).build());
    }

    @GetMapping("/{orderId}")
    public OrderResponse getOrder(@PathVariable Long orderId) {
        Order order = orderMap.get(orderId);
        User user = userService.getUser(order.getUserId());
        return new OrderResponse(order, user);
    }


    @Data @NoArgsConstructor @AllArgsConstructor @Builder
    static class OrderResponse {
        private Long id;
        private String name;
        private Long userId;
        private String userName;

        public OrderResponse(Order order, User user) {
            this.id = order.getId();
            this.name = order.getName();
            this.userId = user.getId();
            this.userName = user.getName();
        }
    }
    @Data @NoArgsConstructor @AllArgsConstructor @Builder
    static class Order {
        private Long id;
        private String name;
        private Long userId;
    }
}
