import java.util.*;

class Solution336 {
  public List<List<Integer>> palindromePairs(String[] words) {
    Hashtable<String, Integer> table = new Hashtable<String, Integer>();
    List<List<Integer>> r = new ArrayList<List<Integer>>();

    for (int i = 0; i <= words.length-1; i++) {
      table.put(words[i], i);
    }

    for (int i = 0; i <= words.length-1; i++) {
      String word = words[i];
      for (int j = 0; j <= word.length(); j++) {
        String left = word.substring(0, j);
        String right = word.substring(j);
//        System.out.println(left + '-' + right);
        if (isPalindrome(left)) {
          String reverseRight = new StringBuilder(right).reverse().toString();
          if (table.containsKey(reverseRight) && table.get(reverseRight) != i) {
            ArrayList<Integer> pair = new ArrayList<Integer>(2);
            pair.add(table.get(reverseRight));
            pair.add(i);
            r.add(pair);
//            if (reverseRight == "") {
//              ArrayList<Integer> pair2 = new ArrayList<Integer>(2);
//              pair2.add(i);
//              pair2.add(table.get(reverseRight));
//              r.add(pair2);
//            }
          }
        }

        if (isPalindrome(right)) {
          String reverseLeft = new StringBuilder(left).reverse().toString();
          if (table.containsKey(reverseLeft) && table.get(reverseLeft) != i && right.length() != 0) {
            ArrayList<Integer> pair = new ArrayList<Integer>(2);
            pair.add(i);
            pair.add(table.get(reverseLeft));
            r.add(pair);
          }
        }
      }
    }
    System.out.println(r);
    return r;
  }

  private boolean isPalindrome (String s) {
    int len = s.length();
    if (len == 0) return true;
    for (int i = 0; i <= Math.floor(len/2); i++) {
      if (s.charAt(i) != s.charAt(len-1-i)) return false;
    }
    return true;
  }
}

