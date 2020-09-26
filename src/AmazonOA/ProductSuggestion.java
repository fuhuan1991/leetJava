package AmazonOA;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

class ProductSuggestion {
  public List<List<String>> suggestedProducts(String[] products, String searchWord) {

    Arrays.sort(products);
    List<List<String>> result = new LinkedList<List<String>>();
    TrieNode root = new TrieNode();

    // build the trie
    for (String product : products) {
      TrieNode current = root;
      int i = 0;
      while (i < product.length()) {
        int charIndex = product.charAt(i) - 'a';
        // System.out.println(charIndex);

        if (current.pointers[charIndex] != null) {
          current = current.pointers[charIndex];
        } else {
          current.pointers[charIndex] = new TrieNode();
          current = current.pointers[charIndex];
        }
        current.words.add(product);
        i++;
      }
    }

    // analyze search text
    TrieNode current = root;
    int i = 0;
    boolean noMore = false;
    while (i < searchWord.length()) {
      List<String> r = new LinkedList<String>();
      if (noMore) {
        // no chance to get any other suggestions
        result.add(r);
        i++;
      } else {
        int charIndex = searchWord.charAt(i) - 'a';

        if (current.pointers[charIndex] != null) {
          // if there are available suggestions, display the first 3
          current = current.pointers[charIndex];
          int len = Math.min(3, current.words.size());
          for (int j = 0; j < len; j++) {
            String target = current.words.get(j);
            r.add(target);
          }
        } else {
          noMore = true;
        }

        result.add(r);
        i++;
      }
    }

    return result;
  }
}

class TrieNode {

  public TrieNode[] pointers;
  public ArrayList<String> words;

  public TrieNode() {
    this.pointers = new TrieNode[26];
    this.words = new ArrayList<String>();
  }
}