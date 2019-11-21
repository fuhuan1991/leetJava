class Solution486 {
  public boolean PredictTheWinner(int[] nums) {
    int len = nums.length;
    int[][] dp = new int[len][len];
    // dp[s][e] stores the maximum advantage(difference) that a player can build from the
    // current subArray(starts at index s, ends at index e).
    for (int start = len-1; start >= 0; start--) {
      dp[start][start] = nums[start];
      for (int end = start + 1; end <= len-1; end++) {
        // once a play choose an end point, a subArray(start+1->end or start->end-1)
        // is left for the other player. Then, the other player can use this subArray
        // to build the maximum advantage.
        int a = nums[start] - dp[start+1][end];
        int b = nums[end] - dp[start][end-1];
        dp[start][end] = Math.max(a, b);
      }
    }

    if (dp[0][len-1] >= 0) {
      return true;
    } else {
      return false;
    }
  }
}