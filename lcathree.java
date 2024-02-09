class pnode {
    public int val;
    public pnode left;
    public pnode right;
    public pnode parent;
    public pnode() {
        this.val = 0;
        this.left = null;
        this.right = null;
        this.parent = null;
    }
    public pnode(int val) {
        this.val = val;
        this.left = null;
        this.right = null;
        this.parent = null;
    }
}

class lcathree {
    public pnode lowestCommonAncestor(pnode p, pnode q) {
        pnode pPtr = p;
        pnode qPtr = q;

        while (pPtr != qPtr) {
            pPtr = (pPtr == null) ? q : pPtr.parent;
            qPtr = (qPtr == null) ? p : qPtr.parent;
        }

        return pPtr;
    }

    // Example usage
    public static void main(String[] args) {
        lcathree lcaFinder = new lcathree();

        // Construct the binary tree (omitted for brevity)
        // pnode root = buildTree();

        // Example: Suppose root is the root of the binary tree
        pnode root = new pnode();
        root.val = 3;
        root.left = new pnode();
        root.left.val = 5;
        root.right = new pnode();
        root.right.val = 1;
        root.left.parent = root.right.parent = root;

        root.left.left = new pnode();
        root.left.left.val = 6;
        root.left.right = new pnode();
        root.left.right.val = 2;
        root.left.left.parent = root.left.right.parent = root.left;

        root.left.right.left = new pnode();
        root.left.right.left.val = 7;
        root.left.right.right = new pnode();
        root.left.right.right.val = 4;
        root.left.right.left.parent = root.left.right.right.parent = root.left.right;

        // Define pnodes p and q
        pnode p = root.left;
        pnode q = root.left.right.right;

        // Find the lowest common ancestor
        pnode lca = lcaFinder.lowestCommonAncestor(p, q);

        // Print the value of the lowest common ancestor
        System.out.println("Lowest Common Ancestor of pnodes " + p.val + " and " + q.val + " is: " + lca.val);
    }
}
