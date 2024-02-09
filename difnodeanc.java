import java.util.*;
class difnodeanc {

    int maxDiff = 0;

    public int maxAncestorDiff(TreeNode root) {
        findDiff(root, root.val, root.val);
        return maxDiff;
    }

    private void findDiff(TreeNode root, int minAncestor, int maxAncestor) {
        if (root == null) {
            return;
        }

        maxDiff = Math.max(maxDiff, Math.abs(root.val - minAncestor));
        maxDiff = Math.max(maxDiff, Math.abs(root.val - maxAncestor));

        minAncestor = Math.min(minAncestor, root.val);
        maxAncestor = Math.max(maxAncestor, root.val);

        findDiff(root.left, minAncestor, maxAncestor);
        findDiff(root.right, minAncestor, maxAncestor);
    }

    public static void main(String[] args) {
        difnodeanc d =new difnodeanc();
        TreeNode t = new TreeNode(8);
        t.left = new TreeNode(3);
        t.right = new TreeNode(10);
        t.left.left = new TreeNode(1);
        t.left.right = new TreeNode(6);
        t.left.right.left = new TreeNode(4);
        t.left.right.right = new TreeNode(7);
        t.right.right = new TreeNode(14);
        t.right.right.left = new TreeNode(13);
        int num = d.maxAncestorDiff(t);
        System.out.println(num);
    }
}