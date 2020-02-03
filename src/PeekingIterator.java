import java.util.Iterator;
import java.util.LinkedList;

// Java Iterator interface reference:
// https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html
class PeekingIterator<T> implements Iterator<T> {

  private Iterator<T> data;
  private T nextElement;

  public PeekingIterator(Iterator<T> iterator) {
    // initialize any member here.
    this.data = iterator;
    this.nextElement = iterator.next();
  }

  // Returns the next element in the iteration without advancing the iterator.
  public T peek() {
    return this.nextElement;
  }

  // hasNext() and next() should behave the same as in the Iterator interface.
  // Override them if needed.
  @Override
  public T next() {
    T r = this.nextElement;
    if (this.data.hasNext()) {
      this.nextElement = this.data.next();
    } else {
      this.nextElement = null;
    }
    return r;
  }

  @Override
  public boolean hasNext() {
    return this.nextElement != null;
  }
}