import java.util.*;

class Solution {

  HashMap<Integer, Integer> numbers;
  //  PriorityQueue<Integer> queue;
  int len;

  public int minSetSize(int[] arr) {
    this.numbers = new HashMap<>();
    this.len = arr.length;
    for (int i = 0; i < arr.length; ++i) {
      int number = arr[i];
      int v = this.numbers.getOrDefault(number, 0);
      this.numbers.put(number, v + 1);
    }
    return this.checkNumbers();
  }

  private int checkNumbers() {
    // System.out.print(this.numbers);
//    PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> this.numbers.get(b) - this.numbers.get(a));
    List<Integer> num = new LinkedList<>();
    for (int i : this.numbers.keySet()) {
      num.add(i);
    }
    num.sort((a, b) -> this.numbers.get(b) - this.numbers.get(a));
    int deleteNumber = 0;
    int counter = 0;
//    while (true) {
//      int i = queue.poll();
//      // System.out.print(i);
//      counter ++;
//      deleteNumber += this.numbers.get(i);
//      if (deleteNumber >= this.len/2) break;
//    }
    for (int i : num) {
      counter ++;
      deleteNumber += this.numbers.get(i);
      if (deleteNumber >= this.len/2) break;
    }
    return counter;
  }
}

