package me.hero.facade.before;

import org.springframework.stereotype.Service;

@Service
public class ItemService {

  public String findItem(Long itemId) {
    return "Item - " + itemId;
  }
}
