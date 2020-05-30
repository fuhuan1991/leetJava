import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

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
class Solution {

  private HashSet<Integer> delete = new HashSet<>();

  public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
    List<TreeNode> result = new LinkedList<>();
    for (int i : to_delete) {
      this.delete.add(i);
    }
    this.trim(root, null, result);
    return result;
  }

  private void trim (TreeNode current, TreeNode parent, List<TreeNode> result) {
    if (current == null) return;
    trim(current.left, current, result);
    trim(current.right, current, result);
    if (this.delete.contains(current.val)) {
      if (parent != null && parent.left == current) parent.left = null;
      if (parent != null && parent.right == current) parent.right = null;
      if (current.left != null) result.add(current.left);
      if (current.right != null) result.add(current.right);
    } else {
      if (parent == null) result.add(current);
    }
  }
}