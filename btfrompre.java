import java.util.*;
class btfrompre {
    public TreeNode bstFromPreorder(int[] preorder) {
        return bstFromPreorder(preorder, Integer.MAX_VALUE, new int[]{});
    }
    public TreeNode bstFromPreorder(int[] preorder, int bound, int[] i) {
        if(i[0]==preorder.length || preorder[i[0]]>bound ){return null;}
        TreeNode root =new TreeNode(preorder[i[0]++]);
        root.left = bstFromPreorder(preorder, root.val, i);
        root.right = bstFromPreorder(preorder, bound, i);
        return root;
    }
    public static void main(String[] args) {
        btfrompre b = new btfrompre();
        TreeNode t = b.bstFromPreorder(new int[]{8,5,1,7,10,12});
    }
}
