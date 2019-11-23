class Solution1140 {
  public int stoneGameII(int[] piles) {
    int len = piles.length;
    int[] sum = new int[len + 1];
    for (int i = len - 1; i >= 0; i--)
      sum[i] += sum[i + 1] + piles[i];//sum[i]是从i到len-1之和
    int[][] dp = new int[len + 1][len + 1];
    for (int i = len - 1; i >= 0; i--)
      for (int M = 1; M <= len; M++) {
        for (int X = 1; X <= 2 * M && i + X <= len; X++) {
          dp[i][M] = Math.max(dp[i][M], sum[i] - dp[i + X][Math.max(M, X)]);
          //when i+X==0，dp[i][M]=Math.max(dp[i][M],sum[i])=sum[i];
        }
      }
    return dp[0][1];
  }
}