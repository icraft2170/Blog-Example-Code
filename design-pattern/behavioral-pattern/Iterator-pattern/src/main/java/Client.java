import java.util.Arrays;

public class Client {
  public static void main(String[] args) {
    Object[] objectArray = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9 ,10).toArray();
    Aggregate<Integer> aggregate = new ConcreteAggregate<>(objectArray);
    Iterator<Integer> iterator = aggregate.createIterator();
    while (iterator.hasNext()) {
      Integer next = iterator.getNext();
      if (!iterator.hasNext()) {
        System.out.print(next);
        break;
      }
      System.out.print(next + " ,");
    }
  }
}
