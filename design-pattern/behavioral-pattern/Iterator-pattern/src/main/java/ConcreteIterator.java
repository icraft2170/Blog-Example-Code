public class ConcreteIterator<T> implements Iterator<T>{
  private int cursor;
  private int size;
  private Object[] aggregate;

  public ConcreteIterator(Object[] aggregate, int size) {
    this.cursor = 0;
    this.size = size;
    this.aggregate = aggregate;
  }

  @Override
  public T getNext() {
    return (T) aggregate[cursor++];
  }

  @Override
  public boolean hasNext() {
    return size > cursor;
  }
}
