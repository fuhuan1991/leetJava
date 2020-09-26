package AmazonOA;

import java.util.ArrayList;
import java.util.Arrays;

public class MoviesonFlight {

  public static int [] test(int [] nums, int d) {
    int [] result = new int [2];
    int max = Integer.MIN_VALUE;
    int left = 0;
    int right = nums.length-1;

    Integer[] indexes = new Integer[nums.length];
    for (int i = 0; i < nums.length; ++i) {
      indexes[i] = i;
    }

    Arrays.sort(indexes, (a, b) -> {
      return nums[a] - nums[b];
    });
System.out.println(Arrays.toString(indexes));
    ArrayList<Integer> a = new ArrayList<Integer>();

    while(left < right) {
      if((nums[left] + nums[right]) <= d-30) {
        int sum = nums[left] + nums[right];
        if (sum > max) {
          max = sum;
          result[0] = left;
          result[1] = right;
        }
        left ++;
      } else {
        right--;
      }
    }

    return result;
  }

  public static void main(String[] args) {
    int d = 250;
    int [] nums =  new int [] {90, 85, 75, 60, 120, 150, 125};
    int[] r = test(nums, d);
    System.out.println(Arrays.toString(r));

  }
}

