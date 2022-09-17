package basic;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ConcreteImplementorA implements Implementor{
  @Override
  public void operationImp() {
    log.info("A-TASK RESPONSE");
  }
}
