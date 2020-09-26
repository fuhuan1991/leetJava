package AmazonOA;

class MaxSquare {
  public int maximalSquare(char[][] matrix) {

    if (matrix.length == 0) return 0;

    int height = matrix.length;
    int width = matrix[0].length;
    int[][] dp = new int[height][width];
    int max = 0;
    // System.out.print(dp[2][2]);

    for (int i = height-1; i >= 0; --i) {
      for (int j = width-1; j >= 0; --j) {
        if (matrix[i][j] == '1') {
          if (i == height - 1) {
            dp[i][j] = 1;
          } else if (j == width - 1) {
            dp[i][j] = 1;
          } else {
            dp[i][j] = 1 + Math.min(Math.min(dp[i+1][j], dp[i][j+1]), dp[i+1][j+1]);
          }
        } else {
          dp[i][j] = 0;
        }
        max = Math.max(max, dp[i][j]);
      }
    }

    return max*max;
  }
}