import java.util.Stack;

class CustomStack {

  Stack<Integer> stack;
  int[] inc;
  int maxSize;

  public CustomStack(int maxSize) {
    this.stack = new Stack<Integer>();
    this.inc = new int[maxSize];
    this.maxSize = maxSize;
  }

  public void push(int x) {
    if (stack.size() < maxSize) stack.push(x);
  }

  public int pop() {
    if (stack.isEmpty()) return -1;
    int index = stack.size()-1;
    int result = stack.pop() + inc[index];

    if (index > 0) {
      inc[index-1] += inc[index];
    }
    inc[index] = 0;
    return result;
  }

  public void increment(int k, int val) {
    int index = Math.min(k-1, this.stack.size()-1);
    if (index >= 0) inc[index] += val;
  }
}

/**
 * Your CustomStack object will be instantiated and called as such:
 * CustomStack obj = new CustomStack(maxSize);
 * obj.push(x);
 * int param_2 = obj.pop();
 * obj.increment(k,val);
 */