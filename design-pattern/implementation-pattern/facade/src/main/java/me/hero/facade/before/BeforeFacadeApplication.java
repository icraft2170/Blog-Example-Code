package me.hero.facade.before;

import org.apache.catalina.core.ApplicationContext;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class BeforeFacadeApplication {

  public static void main(String[] args) {
    SpringApplication.run(BeforeFacadeApplication.class, args);
  }

}
