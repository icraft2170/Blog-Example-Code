package me.hero.facade.before;

import org.springframework.stereotype.Service;

@Service
public class OrderService {

  public Long findOrder(Long itemId) {
    return 3L;
  }
}
