import java.util.Stack;

class Solution331 {
  public boolean isValidSerialization(String preorder) {

    String[] arr = preorder.split(",");
    Stack<String> s = new Stack<>();

    for (int i = 0; i < arr.length; ++i) {
      s.add(arr[i]);
      while (s.size() > 2 && this.removeCheck(s)) {
        s.pop();
        s.pop();
        s.pop();
        s.push("#");
      }
    }
    return s.size() == 1 && s.pop().equals("#");
  }

  private boolean removeCheck(Stack<String> s) {
    int len = s.size();
    String e3 = s.elementAt(len-1);
    String e2 = s.elementAt(len-2);
    String e1 = s.elementAt(len-3);
    return e3.equals("#") && e2.equals("#") && !e1.equals("#");
  }
}