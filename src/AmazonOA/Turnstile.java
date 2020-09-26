package AmazonOA;

import java.util.*;

public class Turnstile {

  public static int[] getTimes(int numCustomers, int[] arrTime, int[] direction) {

    int[] result = new int[numCustomers];

    Map<Integer, List<int[]>> map = new HashMap<Integer, List<int[]>>();

    Queue<int[]> entryQ = new ArrayDeque<int[]>();
    Queue<int[]> exitQ = new ArrayDeque<int[]>();

    int turnstileDirection = -1; // default unused-1

    for (int index = 0; index < numCustomers; ++index) {
      int t = arrTime[index];
      if (!map.containsKey(t)) {
        map.put(t, new ArrayList<int[]>());
      }
      map.get(t).add(new int[] { index, direction[index] });
    }

//    System.out.println(map);

    int time = 0; // used to determine timeStamp,
    while (numCustomers > 0) {

      if (map.containsKey(time)) {
        List<int[]> customers = map.get(time);

        for (int[] customer : customers) {
          if (customer[1] == 1) {
            exitQ.add(customer);
          } else {
            entryQ.add(customer);
          }
        }
      }

      if (entryQ.isEmpty() && exitQ.isEmpty()) {
        turnstileDirection = -1;
        time++;
        continue;
      }

      int[] current;
      if (!entryQ.isEmpty() && !exitQ.isEmpty()) {

        switch (turnstileDirection) {
          case -1: // unused
            current = exitQ.poll();
            result[current[0]] = time;
            numCustomers--;
            turnstileDirection = 1;
            time++;
            break;

          case 1: // used for exit
            current = exitQ.poll();
            result[current[0]] = time;
            numCustomers--;
            turnstileDirection = 1;
            time++;
            break;

          case 0: // used to entry
            current = entryQ.poll();
            result[current[0]] = time;
            numCustomers--;
            turnstileDirection = 0;
            time++;
            break;

        }
        continue;
      }

      if (!entryQ.isEmpty()) {
        current = entryQ.poll();
        result[current[0]] = time;
        numCustomers--;
        turnstileDirection = 0;
        time++;
        continue;
      }

      if (!exitQ.isEmpty()) {
        current = exitQ.poll();
        result[current[0]] = time;
        numCustomers--;
        turnstileDirection = 1;
        time++;
        continue;
      }
    }

    return result;
  }

  public static void main(String[] args) {
    System.out.println(Arrays.toString(getTimes(4, new int[]{0,0,1,5}, new int[]{0,1,1,0})));
    System.out.println(Arrays.toString(getTimes(5, new int[]{0,1,1,3,3}, new int[]{0,1,0,0,1})));
  }
}

