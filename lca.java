import java.util.*;

import javax.swing.tree.TreeNode;

class lnode {
    int val;
    lnode left;
    lnode right;

    lnode(int x) {
        val = x;
    }
}

class lca {


    public lnode lowestCommonAncestor(lnode root, lnode p, lnode q) {
    if (root == null || root == p || root == q) return root;
    lnode left = lowestCommonAncestor(root.left, p, q);
    lnode right = lowestCommonAncestor(root.right, p, q);
    return left == null ? right : right == null ? left : root;
    }


    public static void main(String[] args) {
        // Create the tree nodes
        lnode root = new lnode(3);
        root.left = new lnode(5);
        root.right = new lnode(1);
        root.left.left = new lnode(6);
        root.left.right = new lnode(2);
        root.right.left = new lnode(0);
        root.right.right = new lnode(8);
        root.left.right.left = new lnode(7);
        root.left.right.right = new lnode(4);

        // Define nodes p and q
        lnode p = root.left;
        lnode q = root.left.right.right;

        // Create an instance of the lca class
        lca solution = new lca();

        // Find the lowest common ancestor of nodes p and q
        lnode ancestor = solution.lowestCommonAncestor(root, p, q);

        // Print the value of the lowest common ancestor node
        System.out.println("Lowest Common Ancestor: " + (ancestor != null ? ancestor.val : "null"));
    }
}
