package me.hero.springfeignuser;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient // Discovery Client 는 Eureka Client와 기본적인 컨셉은 같다.
@EnableFeignClients
public class SpringFeignUserApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringFeignUserApplication.class, args);
    }
}
