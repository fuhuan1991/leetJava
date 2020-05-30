import java.util.Arrays;

class Solution {

  private int[] nums;

  public int findKthLargest(int[] nums, int k) {
    this.nums = nums;
    return find(0, nums.length-1, k);
  }

  private int find(int start, int end, int k) {
    int p = this.partition(start, end);
    int leftLength = p - start + 1;
    if (leftLength == k) {
      return  this.nums[p];
    } else if (leftLength < k) {
      return find(p + 1, end, k - leftLength);
    } else {
      return find(start, p - 1, k);
    }
  }

  private int partition(int start, int end) {
    int pivot = this.nums[start];
    int left = start + 1;
    int right = end;

    while (true) {
      while (left < right && this.nums[left] >= pivot) {
        left++;
      }
      while (left <= right && this.nums[right] < pivot) {
        right--;
      }
      if (left >= right) break;
      this.swap(left, right);
    }
    swap(start, right);
    return right;
  }

  private void swap(int i, int j) {
    int temp = this.nums[i];
    this.nums[i] = this.nums[j];
    this.nums[j] = temp;
  }
}