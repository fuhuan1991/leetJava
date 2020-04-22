import java.util.Stack;

class Solution503 {
  int len;
  public int[] nextGreaterElements(int[] nums) {
    if (nums.length == 0) {
      return new int[0];
    }
    this.len = nums.length;
    int max = -Integer.MAX_VALUE;
    int maxIndex = -1;

    for (int i = 0; i < nums.length; ++i) {
      if (nums[i] > max) {
        max = nums[i];
        maxIndex = i;
      }
    }

    int[] result = new int[len];
    result[maxIndex] = -1;
    int currentIndex = this.getNext(maxIndex);
    Stack<Integer> stack = new Stack<>();
    stack.add(max);

    while (currentIndex != maxIndex) {

      while (!stack.isEmpty() && stack.peek() <= nums[currentIndex]) {
        stack.pop();
      }

      if (stack.isEmpty()) {
        result[currentIndex] = -1;
      } else {
        result[currentIndex] = stack.peek();
      }
      stack.add(nums[currentIndex]);

      currentIndex = this.getNext(currentIndex);
    }

    return result;
  }

  private int getNext(int index) {
    if (index > 0) {
      return index-1;
    } else {
      return this.len-1;
    }
  }
}