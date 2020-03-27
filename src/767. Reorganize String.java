import java.util.Arrays;
import java.util.HashMap;
import java.util.PriorityQueue;

class Solution767 {
  public String reorganizeString(String S) {
//    HashMap<Character, Integer> counter = new HashMap<>();
    int[] counter = new int[26];
    int N = S.length();
    int N_half = (int) Math.ceil(((double) N)/2);
    if (N == 1) return S;

    for (int i = 0; i <= N-1; i++) {
      int index = (S.charAt(i) - 'a');
      counter[index]++;
      if (counter[index] > N_half) return "";
    }
//    System.out.println(Arrays.toString(counter));

    PriorityQueue<CC> pq = new PriorityQueue<CC>(
            (CC a, CC b) -> a.count == b.count ? a.letter - b.letter : b.count - a.count);

    for (int i = 0; i < 26; i++) {
      if (counter[i] > 0) pq.add(new CC((char) ('a' + i), counter[i]));
    }

    StringBuilder ans = new StringBuilder();

    while (pq.size() >= 2) {
      CC c1 = pq.poll();
      CC c2 = pq.poll();

      ans.append(c1.letter);
      ans.append(c2.letter);

      if (--c1.count > 0) pq.add(c1);
      if (--c2.count > 0) pq.add(c2);
    }

    if (pq.size() > 0) ans.append(pq.poll().letter);

    return ans.toString();
  }
}

class CC {
  public Character letter;
  public Integer count;

  public CC(Character letter, Integer count) {
    this.letter = letter;
    this.count = count;
  }
}