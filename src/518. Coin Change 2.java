class Solution {
  public int change(int amount, int[] coins) {
    int[] dp = new int[amount + 1];
    dp[0] = 1;
    for (int i = 0; i < coins.length; ++i) {
      int coinValue = coins[i];
      for (int j = 0; j <= amount; ++j) {
        if (j < coinValue) {
          continue;
        } else {
          dp[j] = dp[j - coinValue] + dp[j];
        }
      }
    }
    return dp[amount];
  }
}