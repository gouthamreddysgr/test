import java.util.*;
class arraytobt {
  public TreeNode sortedArrayToBST(int[] nums) {
    return helper(nums, 0, nums.length-1);
  }

  private TreeNode helper(int[] nums, int l, int r){
    if (l>r) return null;
    
    int mid = (l+r)/2;
    TreeNode root = new TreeNode(nums[mid]);
    root.left = helper(nums, l, mid-1);
    root.right = helper(nums, mid+1, r);
    return root;
  }
  public static void main(String[] args) {
    arraytobt a = new arraytobt();
    TreeNode t = a.sortedArrayToBST(new int[]{1,2,3,4,5,6});
    System.out.println();
  }
}