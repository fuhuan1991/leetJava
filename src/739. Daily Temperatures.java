import java.util.Stack;

class Solution739 {
  public int[] dailyTemperatures(int[] T) {

    Stack<Integer> s = new Stack<Integer>();
    int[] r = new int[T.length];

    for (int i = T.length-1; i >= 0; i--) {

      if (s.empty()) {
        s.push(i);
        r[i] = 0;
      } else {
        while (!s.empty() && T[s.peek()] <= T[i]) {
          s.pop();
        }
        r[i] = s.empty()? 0 : s.peek() - i;
        s.push(i);
      }
    }

    return r;
  }
}