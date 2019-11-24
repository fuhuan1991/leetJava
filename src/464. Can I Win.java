import java.util.*;

class Solution464 {
  public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
    int used = 0;
    Hashtable<Integer, Boolean> mem = new Hashtable<Integer, Boolean>();
    if (maxChoosableInteger >= desiredTotal) return true;
    if ((1 + maxChoosableInteger) * maxChoosableInteger / 2 < desiredTotal) return false;

    return canWin(desiredTotal, used, maxChoosableInteger, mem);
  }

  private boolean canWin(int target, int used, int maxChoosableInteger, Hashtable mem) {
//    System.out.println(mem);
    if (mem.containsKey(used)) return (boolean) mem.get(used);

//    check if the current player can win the game in this round
    for (int i = 1; i <= maxChoosableInteger; i++) {
      int mask = (1 << i);
      int newUsed = mask | used;
      if (((mask & used) == 0) && i >= target) {
        mem.put(used, true);
        return true;
      }
    }

    for (int i = 1; i <= maxChoosableInteger; i++) {
      int mask = (1 << i);
      int newUsed = mask | used;
      if (((mask & used) == 0) && canWin(target-i, newUsed, maxChoosableInteger, mem) == false) {
        //number i is unused
        mem.put(used, true);
        return true;
      }
    }

    mem.put(used, false);
    return false;
  }
}