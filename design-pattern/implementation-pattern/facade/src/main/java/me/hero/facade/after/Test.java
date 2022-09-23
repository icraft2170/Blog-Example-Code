package me.hero.facade.after;

import org.springframework.web.client.RestTemplate;

public class Test {

  public static void main(String[] args) {
    RestTemplate restTemplate = new RestTemplate();
    String response = restTemplate.getForObject("http://localhost:8080/item/1", String.class);
    System.out.println("response = " + response);
  }

}
