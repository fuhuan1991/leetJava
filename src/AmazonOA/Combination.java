package AmazonOA;

import java.util.Arrays;

public class Combination {
  public static void main(String[] args) {

    System.out.println(c(25,100));
  }

  private static long c(long r, long n) {

    if (n < r) {
      return 0;
    } else if (n == 0 || r == 0 || r == n) {
      return 1;
    }

    if (r > n-r) r = n-r;

    long result = 1;

    for (long i = 1; i <= r; ++i) {
      result *= n-i+1;
      result /= i;
    }

    return result;
  }
}
