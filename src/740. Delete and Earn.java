class Solution740 {
  public int deleteAndEarn(int[] nums) {
    int[] number = new int [10001];
    for (int x:nums) {
      number[x]++;
    }

    int avoidPrevK = 0;
    int usingPrevK = 0;
    int prevK = -1;

    for (int k = 0; k <= 10000; k++) {
      // is the value k actually in the input array,
      // if it is not, we don't need to analyze it.
      if (number[k] > 0) {
        int prevMax = Math.max(avoidPrevK, usingPrevK);
        // use k or not use k
        int avoidK,usingK;
        if (prevK == k-1) {
          avoidK = prevMax;
          usingK = avoidPrevK + k * number[k];
        } else {
          avoidK = prevMax;
          usingK = prevMax + k * number[k];
        }
        prevK = k;
        avoidPrevK = avoidK;
        usingPrevK = usingK;
      }
    }
    return Math.max(avoidPrevK, usingPrevK);
  }
}