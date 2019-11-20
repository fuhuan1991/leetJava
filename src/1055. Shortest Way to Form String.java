class Solution1055 {
  public int shortestWay(String source, String target) {

    int pt = 0;
    int counter = 0;

    while(pt <= target.length()-1) {
      // in every while loop, we try to match each character in source string in order.
      // a sub can be made by omitting characters that didn't match in source string.
      // by looping through each character in source,
      // we ensure that we can get the longest subString from source.
      boolean matchExist = false;
      for (int ps = 0; ps <= source.length()-1; ps++) {
        if (pt <= target.length()-1 && source.charAt(ps) == target.charAt(pt)) {
          pt++;
          matchExist = true;
        }
      }
      if(!matchExist) return -1;
      counter++;
    }
    return counter;
  }
}