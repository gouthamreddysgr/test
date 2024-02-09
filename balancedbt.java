class balcedbt {
    int sum = 1;
    public boolean isBalanced(TreeNode root) {
        if(root==null){return true;}
        isb(root, 0, 0);
        
        return sum==0?false:true;
    }
    public void isb(TreeNode root, int l, int r){
        if(root==null){return;}
        
        if(root.left!=null){
            l++;
            isb(root.left,l,r);}
        if(root.right!=null){
            r++;
            isb(root.right,l,r);}
        //r++;
        if(Math.abs(r-l)>1){sum=0;}

    }
    public static void main(String[] args) {
        balcedbt b = new balcedbt();
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.right = new TreeNode(3);
       
        boolean t = b.isBalanced(root);
        System.out.println(t);
    }
}