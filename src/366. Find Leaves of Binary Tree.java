import java.util.Deque;
import java.util.HashMap;
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
class Solution366 {

  private HashMap<TreeNode, TreeNode> parents;
  private Deque<TreeNode> queue;

  public List<List<Integer>> findLeaves(TreeNode root) {

    if (root == null) return new LinkedList<>();

    this.parents = new HashMap<>();
    this.queue = new LinkedList<>();
    this.helper(root, null);
    List<List<Integer>> result = new LinkedList<>();
    this.queue.offer(new TreeNode(0));

    LinkedList<Integer> layer = new LinkedList<>();
    while (!this.queue.isEmpty()) {
      TreeNode current = this.queue.poll();

      if (current.left == root && current.right == root) {
        // marker detected
        result.add(layer);
        layer = new LinkedList<>();
        if (this.queue.size() == 0) break;
        this.queue.offer(new TreeNode(0));
        continue;
      }

      layer.add(current.val);
      TreeNode p = this.parents.get(current);

      if (p == null) {
        continue;
      } else {
        if (p.left == current) p.left = null;
        if (p.right == current) p.right = null;
        if (p.left == null && p.right == null) this.queue.offer(p);
      }
    }
    return result;
  }

  private void helper(TreeNode node, TreeNode parent) {
    this.parents.put(node, parent);
    if (node.left != null) helper(node.left, node);
    if (node.right != null) helper(node.right, node);
    if (node.left == null && node.right == null) {
      this.queue.offer(node);
    }
  }
}