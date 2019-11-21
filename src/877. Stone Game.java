class Solution877 {
  public boolean stoneGame(int[] piles) {
    int len = piles.length;
    int[][] dp = new int[len][len];

    for (int start = len-1; start >= 0; start--) {
      dp[start][start] = piles[start];
      for (int end = start+1; end <= len-1; end++) {
        int a = piles[start] - dp[start+1][end];
        int b = piles[end] - dp[start][end-1];
        dp[start][end] = Math.max(a,b);
      }
    }

    return dp[0][len-1] > 0 ? true : false;
  }
}