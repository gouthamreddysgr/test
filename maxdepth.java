import java.util.*;

class Treenode {
    Treenode left, right;
    int val;
    Treenode(int val){
        this.val = val;
        this.left = null;
        this.right = null;
    }
    
}
class maxdepth {
    /*int size = 0, length =0;
    public void finddepth(Treenode root){
        //int length;
        if(root == null){
            return;
        }
        length++;
        if(root.left!=null){
            finddepth(root.left);
        }
        if(root.right!=null){
            finddepth(root.right);
        }
        if(root.left == null && root.right == null){
            size = Math.max(size, length);
            length = 0;
        }
    }
    public int maxDepth(Treenode root) {
        if(root != null){
            finddepth(root);
        }
        return size;   
    }
        public int maxDepth(Treenode root) {
          if (root == null) {
            return 0;
          } else {
            Queue<Treenode> q = new Queue<Treenode>();
            q.add(root);
            while(!q.isEmpty()){

            }
            int left_height = maxDepth(root.left);
            int right_height = maxDepth(root.right);
            return java.lang.Math.max(left_height, right_height) + 1;
          }
        }*/
        public int maxDepth(Treenode root) {
            LinkedList<Treenode> stack = new LinkedList<>();
            LinkedList<Integer> depths = new LinkedList<>();
            if (root == null) return 0;
        
            stack.add(root);
            depths.add(1);
        
            int depth = 0, current_depth = 0;
            while(!stack.isEmpty()) {
              root = stack.pollLast();
              current_depth = depths.pollLast();
              if (root != null) {
                depth = Math.max(depth, current_depth);
                stack.add(root.left);
                stack.add(root.right);
                depths.add(current_depth + 1);
                depths.add(current_depth + 1);
              }
            }
            return depth;
          }
    public static void main(String[] args) {
        Treenode root = new Treenode(3);
        root.left = new Treenode(9);
        root.right = new Treenode(20);
        //root.left.left = new Treenode(null);
        //root.left.right = new Treenode(null);
        root.right.left = new Treenode(15);
        root.right.right = new Treenode(7);
        maxdepth lev = new maxdepth();
        int l = lev.maxDepth(root);
        System.out.println(l);
    }
}