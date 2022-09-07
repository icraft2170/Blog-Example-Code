package me.hero.apigateway.customfilter.postfilter;

import java.time.LocalDateTime;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import reactor.core.publisher.Mono;

@Slf4j
@Configuration
public class PostFilter {
  @Bean
  public GlobalFilter postLoggingFilter() {
    return (exchange, chain) -> {
      return chain.filter(exchange).then(Mono.fromRunnable(() -> {
        LocalDateTime now = LocalDateTime.now();
        log.info("Post Filter - ( " + now + " ) ");
      }));
    };
  }
}
