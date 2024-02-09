import java.util.*;
class sumtoleaf {
    ArrayList<Integer> nums = new ArrayList<>();
    public int sumNumbers(TreeNode root) {
        StringBuilder s = new StringBuilder();
        int sum =0 ;
        check(root, s.append(String.valueOf(root.val)));
        for(int num: nums){
            sum = sum+num;
        }
        return sum;
        
    }
    public void check(TreeNode root, StringBuilder s){
        if(root==null){return;}
        if(root.left==null&&root.right==null){
            nums.add(Integer.parseInt(s.toString()));
            return;
        }
        if(root.left!=null){
            StringBuilder ss = new StringBuilder(s);
            ss.append(String.valueOf(root.left.val));
            check(root.left, ss);
        }
        if(root.right!=null){
            StringBuilder ss = new StringBuilder(s);
            ss.append(String.valueOf(root.right.val));
            check(root.right, ss);
        }
    }
    public static void main(String[] args) {
        TreeNode r= new TreeNode(1);
        r.left= new TreeNode(2);
        r.right = new TreeNode(3);
        r.left.left = new TreeNode(4);
        r.left.right = new TreeNode(5);
        sumtoleaf s = new sumtoleaf();
        System.out.println(s.sumNumbers(r));
    }
}