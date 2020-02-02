import java.awt.*;
import java.util.HashMap;
import java.util.HashSet;

class ValidWordAbbr {
  private HashMap<String, HashSet<String>> store;

  public ValidWordAbbr(String[] dictionary) {
    this.store = new HashMap<String, HashSet<String>>();

    for (String word : dictionary) {
      String shortForm = this.getShortform(word);
      if (this.store.containsKey(shortForm)) {
        this.store.get(shortForm).add(word);
      } else{
        HashSet<String> set = new HashSet<String>();
        set.add(word);
        this.store.put(shortForm, set);
      }
    }
  }

  public boolean isUnique(String word) {
    if (this.store.get(this.getShortform(word)) == null) return true;

    HashSet<String> set = this.store.get(getShortform(word));
    if (set.size() == 1 && set.contains(word)) {
      return true;
    } else {
      return false;
    }
  }

  private String getShortform(String word) {
    if (word.length() <= 2) {
      return word;
    } else {
      return word.charAt(0) + "" + (word.length()-2) + word.charAt(word.length()-1);
    }
  }

  public void show () {
    for (String shortForm : this.store.keySet()) {
      System.out.print(shortForm + " => ");
      HashSet<String> set = this.store.get(shortForm);
      for (String word : set) {
        System.out.print(word + " ");
      }
      System.out.print("\n");
    }
  }
}

/**
 * Your ValidWordAbbr object will be instantiated and called as such:
 * ValidWordAbbr obj = new ValidWordAbbr(dictionary);
 * boolean param_1 = obj.isUnique(word);
 */