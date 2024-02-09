import java.util.LinkedList;
import java.util.Queue;

class TreeNode {
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
 
class invertbinary {
    TreeNode result;
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();
            TreeNode temp = current.left;
            current.left = current.right;
            current.right = temp;
            if (current.left != null) queue.add(current.left);
            if (current.right != null) queue.add(current.right);
        }
        return root;
    }

    
    public static void main(String[] args) {
        invertbinary i =new invertbinary();
        TreeNode t = new TreeNode(4);
        t.left = new TreeNode(2);
        t.right = new TreeNode(7);
        t.left.left = new TreeNode(1);
        t.left.right = new TreeNode(3);
        t.right.left = new TreeNode(6);
        t.right.right = new TreeNode(9);
        TreeNode r = i.invertTree(t);
    }
}