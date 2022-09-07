package me.hero.apigateway.customfilter.postfilter;

import java.time.LocalDateTime;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Slf4j
@Component
public class PostFilter extends AbstractGatewayFilterFactory<PostFilter.Config> {

  public PostFilter() {
    super(Config.class);
  }

  @Override
  public GatewayFilter apply(Config config) {
    return (exchange, chain) -> {
      return chain.filter(exchange).then(Mono.fromRunnable(()->{
        LocalDateTime now = LocalDateTime.now();
        log.info("Post Filter - ( " + now + " ) ");
      }));
    };
  }

  public static class Config{
  }
}
