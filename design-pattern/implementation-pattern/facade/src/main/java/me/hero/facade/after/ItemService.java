package me.hero.facade.after;

import org.springframework.stereotype.Service;

@Service
public class ItemService {

  public String findItem(Long itemId) {
    return "Item - " + itemId;
  }
}
