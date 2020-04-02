import java.util.ArrayList;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution1214 {
  public boolean twoSumBSTs(TreeNode root1, TreeNode root2, int target) {
    if (root1 == null || root2 == null) return false;

    ArrayList<Integer> a1 = new ArrayList<>();
    ArrayList<Integer> a2 = new ArrayList<>();

    inOrder(root1, a1);
    inOrder(root2, a2);

    int i1 = 0;
    int i2 = a2.size() - 1;

    while (i1 <= a1.size()-1 && i2 >= 0) {
      int v = a1.get(i1) + a2.get(i2);
      if ( v == target) return true;
      if (v < target) {
        i1++;
      } else {
        i2--;
      }
    }
    return false;
  }

  private void inOrder(TreeNode node, ArrayList<Integer> arr) {
    if (node == null) return;
    inOrder(node.left, arr);
    arr.add(node.val);
    inOrder(node.right, arr);
  }
}