import java.util.HashMap;

class Solution294 {

  private HashMap<String, Boolean> mem;

  public boolean canWin(String s) {
    if (s.length() < 2) return false;
    this.mem = new HashMap<>();
    return this.search(s, true);
  }

  private boolean search(String state, boolean isFirstPlayer) {
    if (this.mem.containsKey(state)) {
      if (isFirstPlayer) {
        return this.mem.get(state);
      } else {
        return !this.mem.get(state);
      }
    } else {
      StringBuilder sb = new StringBuilder(state);
      char last = state.charAt(0);
      boolean canWin = false;
      for (int i = 1; i < state.length(); i++) {
        char current = state.charAt(i);
        if (last == '+' && current == '+') {
          sb.setCharAt(i, '-');
          sb.setCharAt(i-1, '-');
          String newStr = sb.toString();
          boolean r = this.search(newStr, !isFirstPlayer);
          if (!r) {
            canWin = true;
            break;
          }
          sb.setCharAt(i, '+');
          sb.setCharAt(i-1, '+');
        }
        last = current;
      }
      this.mem.put(state, isFirstPlayer? canWin : !canWin);
      return canWin;
    }
  };
}