import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

class Solution1229 {
  public List<Integer> minAvailableDuration(int[][] slots1, int[][] slots2, int duration) {
    Arrays.sort(slots1, Comparator.comparingInt(a -> a[0]));
    Arrays.sort(slots2, Comparator.comparingInt(a -> a[0]));

    int i = 0, j = 0;
    while (i < slots1.length && j < slots2.length) {
      int[] s1 = slots1[i];
      int[] s2 = slots2[j];

//      System.out.print(Arrays.toString(s1));
//      System.out.print(Arrays.toString(s2));

      if (s2[0] >= s1[1] || s2[1] <= s1[0]) {
        // no intersection
        if (s1[1] <= s2[1]) {
          i++;
          continue;
        } else {
          j++;
          continue;
        }
      } else {
        // there is a intersection
        if (s2[0] <= s1[0] && s1[1] <= s2[1]) {
//          System.out.print(1);
          // s1 inside s2
          int len  = s1[1] - s1[0];
          if (len >= duration) {
            LinkedList<Integer> r = new LinkedList<>();
            r.add(s1[0]);
            r.add(s1[0] + duration);
            return r;
          }
          i++;
          continue;
        } else if (s1[0] <= s2[0] && s2[1] <= s1[1]) {
//          System.out.print(2);
          // s2 inside s1
          int len  = s2[1] - s2[0];
          if (len >= duration) {
            LinkedList<Integer> r = new LinkedList<>();
            r.add(s2[0]);
            r.add(s2[0] + duration);
            return r;
          }
          j++;
          continue;
        } else if (s1[0] < s2[0] && s2[0] < s1[1] && s1[1] < s2[1]) {
//          System.out.print(3);
          // s1 before s2
          int len  = s1[1] - s2[0];
          if (len >= duration) {
            LinkedList<Integer> r = new LinkedList<>();
            r.add(s2[0]);
            r.add(s2[0] + duration);
            return r;
          }
          i++;
          continue;
        } else {
//          System.out.print(4);
          // s2 before s1
          int len  = s2[1] - s1[0];
          if (len >= duration) {
            LinkedList<Integer> r = new LinkedList<>();
            r.add(s1[0]);
            r.add(s1[0] + duration);
            return r;
          }
          j++;
          continue;
        }
      }
    }
    return new LinkedList<>();
  }
}