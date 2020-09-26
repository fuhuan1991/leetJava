package AmazonOA;// Java implementation to count total
// number of ways to split a string
// to get prime numbers
import java.util.*;

class PrimeSeg{

  static final int MOD =1000000007;
  static boolean []sieve = new boolean[1000000];

  // Function to build sieve
  static void buildSieve() {
    Arrays.fill(sieve, true);

    sieve[0] = false;
    sieve[1] = false;

    for(int p = 2; p * p <= 1000000; p++) {

      // If p is a prime
      if (sieve[p] == true) {

        // Update all multiples
        // of p as non prime
        for(int i = p * p; i < 1000000; i += p)
          sieve[i] = false;
      }
    }
  }

  // Function to check whether a number
// is a prime number or not
  static boolean isPrime(String number) {
    int num = Integer.valueOf(number);
    return sieve[num];
  }

  // Function to find the count
// of ways to split String
// into prime numbers
  static int rec(String number, int i, int []dp) {
    if (dp[i] != -1)
      return dp[i];
    int cnt = 0;

    for(int j = 1; j <= 6; j++)
    {

      // Number should not have a
      // leading zero and it
      // should be a prime number
      if (i - j >= 0 &&
              number.charAt(i - j) != '0' &&
              isPrime(number.substring(i - j, i)))
      {
        cnt += rec(number, i - j, dp);
        cnt %= MOD;
      }
    }
    return dp[i] = cnt;
  }

  // Function to count the
// number of prime Strings
  static int countPrimeStrings(String number) {
    int n = number.length();
    int []dp = new int[n + 1];

    Arrays.fill(dp, -1);
    dp[0] = 1;

    return rec(number, n, dp);
  }

  // Driver code
  public static void main(String[] args) {
    buildSieve();

    String s1 = "11373";
    for (int i = 0; i < 1000; i++) {
      s1 = s1 + "11373";
    }

    System.out.print(countPrimeStrings(s1) + "\n");
  }
}