import java.util.*;
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
 
class inorder{
    List<Integer> list = new ArrayList<>();
    public List<Integer> preorderTraversal(TreeNode root) {
        
        if(root==null){
            //System.out.println("");
            return null;
        }
        else{
        //list.add(root.val);
        //System.out.print(root.val);
        preorderTraversal(root.left);
        //list.add(root.val);
        //System.out.print(root.val);
        preorderTraversal(root.right);
        list.add(root.val);
        //System.out.print(root.val);
        //return list;
        
    }
    return list;    
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(8);
        root.right = new TreeNode(3);
        root.right.right = new TreeNode(6);
        root.right.right.left = new TreeNode(9);
        inorder i = new inorder();
        List<Integer> list = i.preorderTraversal(root);
        System.out.println(list);
    }
}

