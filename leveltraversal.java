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
class leveltraversal{

    public List<List<Integer>> traverse(Treenode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (root == null)
          return result;
     
        Queue<Treenode> queue = new LinkedList<>();
        queue.offer(root);
        //boolean leftToRight = true;
        while (!queue.isEmpty()) {
          int levelSize = queue.size();
          List<Integer> currentLevel = new ArrayList<>(levelSize);
          for (int i = 0; i < levelSize; i++) {
            Treenode currentNode = queue.poll();
     
            // add the node to the current level based on the traverse direction
            //if (leftToRight)
            currentLevel.add(currentNode.val);
            //else
              //currentLevel.add(0, currentNode.val);
     
            // insert the children of current node in the queue
            if (currentNode.left != null)
              queue.offer(currentNode.left);
            if (currentNode.right != null)
              queue.offer(currentNode.right);
          }
          result.add(0,currentLevel);
          // reverse the traversal direction
          //leftToRight = !leftToRight;
        }
     
        return result;
      }
    public static void main(String[] args) {
        Treenode root = new Treenode(1);
        root.left = new Treenode(2);
        root.right = new Treenode(3);
        root.left.left = new Treenode(4);
        root.left.right = new Treenode(5);
        root.right.left = new Treenode(6);
        root.right.right = new Treenode(7);
        leveltraversal lev = new leveltraversal();
        List<List<Integer>> list = lev.traverse(root);
        System.out.println(list);

    }
}
    /*List<List<Integer>> levels = new ArrayList<List<Integer>>();

    public void helper(Treenode node, int level) {
        // start the current level
        if (levels.size() == level)
            levels.add(new ArrayList<Integer>());

         // fulfil the current level
         levels.get(level).add(node.val);

         // process child nodes for the next level
         if (node.left != null)
            helper(node.left, level + 1);
         if (node.right != null)
            helper(node.right, level + 1);
    }
    public List<List<Integer>> findtraversal(Treenode root){
        if (root == null) 
          return levels;
        helper(root, 0);
          return levels;
    }*/