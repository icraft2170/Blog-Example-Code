package basic_pattern;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class FirstLeaf implements Component{

  @Override
  public void operation() {
    log.info("Leaf - {}", 1);
  }
}
