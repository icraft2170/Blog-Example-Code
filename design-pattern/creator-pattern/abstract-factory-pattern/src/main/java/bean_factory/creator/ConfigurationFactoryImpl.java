package bean_factory.creator;

import bean_factory.annotation.Bean;
import bean_factory.product.ConcreteMailSender;
import bean_factory.product.ConcreteObjectMapper;
import bean_factory.product.MailSender;
import bean_factory.product.ObjectMapper;
import bean_factory.annotation.Configuration;

@Configuration
public class ConfigurationFactoryImpl implements ConfigurationFactory {
  @Override @Bean
  public MailSender createMailSender() {
    System.out.println("create mail sender");
    return new ConcreteMailSender();
  }

  @Override @Bean
  public ObjectMapper createObjectMapper() {
    System.out.println("create object mapper");
    return new ConcreteObjectMapper();
  }
}
