import java.util.HashMap;
import java.util.Stack;

class FreqStack {

  private HashMap<Integer, Integer> freq;
  private HashMap<Integer, Stack<Integer>> group;
  private Integer maxFreq;

  public FreqStack() {
    this.freq = new HashMap<>();
    this.group = new HashMap<>();
    this.maxFreq = 0;
  }

  public void push(int x) {
    Integer newFreq = this.freq.getOrDefault(x, 0) + 1;
    this.freq.put(x, newFreq);
    this.group.computeIfAbsent(newFreq, a -> new Stack<>()).push(x);
    this.maxFreq = Math.max(this.maxFreq, newFreq);
  }

  public int pop() {
    Stack<Integer> stack = this.group.get(this.maxFreq);
    Integer target = stack.pop();
    this.freq.put(target, this.maxFreq - 1);
    if (stack.size() == 0) this.maxFreq--;
    return target;
  }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 */