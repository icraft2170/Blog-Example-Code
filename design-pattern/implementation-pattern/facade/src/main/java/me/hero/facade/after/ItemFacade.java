package me.hero.facade.after;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ItemFacade {
  private final ItemService itemService;
  private final OrderService orderService;

  public String getResponse(Long itemId) {
    String itemName = itemService.findItem(itemId);
    Long orderNumber = orderService.findOrder(itemId);
    return orderNumber + " : " + itemName;
  }
}
