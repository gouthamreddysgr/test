class infectbt {
    private int ans;

    public int amountOfTime(TreeNode root, int start) {
      dfs(root, start);
      return ans;
    }
  
    public int dfs(TreeNode root, int start) {
      if (root == null) return 0;
  
      int leftDepth = dfs(root.left, start);
      int rightDepth = dfs(root.right, start);
  
      if (root.val == start) {
        ans = Math.max(leftDepth, rightDepth);
        return -1;
      } else if (leftDepth >= 0 && rightDepth >= 0) {
        return Math.max(leftDepth, rightDepth) + 1;
      } else {
        ans = Math.max(ans, Math.abs(leftDepth - rightDepth));
        return Math.min(leftDepth, rightDepth) - 1;
      }
    }
    public static void main(String[] args) {
        infectbt i = new infectbt();
        TreeNode t = new TreeNode(1);
        t.left = new TreeNode(5);
        t.right = new TreeNode(3);
        t.left.right = new TreeNode(4);
        t.left.right.left = new TreeNode(9);
        t.left.right.right = new TreeNode(2);
        t.right.left = new TreeNode(10);
        t.right.right = new TreeNode(6);
        int num = i.amountOfTime(t, 4);
        System.out.println(num);
    }
}