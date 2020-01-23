import java.lang.reflect.Array;
import java.util.*;

class Solution505 {

  int[][] mem;
  int[][] maze;
  int M;
  int N;
  int[] destination;

  public int shortestDistance(int[][] maze, int[] start, int[] destination) {
    this.M = maze.length;
    this.N = maze[0].length;
    this.mem = new int[M][N];
    this.maze = maze;
    this.destination = destination;

    for (int[] row : this.mem) {
      Arrays.fill(row, Integer.MAX_VALUE);
    }

    dfs(start[0], start[1], 0);
    int[][] aaa = this.mem;
    int r = this.mem[destination[0]][destination[1]];
    if (r == Integer.MAX_VALUE) {
      return -1;
    }
    return r;
  }

  private void dfs(int x, int y, int dis) {
    if (dis >= this.mem[x][y]) {
      return;
    } else {
      this.mem[x][y] = dis;
    }

//    System.out.println(x + "-" + y);

//    if(x == this.destination[0] && y == this.destination[1] && ) {
//      return;
//    }

    int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    // try all 4 directions
    for (int[] dir : directions) {
      int currentX = x;
      int currentY = y;
      int currentDis = 0;

      while (
              0 <= currentX+dir[0] &&
                      0 <= currentY+dir[1] &&
                      currentX+dir[0] <= M-1 &&
                      currentY+dir[1] <= N-1 &&
                      maze[currentX+dir[0]][currentY+dir[1]] == 0) {
        currentX = currentX + dir[0];
        currentY = currentY + dir[1];
        currentDis++;
      }

      if(currentDis > 0) dfs(currentX, currentY, dis + currentDis);
    }
    return;
  }
}