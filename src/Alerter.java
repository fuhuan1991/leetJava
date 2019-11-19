import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.List;

public class Alerter {

  public static void main(String[] args) {
    // TODO Auto-generated method stub
    System.out.println(helper(new int[] {1, 2, 100, 2, 2}, 3, 1.5));
  }

  private LinkedList<Integer> queue;
  private int size;
  private double sum = 0;
  /** Initialize your data structure here. */
  public Alerter(int size) {
    queue = new LinkedList<Integer>();
    size = size;
  }

  public double next(int val) {
    sum += val;
    queue.offer(val);
    if(queue.size() > size){
      sum -= queue.poll();
    }
    return sum /(double)queue.size();
  }

  // Complete the alert function below.
  static boolean alert(List<Integer> inputs, int windowSize, float allowedIncrease) {
    int[] arr = new int[inputs.size()];
    for(int i = 0; i < inputs.size(); i++){
      arr[i] = inputs.get(i);
    }
    return helper(arr, windowSize, allowedIncrease);
  }

  public static boolean helper(int[] arr, int s, double b) {
    int n = arr.length;
    // store each max in each window
    int[] maxs = maxSlidingWindow(arr, s);
    // store avg for each window
    double[] avgs = new double[n - s + 1];
    int sum = 0;
    // caculate avg for each window
    for(int i = 0; i < n; i++) {
      if(i <= s - 1) {
        sum += arr[i];
      }else {
        sum -= arr[i - s];
        sum += arr[i];
      }

      if(i >= s - 1) {
        avgs[i - (s - 1)] = (double)sum / (double) s;
      }
    }
    Double min = null;
    Double max = null;
    // check whether prevous avg in one window would be smaller than current avg in window
    // by tracking min avg and max avg so far
    for(int i = 0; i < maxs.length; i++) {
      if(min == null || avgs[i] < min) {
        min = avgs[i];
      }

      if(max == null || avgs[i] > max) {
        max = avgs[i];
      }

      if(min != null && max != null && max / min > b) {
        return true;
      }
    }

    // check whether a num is larger than all avgs for each window this num exist
    // if so return true
    for(int i = 0; i < maxs.length; i++) {
      boolean temp = true;
      for(int j = i; j < i + s && j < avgs.length; j++) {
        if(maxs[i] / avgs[j] <= b) {
          temp = false;
        }
      }

      if(temp) {
        return temp;
      }
    }
    return false;
  }
  // caculate the max num for each window
  public static int[] maxSlidingWindow(int[] nums, int k) {
    int n = nums.length;
    if(n == 0) return new int[0];
    int[] res = new int[n - k + 1];
    // store index
    ArrayDeque<Integer> queue = new ArrayDeque<>();
    for(int i = 0; i < n; i++){
      // remove numbers out of range k
      if(!queue.isEmpty() && i - queue.getFirst() > k - 1){
        queue.pollFirst();
      }
      // remove smaller numbers in k range as they are useless
      while(!queue.isEmpty() && nums[queue.getLast()] < nums[i]){
        queue.pollLast();
      }
      // q contains index... r contains content
      queue.offerLast(i);

      if(i >= k - 1){
        res[i - k + 1] = nums[queue.getFirst()];
      }
    }
    return res;
  }
}