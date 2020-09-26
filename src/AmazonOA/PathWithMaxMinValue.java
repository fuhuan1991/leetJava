package AmazonOA;

import java.util.*;


class Solution {
  int[][] directions = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

  public int maxMinPath_4_dir(int[][] A) {
    int n = A.length;
    int m = A[0].length;
    boolean[][] visited = new boolean[n][m];

    // in the BFS approach, for each step, we are interested in getting the maximum min that we have seen so far, thus we reverse the ordering in the pq
    Queue<int[]> pq = new PriorityQueue<>((a,b) -> b[2] - a[2]);

    pq.offer(new int[]{0, 0, A[0][0]});

    // BFS
    while (!pq.isEmpty()) {
      int[] cell = pq.poll();
      int row = cell[0];
      int col = cell[1];

      // final position
      if (row == n - 1 && col == m - 1) {
        return cell[2];
      }

      visited[row][col] = true;

      for (int[] dir : directions) {
        int nextRow = row + dir[0];
        int nextCol = col + dir[1];

        if (nextRow < 0 || nextRow >= n || nextCol < 0 || nextCol >= m || visited[nextRow][nextCol]) continue;

        // we are keeping track of the min element that we have seen until now
        pq.offer(new int[]{nextRow, nextCol, Math.min(cell[2], A[nextRow][nextCol])});
      }
    }
    return -1;
  }

  public static int maxMinPath_2_dir(int[][] A) {
    int height = A.length;
    int width = A[0].length;
    int[][] dp = new int[height][width];

    dp[0][0] = Integer.MAX_VALUE;
    A[height - 1][width - 1] = Integer.MAX_VALUE;

    for (int i = 0; i < height; ++i) {
      for (int j = 0; j < width; ++j) {

        if (i == 0 && j == 0) continue;
        if (i == 0) {
          dp[i][j] = Math.min(dp[i][j-1], A[i][j]);
        } else if (j == 0) {
          dp[i][j] = Math.min(dp[i-1][j], A[i][j]);
        } else {
          dp[i][j] = Math.max(Math.min(dp[i][j-1], A[i][j]), Math.min(dp[i-1][j], A[i][j]));
        }
      }
    }

    return dp[height - 1][width - 1];
  }

  public static void main(String[] args) {
    int tc1 = maxMinPath_2_dir(new int[][] { { 5, 1 }, { 4, 5 } });
    int tc2 = maxMinPath_2_dir(new int[][] { { 5, 7 }, { 3, 4 }, { 9, 8 } });
    int tc3 = maxMinPath_2_dir(new int[][] { { 5, 7, 6, 8 }, { 3, 4, 2, 1 }, { 9, 8, 4, 6 } });
    int tc4 = maxMinPath_2_dir(new int[][] { { 1, 2, 3 }, { 4, 5, 1 } });
    System.out.println(tc1 + " " + tc2 + " " + tc3 + " " + tc4);

  }
}