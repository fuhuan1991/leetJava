import java.lang.reflect.Array;
import java.util.Arrays;

class Solution188 {
  public int maxProfit(int k, int[] prices) {

    if (prices.length <= 1 || k <= 0) return 0;

    if (prices.length/2 <= k) {

      int maxProfit = 0;

      for (int i = 1; i < prices.length; ++i) {

        if (prices[i] > prices[i-1]) {

          maxProfit += (prices[i] - prices[i-1]);
        }
      }

      return maxProfit;
    }

    int len = prices.length;
    int[] buy = new int[k];
    int[] sell = new int[k];
    Arrays.fill(buy, Integer.MIN_VALUE);

    for (int d = 0; d <= len-1; d++) {
      for (int i = 0; i <= Math.min(k-1, d); i++) {
        buy[i] = Math.max(buy[i], (i == 0)? -prices[d] : sell[i-1] - prices[d]);
        sell[i] = Math.max(sell[i], buy[i] + prices[d]);
      }
    }

    return sell[k-1];
  }
}