import java.util.*;

class Solution692 {
  public List<String> topKFrequent(String[] words, int k) {
    Hashtable<String, Integer> count = new Hashtable<String, Integer>();
    for (String word: words) {
      if (count.containsKey(word)) {
        count.put(word, count.get(word) + 1);
      } else {
        count.put(word, 1);
      }
    }
//    System.out.println(count);
    PriorityQueue<String> heap = new PriorityQueue<String>(
            (w1, w2) -> count.get(w1).equals(count.get(w2)) ?
            w2.compareTo(w1) : count.get(w1) - count.get(w2) );
    for (String item:count.keySet()) {
      heap.offer(item);
      if (heap.size() > k) heap.poll();
    }
    ArrayList<String> r = new ArrayList<String>(k);
    while (k > 0) {
      r.add(heap.poll());
      k--;
    }
    Collections.reverse(r);
    return r;
  }
}