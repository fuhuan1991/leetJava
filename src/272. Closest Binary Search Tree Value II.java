import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

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

  private Stack<TreeNode> leftStack;
  private Stack<TreeNode> rightStack;

  public List<Integer> closestKValues(TreeNode root, double target, int k) {
    this.leftStack = new Stack<>();
    this.rightStack = new Stack<>();
    List<Integer> result = new LinkedList<>();
    TreeNode current = root;

    while (current != null) {
      if (current.val <= target) {
        this.leftStack.push(current);
        current = current.right;
      } else {
        this.rightStack.push(current);
        current = current.left;
      }
    }

    while (k > 0) {
      if (this.leftStack.size() == 0 && this.rightStack.size() == 0) {
        return result;
      } else if (this.leftStack.size() == 0) {
        result.add(this.getSuccessor());
      } else if (this.rightStack.size() == 0) {
        result.add(this.getPredecessor());
      } else if (Math.abs(target - leftStack.peek().val) < Math.abs(target - rightStack.peek().val)){
        result.add( getPredecessor() );
      } else {
        result.add( getSuccessor() );
      }
      k--;
    }

    return result;
  }

  private int getPredecessor() {
    TreeNode popped = this.leftStack.pop();
    TreeNode p = popped.left;
    while (p != null) {
      this.leftStack.push(p);
      p = p.right;
    }
    return popped.val;
  }

  private int getSuccessor() {
    TreeNode popped = this.rightStack.pop();
    TreeNode p = popped.right;
    while (p != null) {
      this.rightStack.push(p);
      p = p.left;
    }
    return  popped.val;
  }
}