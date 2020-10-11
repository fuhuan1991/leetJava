package AmazonVO;

import java.util.*;

class Solution {
  public boolean canFinish(int numCourses, int[][] prerequisites) {

    HashMap<Integer, HashSet<Integer>> map = new HashMap<>();
    Deque<Integer> queue = new LinkedList<Integer>();
    HashSet<Integer> visited = new HashSet<>();

    for (int i = 0; i < prerequisites.length; ++i) {
      int[] pair = prerequisites[i];
      int from = pair[1];
      int to = pair[0];
      map.putIfAbsent(from, new HashSet<Integer>());
      map.get(from).add(to);
    }

    for (int start : map.keySet()) {
      if (!visited.contains(start)) {
        boolean res = this.DFS(start, map, visited, new HashSet<Integer>());
        if (!res) return res;
      }
    }


    return true;
  }

  private boolean DFS (int node, HashMap<Integer, HashSet<Integer>> map, HashSet<Integer> visited, HashSet<Integer> path) {

    if (path.contains(node)) return false;
    if (visited.contains(node)) return true;

    path.add(node);

    HashSet<Integer> tos = map.get(node);
    boolean res = false;

    if (tos == null) {
      res = true;
    } else {
      for (int to : tos) {
        res = DFS(to, map, visited, path);
        if (!res) return res;

      }
    }

    visited.add(node);
    path.remove(node);
    return res;
  }
}