package AmazonOA;

import java.util.ArrayDeque;
import java.util.Deque;

class SlidingWindowMax {
  public int[] maxSlidingWindow(int[] nums, int k) {

    Deque<Integer> window = new ArrayDeque<>();

    // initialization
    for (int i = 0; i < k; ++i) {
      int num = nums[i];
      while (window.size() > 0 && nums[window.peekLast()] <= num) {
        window.removeLast();
      }
      window.offerLast(i);
    }

    int[] result  = new int[nums.length - k + 1];
    result[0] = nums[window.peekFirst()];

    for (int i = k; i < nums.length; ++i) {
      int newNumber = nums[i];
      if (window.peekFirst() == i - k) window.removeFirst();
      while (window.size() > 0 && nums[window.peekLast()] <= newNumber) {
        window.removeLast();
      }
      window.offerLast(i);
      result[i - k + 1] = nums[window.peekFirst()];
    }

    return result;
  }
}