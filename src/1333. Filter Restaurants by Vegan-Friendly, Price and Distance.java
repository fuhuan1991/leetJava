import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

class Solution1333 {
  public List<Integer> filterRestaurants(int[][] restaurants, int veganFriendly, int maxPrice, int maxDistance) {
    PriorityQueue<Integer> queue = new PriorityQueue<Integer>((a, b) -> {
      if (restaurants[a][1] == restaurants[b][1]) {
        return restaurants[b][0] - restaurants[a][0];
      } else {
        return restaurants[b][1] - restaurants[a][1];
      }
    });

    for (int i = 0; i <= restaurants.length-1; ++i) {
      int[] restaurant = restaurants[i];
      boolean vegan = veganFriendly == 0 || (veganFriendly == 1 && restaurant[2] == 1);

      if (vegan && restaurant[3] <= maxPrice && restaurant[4] <= maxDistance) {
        queue.add(i);
      }
    }

    List<Integer> result = new LinkedList<Integer>();
    while (!queue.isEmpty()) {
      result.add(restaurants[queue.remove()][0]);
    }
    return result;
  }
}