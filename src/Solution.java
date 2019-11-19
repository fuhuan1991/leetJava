import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

class Solution {
  public int[] findOrder(int numCourses, int[][] prerequisites) {
    boolean[][] map = new boolean[numCourses][numCourses];
    for (int[] pair : prerequisites) {
      // map[i][j] == true means i need j
      map[pair[0]][pair[1]] = true;
    }
    Stack<Integer> stack = new Stack<Integer>();
    int[] visited = new int[numCourses];
    for (int i = 0; i <= numCourses-1; i++) {
      boolean valid = dfs(i, map, stack, visited);
      if (!valid) return new int[0];
    }
    int[] r = new int[numCourses];
    for (int i = numCourses-1; i >= 0; i--) {
      r[i] = (stack.pop());
    }
    return r;
  }

  private boolean dfs(int i, boolean[][] map, Stack<Integer> stack, int[] visited) {
//    visited[i] == 0 means dfs(1) has not started yet
//    visited[i] == 1 means dfs(i) has started but not completed
//    visited[i] == 2 means dfs(i) has completed
    if (visited[i] == 2) return true;
    // this case means circle, then you can't complete all courses.
    if (visited[i] == 1) return false;

    visited[i] = 1;
    for (int ii = 0; ii < map.length; ii++) {
      if (map[i][ii]) {
        boolean valid = dfs(ii, map, stack, visited);
        if (!valid) return false;
      }
    }
    stack.push(i);
    visited[i] = 2;
    return true;
  }
}