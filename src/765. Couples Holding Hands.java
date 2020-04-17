import java.util.HashMap;
import java.util.HashSet;

class Solution765 {

  HashMap<Integer, Integer> M = new HashMap<>();
  HashSet<Integer> visited = new HashSet<>();
  int N;
  int[] R;

  public int minSwapsCouples(int[] row) {

    this.N = row.length/2;
    this.R = row;
    int cycles = 0;

    // traverse all the people
    for (int i = 0; i < row.length; ++i) {
      M.put(row[i], i/2);
    }

    // traverse all the 2-set couches
    for (int i = 0; i < N; ++i) {

      if (visited.contains(i)) continue;

      // this couple is all set
      if (getTheOther(row[2*i]) == row[2*i + 1]) {
        continue;
      }

      // explore the cycle
      this.visited.add(i);
      int connector = row[2*i + 1];
      int [] x = this.nextCycle(connector, i);
      int currentCouch = x[1];
      connector = x[0];

      while(!this.visited.contains(currentCouch)) {
        visited.add(currentCouch);
        int [] y = this.nextCycle(connector, currentCouch);
        currentCouch = y[1];
        connector = y[0];
        cycles++;
      }

    }


    return cycles;
  }

  private int[] nextCycle(int person, int couch) {

    if (this.R[2*couch] == person) {
      // this person is at left
      int theOther = this.getTheOther(R[2*couch+1]);
      return new int[]{theOther, this.M.get(theOther)};
    } else {
      // .... right
      int theOther = this.getTheOther(R[2*couch]);
      return new int[]{theOther, this.M.get(theOther)};
    }
  }



  private int getTheOther(int a) {
    if (a%2 == 0) {
      return a + 1;
    } else {
      return a - 1;
    }
  }
}