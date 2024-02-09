class ksmallbt {
    int num=0, count=0;
    public int kthSmallest(TreeNode root, int k) {
        search(root, k);
        return num;
    }
    public void search(TreeNode root, int k){
        if(root==null){return;}
        search(root.left, k);
        count++;
        if(k==count){num=root.val;}
        search(root.right, k);

    }
    public static void main(String[] args) {
        ksmallbt kt = new ksmallbt();
        TreeNode t = new TreeNode(3);
        t.left = new TreeNode(1);
        t.right = new TreeNode(4);
        t.left.right = new TreeNode(2);
        int num = kt.kthSmallest(t, 1);
    }
}