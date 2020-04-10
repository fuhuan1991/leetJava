import java.util.Stack;

class Solution439 {
  public String parseTernary(String expression) {
//    Stack<String> s1 = new Stack<>();
//    Stack<String> s2 = new Stack<>();
    if (expression.length() == 1) return expression;

    char condition = expression.charAt(0);
    int balance = 0;
    int pivot = 0;

    for (int i = 2; i < expression.length(); ++i) {
      if (balance == 0 && expression.charAt(i) == ':') {
        pivot = i;
        break;
      } else if (expression.charAt(i) == ':') {
        balance--;
      } else if (expression.charAt(i) == '?') {
        balance++;
      }
    }

    if (condition == 'T') {
      return parseTernary(expression.substring(2, pivot));
    } else {
      return parseTernary(expression.substring(pivot+1));
    }
  }
}