import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.PriorityQueue;

class Solution1334 {
  public int findTheCity(int n, int[][] edges, int distanceThreshold) {
    LinkedList<HashMap<Integer, Integer>> adjacent = new LinkedList<HashMap<Integer, Integer>>();

    for (int i = 0; i <= n-1; ++i) {
      adjacent.add(new HashMap<Integer, Integer>());
    }

    for (int i = 0; i <= edges.length-1; ++i) {
      int from = edges[i][0];
      int to = edges[i][1];
      int weight = edges[i][2];

      HashMap<Integer, Integer> m1 = adjacent.get(from);
      m1.put(to, weight);
      HashMap<Integer, Integer> m2 = adjacent.get(to);
      m2.put(from, weight);
    }

    int min = Integer.MAX_VALUE;
    int result = 0;

//    System.out.println(adjacent);
    for (int start = 0; start <= n-1; ++start) {
      PriorityQueue<int[]> dis = new PriorityQueue<int[]>((a, b) -> a[1] - b[1]);
      HashSet<Integer> visited = new HashSet<>();
      dis.add(new int[]{start, 0});
      int counter = 0;

      while (!dis.isEmpty()) {
        int[] current = dis.poll();
        int currentIndex = current[0];
        int distanceFromStart = current[1];

        if (visited.contains(currentIndex)) {
          continue;
        } else {
          visited.add(currentIndex);
          counter++;
        }

        HashMap<Integer, Integer> neighbors = adjacent.get(currentIndex);
        for (int neighborIndex : neighbors.keySet()) {
          if (!visited.contains(neighborIndex) && neighbors.get(neighborIndex) + distanceFromStart <= distanceThreshold) {
            dis.add(new int[]{neighborIndex, neighbors.get(neighborIndex) + distanceFromStart});
          }
        }
      }
//      System.out.println("start: "+start+"    counter: "+counter);
      if (counter <= min) {
        result = start;
        min = counter;
      }
    }

    return result;
  }
}










