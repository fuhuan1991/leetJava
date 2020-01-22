class Solution {
  public boolean hasPath(int[][] maze, int[] start, int[] destination) {
    int M = maze.length;
    int N = maze[0].length;
    int[][] mem = new int[M][N];
//    System.out.println(mem);

    return canGoOut(start[0], start[1], maze, destination, mem);
  }

  private boolean canGoOut(int x, int y, int[][] maze, int[] destination, int[][] mem) {
    if (mem[x][y] == 1) return false;
    System.out.println(x + "-" + y);
    mem[x][y] = 1;
    if (x == destination[0] && y == destination[1]) return true;

    int M = maze.length;
    int N = maze[0].length;

    boolean p1 = false, p2 = false, p3 = false, p4 = false;

    if (x > 0 && maze[x-1][y] == 0) {
      int current = x;
      while (current > 0 && maze[current-1][y] == 0) {
        current--;
      }
      p1 = canGoOut(current, y, maze, destination, mem);
    }

    if (x < M-1 && maze[x+1][y] == 0) {
      int current = x;
      while (current < M-1 && maze[current+1][y] == 0) {
        current++;
      }
      p2 = canGoOut(current, y, maze, destination, mem);
    }

    if (y > 0 && maze[x][y-1] == 0) {
      int current = y;
      while (current > 0 && maze[x][current - 1] == 0) {
        current--;
      }
      p3 = canGoOut(x, current, maze, destination, mem);
    }

    if (y < N-1 && maze[x][y + 1] == 0) {
      int current = y;
      while (current < N-1 && maze[x][current + 1] == 0) {
        current++;
      }
      p4 = canGoOut(x, current, maze, destination, mem);
    }

    boolean result = p1 || p2 || p3 || p4;

    return result;
  }
}