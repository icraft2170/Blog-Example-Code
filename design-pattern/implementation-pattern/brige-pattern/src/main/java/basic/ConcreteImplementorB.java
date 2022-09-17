package basic;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ConcreteImplementorB implements Implementor{

  @Override
  public void operationImp() {
    log.info("B-TASK RESPONSE");
  }
}
