class goodleaf {
    int ans = 0, d = 0;
    public int countPairs(TreeNode root, int distance) {
        d = distance;
        dist(root);
        return ans;
    }

    private int[] dist(TreeNode root){
        if (root == null) return new int[]{};
        int[] l = dist(root.left);
        int[] r = dist(root.right);
        int n = l.length, m = r.length;
        for (int i = 0; i < n; i++){
            for (int j = 0; j < m; j++)
                if (l[i] + r[j] <= d)
                    ans++;
        }

        int[] res = new int[Math.max(n + m, 1)];
        int i = 0;
        for (int k : l) res[i++] = k + 1;
        for (int k : r) res[i++] = k + 1;
        if (n + m == 0) res[0] = 1;

        return res;
    }
    public static void main(String[] args) {
        goodleaf g=new goodleaf();
        TreeNode t = new TreeNode(1);
        t.left = new TreeNode(2);
        t.right = new TreeNode(3);
        t.left.left = new TreeNode(4);
        t.left.right = new TreeNode(5);
        t.left.right.left = new TreeNode(8);
        t.right.left = new TreeNode(6);
        t.right.right = new TreeNode(7);
        int c = g.countPairs(t, 30);
        System.out.println(c);
    }
}