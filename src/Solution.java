class Solution {
  public int minSteps(int n) {
    int ans = 0;
    int d = 2;
    while (n > 1) {
      while (n%d == 0) {
        n = n / d;
        ans = ans + d;
      }
      d++;
    }
    return ans;
  }
}