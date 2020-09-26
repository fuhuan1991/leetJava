package AmazonOA;

class SpiralMatrix {
  public int[][] generateMatrix(int n) {

    int[][] result = new int[n][n];
    int cnt = 1;
    int dir[][] = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    int d = 0;
    int row = 0;
    int col = 0;

    while (cnt <= n * n) {
      result[row][col] = cnt++;

      int newRow = row + dir[d][0];
      int newCol = col + dir[d][1];

      if (newRow < 0 ||
              newRow > n-1 ||
              newCol < 0 ||
              newCol > n-1 ||
              result[newRow][newCol] != 0
      ) {
        d = (d + 1) % 4;
      }


      row += dir[d][0];
      col += dir[d][1];
    }
    return result;
  }
}