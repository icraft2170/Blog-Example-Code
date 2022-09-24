public class ConcreteAggregate<T> implements Aggregate<T>{
  Object[] aggregate;
  private int size;

  public ConcreteAggregate(Object[] aggregate) {
    this.aggregate = aggregate;
    this.size = aggregate.length;
  }

  @Override
  public Iterator<T> createIterator() {
    return new ConcreteIterator<T>(this.aggregate, size);
  }
}
