import java.util.Arrays;
import java.util.List;
import java.util.Stack;

class Solution636 {
  public int[] exclusiveTime(int n, List<String> logs) {
    Stack<Integer> s = new Stack<>();
    int[] result = new int[n];
    int lastTime = -1;

    for (String str : logs) {
      String[] temp = str.split(":");
//      System.out.println(Arrays.toString(temp));
      int id = Integer.parseInt(temp[0]);
      int time = Integer.parseInt(temp[2]);

      if (temp[1].equals("start")) {
        if (!s.isEmpty()) {
          result[s.peek()] += time - lastTime;
        }
        lastTime = time;
        s.push(id);
      } else {
        time++;
        result[s.peek()] += time - lastTime;
        lastTime = time;
        s.pop();
      }
    }

    return result;
  }
}