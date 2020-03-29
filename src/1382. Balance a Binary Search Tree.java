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
class Solution1382 {
  ArrayList<Integer> list;

  public TreeNode balanceBST(TreeNode root) {
    this.list = new ArrayList<>();
    inOrder(root, list);
//    System.out.println(list);
    return build(0, list.size()-1, list);
  }

  private void inOrder(TreeNode node, ArrayList<Integer> result) {
    if (node == null) return;
    inOrder(node.left, result);
    result.add(node.val);
    inOrder(node.right, result);
  }

  private TreeNode build(int start, int end, ArrayList<Integer> list) {
    if (start == end) {
      return new TreeNode(list.get(start));
    } else if (start == end - 1) {
      TreeNode root = new TreeNode(list.get(start));
      root.right = new TreeNode(list.get(end));
      return root;
    } else {
      int mid = (start + end)/2;
      TreeNode root = new TreeNode(list.get(mid));
      TreeNode left = build(start, mid - 1, list);
      TreeNode right = build(mid + 1, end, list);
      root.left = left;
      root.right = right;
      return root;
    }
  }
}