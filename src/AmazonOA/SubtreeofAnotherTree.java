package AmazonOA;
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */


//class SubtreeofAnotherTree {
//  public boolean isSubtree(TreeNode s, TreeNode t) {
//    if (s == null && t == null) return true;
//    if (s == null || t == null) return false;
//    if (this.analyze(s, t)) return true;
//    return this.isSubtree(s.left, t) || this.isSubtree(s.right, t);
//  }
//
//  private boolean analyze(TreeNode s, TreeNode t) {
//    if (s == null && t == null) return true;
//    if (s == null || t == null) return false;
//    if (s.val == t.val) {
//      return this.analyze(s.left, t.left) && this.analyze(s.right, t.right);
//    } else {
//      return false;
//    }
//  }
//}