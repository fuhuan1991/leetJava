import java.util.HashMap;
import java.util.HashSet;
import java.util.Stack;

class Solution946 {

  Stack<Integer> s;

  public boolean validateStackSequences(int[] pushed, int[] popped) {
    this.s = new Stack<Integer>();
    int p = 0;
    int N = popped.length;

    for (int i : pushed) {
      s.push(i);
      while (!s.isEmpty() && p < N && s.peek() == popped[p]) {
        s.pop();
        p++;
      }
    }

    return p == N;
  }
}