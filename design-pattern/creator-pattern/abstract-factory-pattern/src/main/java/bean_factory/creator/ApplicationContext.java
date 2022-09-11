package bean_factory.creator;

import bean_factory.annotation.Bean;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.concurrent.ConcurrentHashMap;

public class ApplicationContext {
  private final ConcurrentHashMap<Class, Object> beanMaps = new ConcurrentHashMap<>();

  public ApplicationContext(ConfigurationFactory configurationFactory) {
    registerBeans(configurationFactory);
  }

  public Object getBeans(Class typeToken) {
    if (beanMaps.containsKey(typeToken)) {
      return beanMaps.get(typeToken);
    } else {
      throw new RuntimeException();
    }
  }

  private void registerBeans(ConfigurationFactory configurationFactory) {
    Method[] methods = configurationFactory.getClass().getDeclaredMethods();
    for (Method method : methods) {
      Annotation[] declaredAnnotations = method.getDeclaredAnnotations();
      for (Annotation an : declaredAnnotations) {
        if (an.annotationType() == Bean.class) {
          try {
            Object invoke = method.invoke(configurationFactory);
            beanMaps.put(method.getReturnType(), invoke);
          } catch (Exception e) {
            System.out.println("예외 처리 생략... 할거에요...");
          }
        }
      }
    }
  }

}
