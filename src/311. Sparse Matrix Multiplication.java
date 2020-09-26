class Solution311 {

  int len;
  int[][] A;
  int[][] B;

  public int[][] multiply(int[][] A, int[][] B) {
    this.len = B.length;
    this.A = A;
    this.B = B;
    int[][] result = new int[A.length][B[0].length];
    for (int i = 0; i < A.length; i++) {
      for (int j = 0; j < B[0].length; j++) {
        result[i][j] = this.helper(i, j);
      }
    }
    return result;
  }

  private int helper (int A_row, int B_column) {
    int r = 0;
    for (int i = 0; i < len; i++) {
      r += A[A_row][i] * B[i][B_column];
    }
    return r;
  }
}