package me.hero.facade.before;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/item")
@RequiredArgsConstructor
public class ItemRestController {

  private final ItemService itemService;
  private final OrderService orderService;

  @GetMapping("/{itemId}")
  public String getItem(@PathVariable Long itemId) {
    String itemName = itemService.findItem(itemId);
    Long orderNumber = orderService.findOrder(itemId);
    return orderNumber + " : " + itemName;
  }
}

