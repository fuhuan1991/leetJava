import java.util.List;

public class ZigzagIterator {
  private boolean getFrom1;
  private List<Integer> v1;
  private List<Integer> v2;

  public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
    this.getFrom1 = true;
    this.v1 = v1;
    this.v2 = v2;
  }

  public int next() {
    if (!this.hasNext()) return 0;

    if (this.getFrom1) {
      if (this.v1.isEmpty()) {
        this.getFrom1 = !this.getFrom1;
        return next();
      }
      this.getFrom1 = !this.getFrom1;
      return v1.remove(0);
    } else {
      if (this.v2.isEmpty()) {
        this.getFrom1 = !this.getFrom1;
        return next();
      }
      this.getFrom1 = !this.getFrom1;
      return v2.remove(0);
    }
  }

  public boolean hasNext() {
    return !(this.v1.isEmpty() && this.v2.isEmpty());
  }
}

/**
 * Your ZigzagIterator object will be instantiated and called as such:
 * ZigzagIterator i = new ZigzagIterator(v1, v2);
 * while (i.hasNext()) v[f()] = i.next();
 */