import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

class Solution {

  private HashMap<Character, Integer> rightPos = new HashMap<>();

  public List<Integer> partitionLabels(String S) {
    for (int i = S.length()-1; i >= 0; i--) {
      char c = S.charAt(i);
      if (!this.rightPos.containsKey(c)) {
        this.rightPos.put(c, i);
      }
    }

    List<Integer> result = new LinkedList<>();
    int start = 0;
    while (start < S.length()) {
      int len = 1;
      int current = start;

      char c0 = S.charAt(current);
      int rightMost0 = this.rightPos.get(c0);
      if (rightMost0 <= start + len - 1) {
        // no need to enlarge
      } else {
        // enlarge
        len = Math.max(len, rightMost0 - start + 1);
      }
      while (current < start + len - 1) {
        current++;
        char c = S.charAt(current);
        int rightMost = this.rightPos.get(c);
        if (rightMost > start + len - 1) len = Math.max(len, rightMost - start + 1);
      }
      result.add(len);
      start = current + 1;
    }
    return result;
  }
}