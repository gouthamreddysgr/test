import java.util.*;
class subrootcheck {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (subRoot == null) {
            return true; // An empty tree is a subtree of any tree
        }
        if (root == null) {
            return false; // Non-empty tree cannot be a subtree of an empty tree
        }

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while (!q.isEmpty()) {
            TreeNode current = q.poll();

            if (current.val == subRoot.val) {
                if(isIdentical(current, subRoot)){return true;}
            }

            if (current.left != null) {
                q.offer(current.left);
            }

            if (current.right != null) {
                q.offer(current.right);
            }
        }

        return false;
    }\

    private boolean isIdentical(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return true;
        }
        if (root1 == null || root2 == null) {
            return false;
        }

        return (root1.val == root2.val) &&
               isIdentical(root1.left, root2.left) &&
               isIdentical(root1.right, root2.right);
    }
    public static void main(String[] args) {
        subrootcheck s = new subrootcheck();
        TreeNode r = new TreeNode(3);
        r.left = new TreeNode(4);
        r.right = new TreeNode(5);
        r.left.left = new TreeNode(1);
        r.left.right = new TreeNode(2);
        TreeNode rr = new TreeNode(4);
        rr.left = new TreeNode(1);
        rr.right = new TreeNode(2);
        boolean b = s.isSubtree(r, rr);
        System.out.println(b);

    }
}