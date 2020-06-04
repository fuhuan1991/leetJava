import java.util.*;

class Solution975 {
  public int oddEvenJumps(int[] A) {
    int len = A.length;
    if (len == 0) return 0;
    if (len == 1) return 1;
    int[] oddNext = new int[len];
    int[] evenNext = new int[len];
    Stack<int[]> oddStack = new Stack<>();
    Stack<int[]> evenStack = new Stack<>();
    PriorityQueue<int[]> oddQueue = new PriorityQueue<>((a, b) -> {
      if (a[1] - b[1] == 0) {
        return a[0] - b[0];
      } else {
        return a[1] - b[1];
      }
    });
    PriorityQueue<int[]> evenQueue = new PriorityQueue<>((a, b) -> {
      if (a[1] - b[1] == 0) {
        return a[0] - b[0];
      } else {
        return b[1] - a[1];
      }
    });

    for (int i = 0; i < A.length; ++i) {
      oddQueue.add(new int[]{i, A[i]});
      evenQueue.add(new int[]{i, A[i]});
    }

    while (!oddQueue.isEmpty()) {
      int[] record = oddQueue.poll();
      while (!oddStack.isEmpty() && oddStack.peek()[0] < record[0]) {
        int[] startPoint = oddStack.pop();
        oddNext[startPoint[0]] = record[0];
      }
      oddStack.push(record);
    }

    while (!evenQueue.isEmpty()) {
      int[] record = evenQueue.poll();
      while (!evenStack.isEmpty() && evenStack.peek()[0] < record[0]) {
        int[] startPoint = evenStack.pop();
        evenNext[startPoint[0]] = record[0];
      }
      evenStack.push(record);
    }

//    System.out.print(Arrays.toString(oddNext));
//    System.out.print(Arrays.toString(evenNext));

    //DP
    boolean[] dp_even = new boolean[len];
    boolean[] dp_odd = new boolean[len];
    int result = 1;
    dp_even[len-1] = true;
    dp_odd[len-1] = true;

    for (int i = len-2; i >=0; --i) {
      dp_even[i] = evenNext[i] == 0? false : dp_odd[evenNext[i]];
      dp_odd[i] = oddNext[i] == 0? false : dp_even[oddNext[i]];
      if(dp_odd[i]) result++;
    }

    // System.out.print(Arrays.toString(dp_odd));
    // System.out.print(Arrays.toString(dp_even));

    return result;
  }
}