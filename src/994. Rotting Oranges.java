import javafx.util.Pair;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

class Solution {

  private int length;
  private int height;
  private int[][] grid;

  public int orangesRotting(int[][] grid) {
    this.grid = grid;
    int height = grid.length;
    int length = grid[0].length;
    this.height = height;
    this.length = length;
    int good = 0;
    int time = -1;
    Deque<Pair<Integer, Integer>> queue = new LinkedList<>();

    for (int i = 0; i < height; i++) {
      for (int j = 0; j < length; j++) {
        if (grid[i][j] == 1) {
          good++;
        } else if (grid[i][j] == 2) {
          queue.offer(new Pair<>(i, j));
        }
      }
    }
    queue.offer(new Pair(-1, -1));

    while (!queue.isEmpty()) {
      System.out.print(queue);
      Pair<Integer, Integer>pos = queue.pop();

      int y = pos.getKey();
      int x = pos.getValue();

      if (x == -1) {
        time++;
        if (!queue.isEmpty()) queue.offer(new Pair(-1, -1));
      } else {
        Pair<Integer, Integer> n1 = new Pair<>(y+1, x);
        if (this.isGood(n1)) {
          good--;
          this.grid[y+1][x] = 2;
          queue.offer(n1);
        }
        Pair<Integer, Integer> n2 = new Pair<>(y-1, x);
        if (this.isGood(n2)) {
          good--;
          this.grid[y-1][x] = 2;
          queue.offer(n2);
        }
        Pair<Integer, Integer> n3 = new Pair<>(y, x+1);
        if (this.isGood(n3)) {
          good--;
          this.grid[y][x+1] = 2;
          queue.offer(n3);
        }
        Pair<Integer, Integer> n4 = new Pair<>(y, x-1);
        if (this.isGood(n4)) {
          good--;
          this.grid[y][x-1] = 2;
          queue.offer(n4);
        }
      }
    }

    if (good > 0) return -1;
    return time;
  }

  private boolean isGood(Pair<Integer, Integer> pos) {
    int y = pos.getKey();
    int x = pos.getValue();
    return 0 <= x && x <= this.length-1 && 0 <= y && y <= this.height-1 && this.grid[y][x] == 1;
  }
}