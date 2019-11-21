class Solution651 {
  public int maxA(int N) {
    int[] best = new int[N+1];
    for (int k = 1; k <= N; ++k) {
      best[k] = best[k-1] + 1;
      // unknown operation,   Ctrl A, Ctrl C, Ctrl V
      // k-3(x might be here)  k-2      k-1      k
      for (int x = 0; x <= k-3; ++x)
        best[k] = Math.max(best[k], best[x] + best[x] * (k-x-2));
    }
    return best[N];
  }
}