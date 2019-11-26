import java.util.*;
import java.lang.reflect.*;

class Test {

  public static void main(String[] args) {
    Solution o = new Solution();
    int[][] pairs = {
            {1, 2},
            {2, 3},
            {3, 4}
    };
    int r = o.findLongestChain(pairs);
    System.out.println(r);

  }
}