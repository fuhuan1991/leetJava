import java.util.Arrays;

class Solution698 {
  public boolean canPartitionKSubsets(int[] nums, int k) {
    int sum = Arrays.stream(nums).sum();
    if (sum%k != 0) return false;
    int target = sum/k;
    Arrays.sort(nums);
    if (nums[nums.length-1] > target) return false;

    int index = nums.length-1;
    while(index >= 0 && nums[index] == target) {
      index--;
      k--;
    }

    if (index < 0) return true;

    return search(nums, index, target, new int[k]);
  }

  private boolean search(int[] nums, int index, int target, int[] groupSums) {
    if (index < 0)return true;
    int currentValue = nums[index];

    for (int i = 0; i <= groupSums.length-1; i++) {
      if (groupSums[i] + currentValue <= target) {
        groupSums[i] += currentValue;
        if (search(nums, index - 1, target, groupSums)) return true;
        groupSums[i] -= currentValue;
      }

      if (groupSums[i] == 0) break;
    }
    return false;
  }
}