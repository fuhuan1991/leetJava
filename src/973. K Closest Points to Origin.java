import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

class Solution973 {

  private int[][] points;

  public int[][] kClosest(int[][] points, int K) {
    this.points = points;
    this.sort(0, points.length-1, K);
    return Arrays.copyOfRange(points, 0, K);
  }

  private void sort(int start, int end, int K) {
    if (start >= end) return;
    int mid = partition(start, end);
    int leftLen = mid - start + 1;
    if (leftLen == K) {
      return;
    } else if (leftLen < K) {
      sort(mid + 1, end, K - leftLen);
    } else {
      sort(start, mid - 1, K);
    }
  }

  public int partition(int start, int end) {
    int pivot = this.dist(start);
    int left = start+1;
    int right = end;

    while (true) {
      while (left < right && dist(left) <= pivot) {
        left++;
      }
      while (left <= right && dist(right) > pivot) {
        right--;
      }
      if (left >= right) break;
      this.swap(left, right);
    }
    swap(right, start);
    return right;
  }

  private int dist(int i) {
    return this.points[i][0] * this.points[i][0] + this.points[i][1] * this.points[i][1];
  }

  private void swap(int i, int j) {
    int t0 = this.points[i][0];
    int t1 = this.points[i][1];
    this.points[i][0] = this.points[j][0];
    this.points[i][1] = this.points[j][1];
    this.points[j][0] = t0;
    this.points[j][1] = t1;
  }
}