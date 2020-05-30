import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

class Solution {
  public List<List<String>> suggestedProducts(String[] products, String searchWord) {
    Arrays.sort(products);
    LinkedList<String> prods = new LinkedList<String>(Arrays.asList(products));
    List<List<String>> result = new LinkedList<List<String>>();

    for (int i = 0; i < searchWord.length(); i++) {
      char c = searchWord.charAt(i);
      for (int j = 0; j < prods.size();) {
        String str = prods.get(j);
        if (str.length() > i && str.charAt(i) != c) {
          prods.remove(j);
        } else {
          j++;
        }
      }
      LinkedList<String> r = new LinkedList<>();
      if (prods.size() == 0) {
        result.add(r);
      } else {
        int len = Math.min(3, prods.size());
        for (int k = 0; k < len; k++) {
          r.add(prods.get(k));
        }
        result.add(r);
      }
    }
    return result;
  }
}