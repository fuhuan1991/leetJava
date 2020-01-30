import java.util.Arrays;
import java.util.HashMap;

class Solution1335 {
  int len;
  int[] jobDifficulty;
  int[][] mem;

  public int minDifficulty(int[] jobDifficulty, int d) {
    if (jobDifficulty.length < d) return -1;
    this.len = jobDifficulty.length;
    this.jobDifficulty = jobDifficulty;
    this.mem = new int[this.len][d+1];
    for (int i = 0; i <= this.len-1; ++i) {
      Arrays.fill(this.mem[i], -1);
    }
// System.out.println(Arrays.toString(this.mem));
    return dfs(0, d);
  }

  private int dfs(int start, int days) {

    if (this.mem[start][days] >= 0) return this.mem[start][days];

    if (days == 1) {
      int max = 0;
      for (int i = start; i <= this.len-1; ++i) {
        max = Math.max(jobDifficulty[i], max);
      }
      return max;
    } else {
      int min = Integer.MAX_VALUE;
      int todayDifficuly = jobDifficulty[start];
      for (int workload = 1; workload <= this.len - days - start + 1; workload++) {
        todayDifficuly = Math.max(todayDifficuly, jobDifficulty[start + workload - 1]);
        int rest = start + workload == this.len? 0 : dfs(start + workload, days - 1);
        min = Math.min(min, rest + todayDifficuly);
      }
      this.mem[start][days] = min;
      return min;
    }
  }
}