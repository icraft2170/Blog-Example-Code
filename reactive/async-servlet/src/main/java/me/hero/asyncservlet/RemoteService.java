package me.hero.asyncservlet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class RemoteService {
  @RestController
  public static class MyController {
    @GetMapping("/service")
    public String rest(@RequestParam String req) throws InterruptedException {
      Thread.sleep(2000);
//      throw new RuntimeException("알 수 없는 에러 발생");
      return req + " - service1";
    }

    @GetMapping("/service2")
    public String rest2(@RequestParam String req) throws InterruptedException {
      Thread.sleep(2000);
      return req + " - service2";
    }
  }

  public static void main(String[] args) {
    System.setProperty( "SERVER.PORT", "8081");
    System.setProperty( "server.tomcat.threads.max", "1000");
    SpringApplication.run(RemoteService.class, args);
  }

}
