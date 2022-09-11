package bean_factory;

import bean_factory.creator.ApplicationContext;
import bean_factory.creator.ConfigurationFactoryImpl;
import bean_factory.product.MailSender;
import bean_factory.product.ObjectMapper;

public class Main {

  public static void main(String[] args) {
    ApplicationContext ac = new ApplicationContext(new ConfigurationFactoryImpl());

    System.out.println("--------------------------------------------------");

    MailSender mailSender = (MailSender) ac.getBeans(MailSender.class);
    System.out.println(mailSender.getName());

    System.out.println("--------------------------------------------------");

    ObjectMapper objectMapper = (ObjectMapper) ac.getBeans(ObjectMapper.class);
    System.out.println(objectMapper.getName());

    System.out.println("--------------------------------------------------");
  }
}
