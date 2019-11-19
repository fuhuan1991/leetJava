import java.util.PriorityQueue;

class MedianFinder {
  private PriorityQueue<Integer> q1;
  private PriorityQueue<Integer> q2;
  /** initialize your data structure here. */
  public MedianFinder() {
    this.q1 = new PriorityQueue<Integer>((a,b) -> b-a);
    this.q2 = new PriorityQueue<Integer>((a,b) -> a-b);
  }

  public void addNum(int num) {
    q1.offer(num);
    q2.offer(q1.poll());

    if (q1.size() > q2.size() + 1) {
      q2.offer(q1.poll());
    } else if (q1.size() < q2.size()) {
      q1.offer(q2.poll());
    }
  }

  public double findMedian() {
    if (q1.size() == q2.size()) {
      return ((double) q1.peek()+ (double) q2.peek())/2;
    } else {
      return (double)q1.peek();
    }
  }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */