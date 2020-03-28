/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution1038 {

  private int sum;

  public TreeNode bstToGst(TreeNode root) {
    this.sum = 0;
    travserse(root);
    return root;
  }

  private void travserse (TreeNode root) {
    if (root == null) return;
    System.out.println(root.val);

    this.travserse(root.right);

    this.sum += root.val;
    root.val = this.sum;
    System.out.println(root.val);
    System.out.println("-----");

    this.travserse(root.left);
  }
}

class TreeNode {
  int val;
  TreeNode left;
  TreeNode right;
  TreeNode(int x) { val = x; }
}