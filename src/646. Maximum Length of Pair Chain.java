import java.util.Arrays;

class Solution646 {
  public int findLongestChain(int[][] pairs) {
    Arrays.sort(pairs, (a, b) -> a[0] - b[0]);

    // dp[i] indicates the max length of list that starts with pair[i]
    int[] dp = new int[pairs.length];
    dp[pairs.length-1] = 1;
    int result = 1;

    for (int i = pairs.length-2; i >=0; i--) {
      int[] currentPair = pairs[i];
      int max = 1;
      for (int j = i+1; j <= pairs.length-1; j++) {
        if (currentPair[1] < pairs[j][0]) {
          // if current and pair j can form a link,
          // we need to check the max length of list
          // that starts with pair j and then update max and result
          max = Math.max(max, 1 + dp[j]);
          result = Math.max(result, 1 + dp[j]);
        }
      }
      dp[i] = max;
    }

    return result;
  }
}