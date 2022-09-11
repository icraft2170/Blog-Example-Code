package bean_factory.creator;

import bean_factory.product.MailSender;
import bean_factory.product.ObjectMapper;

public interface ConfigurationFactory {
  MailSender createMailSender();

  ObjectMapper createObjectMapper();
}
