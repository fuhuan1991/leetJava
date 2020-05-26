import javafx.util.Pair;

import java.util.HashMap;

class Solution1197 {

  private HashMap<Pair<Integer, Integer>, Integer> mem;

  public int minKnightMoves(int x, int y) {
    this.mem = new HashMap<>();
    this.mem.put(new Pair<>(0,0), 0);
    this.mem.put(new Pair<>(1,1), 2);
    this.mem.put(new Pair<>(1,0), 3);
    this.mem.put(new Pair<>(2,0), 2);
    return this.search(x, y);
  }

  private int search(int x, int y) {
    x = Math.abs(x);
    y = Math.abs(y);
    if (x < y) {
      int t = y;
      y = x;
      x = t;
    }
    Pair<Integer, Integer> pos = new Pair<>(x, y);
    if (mem.containsKey(pos)) return this.mem.get(pos);
    int r = 1 + Math.min(this.search(x-1, y-2), this.search(x-2, y-1));
    this.mem.put(pos, r);
    return r;
  }
}