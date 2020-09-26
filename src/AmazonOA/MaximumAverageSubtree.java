package AmazonOA;

class MaximumAverageSubtree {

  double max = 0;

  public double maximumAverageSubtree(TreeNode root) {

    double[] r = this.analyze(root);

    return max;
  }

  private double[] analyze (TreeNode node) {
    if (node == null) {
      return new double[]{0, 0};
    } else {
      double[] rl = this.analyze(node.left);
      double[] rr = this.analyze(node.right);

      int counter = 1 + (int)rl[0] + (int)rr[0];
      double sum = node.val + rl[0]*rl[1] + rr[0]*rr[1];
      double avg = sum/counter;
      if (avg > this.max) this.max = avg;
      return new double[]{counter, avg};
    }
  }

  public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }
}

