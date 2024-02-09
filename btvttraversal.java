import java.util.*;

import javax.swing.tree.TreeNode;
class btvtnode {
      int val;
      btvtnode left;
      btvtnode right;
      btvtnode() {}
      btvtnode(int val) { this.val = val; }
      btvtnode(int val, btvtnode left, btvtnode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }
class btvttraversal {
    List<List<Integer>> res = new ArrayList<>();
    SortedMap<Integer, List<Integer>> sortedMap = new TreeMap<>();
 public List<List<Integer>> verticalOrder(btvtnode root) {
    List<List<Integer>> res = new ArrayList<>();
    if (root == null) {
        return res;
    }
    
    Map<Integer, ArrayList<Integer>> map = new HashMap<>();
    Queue<btvtnode> q = new LinkedList<>();
    Queue<Integer> cols = new LinkedList<>();

    q.add(root); 
    cols.add(0);

    int min = 0;
    int max = 0;
    
    while (!q.isEmpty()) {
        btvtnode node = q.poll();
        int col = cols.poll();
        
        if (!map.containsKey(col)) {
            map.put(col, new ArrayList<Integer>());
        }
        map.get(col).add(node.val);

        if (node.left != null) {
            q.add(node.left); 
            cols.add(col - 1);
            min = Math.min(min, col - 1);
        }
        
        if (node.right != null) {
            q.add(node.right);
            cols.add(col + 1);
            max = Math.max(max, col + 1);
        }
    }

    for (int i = min; i <= max; i++) {
        res.add(map.get(i));
    }

    return res;
    }
    public static void main(String[] args) {
        btvttraversal b= new btvttraversal();
        btvtnode r = new btvtnode(3);
        r.left = new btvtnode(9);
        r.right = new btvtnode(8);
        r.left.left = new btvtnode(4);
        r.left.right = new btvtnode(0);
        r.left.right.right = new btvtnode(2);
        r.right.left = new btvtnode(1);
        r.right.right = new btvtnode(7);
        r.right.left.left = new btvtnode(5);
        List<List<Integer>> l = b.verticalOrder(r);
        System.out.println(l);
    }
}