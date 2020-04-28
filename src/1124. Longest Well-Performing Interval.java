import java.util.HashMap;

class Solution {
  public int longestWPI(int[] hours) {
    if (hours.length == 0) return 0;

    int sum = 0;
    int result = 0;
    HashMap<Integer, Integer> m = new HashMap<>();

    for (int i = 0; i < hours.length; ++i) {
      sum += hours[i] > 8? 1 : -1;
      m.putIfAbsent(sum, i);

      if (sum > 0) {
        result = i + 1;
      } else if (m.containsKey(sum - 1)) {
        result = Math.max(result, i - m.get(sum - 1));
      }
    }
    return result;
  }
}