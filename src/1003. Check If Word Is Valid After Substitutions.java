import java.util.Stack;

class Solution1003 {
  public boolean isValid(String S) {

    char[] stack = new char[S.length()];
    int index = 0;

    for (int i = 0; i < S.length(); ++i) {
      char c = S.charAt(i);
      if (index < 2 || c != 'c') {
        if (index == 0 && c != 'a') return false;
        stack[index++] = c;
      } else {
        Character c2 = stack[index - 1];
        Character c1 = stack[index - 2];
        if (c1 == 'a' && c2 == 'b') {
          index -= 2;
        } else {
          stack[index++] = c;
        }
      }

    }

    return index == 0;
  }
}