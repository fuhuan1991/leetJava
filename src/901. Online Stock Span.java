import java.util.Stack;

class StockSpanner {

  Stack<Record> s;

  public StockSpanner() {
    this.s = new Stack<Record>();

  }

  public int next(int price) {
    int counter = 1;
    while (!this.s.isEmpty() && this.s.peek().price <= price) {
      Record temp = this.s.pop();
      counter += temp.counter;
    }
    this.s.add(new Record(price, counter));
    return counter;
  }

  private class Record{
    public int price;
    public int counter;
    public Record(int price, int counter) {
      this.price = price;
      this.counter = counter;
    }
  }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */