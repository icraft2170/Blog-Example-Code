package me.hero.facade.after;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/item")
@RequiredArgsConstructor
public class ItemRestController {

  private final ItemFacade itemFacade;

  @GetMapping("/{itemId}")
  public String getItem(@PathVariable Long itemId) {
    String response =  itemFacade.getResponse(itemId);
    return response;
  }
}

