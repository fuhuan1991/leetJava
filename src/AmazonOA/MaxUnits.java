package AmazonOA;

import java.util.*;

public class MaxUnits {
  public static long getMaxUnits(List<Long> boxes, List<Long> unitsPerBox, long truckSize) {

    PriorityQueue<long[]> pq = new PriorityQueue<>((a, b) -> {
      if (a[0] > b[0]) {
        return -1;
      } else if (a[0] == b[0]) {
        return 0;
      } else {
        return 1;
      }
    });

    // sort the products based on their efficiency
    for (int i = 0; i < unitsPerBox.size(); ++i) {
      pq.add(new long[]{unitsPerBox.get(i), boxes.get(i)});
    }

    int result = 0;
    while (truckSize > 0) {
      long[] product = pq.poll();
      long boxNum = product[1];
      long perBox = product[0];

      if (boxNum < truckSize) {
        result += boxNum * perBox;
        truckSize -= boxNum;
      } else {
        result += truckSize * perBox;
        truckSize = 0;
      }
    }

    return result;
  }

  public static void main(String[] args) {
    LinkedList<Long> boxes = new LinkedList<>();
    boxes.add(Long.valueOf(1));
    boxes.add(Long.valueOf(2));
    boxes.add(Long.valueOf(3));

    LinkedList<Long> unitPerBox = new LinkedList<>();
    unitPerBox.add(Long.valueOf(3));
    unitPerBox.add(Long.valueOf(2));
    unitPerBox.add(Long.valueOf(1));

    System.out.println(getMaxUnits(boxes, unitPerBox, 4));
  }
}
