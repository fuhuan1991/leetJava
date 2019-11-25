import java.util.HashSet;
import java.util.Set;

class Solution983 {
  public int mincostTickets(int[] days, int[] costs) {
    Integer[] memo = new Integer[366];
    HashSet<Integer>planset = new HashSet();
    for (int d: days) planset.add(d);
    return minCostFromDay(1, planset, costs, memo);
  }

  private int minCostFromDay(int day, HashSet<Integer> planset, int[] cost,Integer[] memo) {
    if (day > 365) {
      return 0;
    }

    if (memo[day] != null) {
      return memo[day];
    }

    if (planset.contains(day)) {
      int planA = cost[0] + minCostFromDay(day+1, planset, cost, memo);
      int planB = cost[1] + minCostFromDay(day+7, planset, cost, memo);
      int planC = cost[2] + minCostFromDay(day+30, planset, cost, memo);
      int result = Math.min(planA, Math.min(planB, planC));
      memo[day] = result;
      return result;
    } else {
      int result = minCostFromDay(day+1, planset, cost, memo);
      memo[day] = result;
      return result;
    }
  }
}