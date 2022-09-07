package me.hero.apigateway.customfilter.prefilter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@Slf4j
@Order(1)
@Component
public class PreFilter implements GlobalFilter {
  @Override
  public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
    LocalDateTime now = LocalDateTime.now();
    log.info("Pre Filter - ( " + now + " )");
    return chain.filter(exchange);
  }
}
