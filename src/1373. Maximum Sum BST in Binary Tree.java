/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution1373 {

  int max = 0;

  public int maxSumBST(TreeNode root) {
    analyze(root);
    return this.max;
  }

  private int[] analyze(TreeNode node) {
    if (node == null) return null;

    int[] r1 = node.left == null? null : analyze(node.left);
    int[] r2 = node.right == null? null : analyze(node.right);

    if (r1 == null && r2 == null) {
      this.max = Math.max(this.max, node.val);
      return new int[]{node.val, 1, node.val, node.val};
    } else if (r1 == null && r2 != null) {
      if (r2[1] == 1 && node.val < r2[2]) {
        int sum = node.val + r2[0];
        this.max = Math.max(this.max, sum);
        return new int[]{sum, 1, node.val, r2[3]};
      } else {
        return new int[]{0, 0, 0, 0};
      }
    } else if (r1 != null && r2 ==null) {
      if (r1[1] == 1 && node.val > r1[3]) {
        int sum = node.val + r1[0];
        this.max = Math.max(this.max, sum);
        return new int[]{sum, 1, r1[2], node.val};
      } else {
        return new int[]{0, 0, 0, 0};
      }
    } else {
      if (r1[1] == 1 && r2[1] == 1 && r1[3] < node.val && node.val < r2[2]) {
        int sum = node.val + r1[0] + r2[0];
        this.max = Math.max(this.max, sum);
        return new int[]{sum, 1, r1[2], r2[3]};
      } else {
        return new int[]{0, 0, 0, 0};
      }
    }
  }
}