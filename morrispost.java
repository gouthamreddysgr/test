import java.util.*;

class treenode {
    treenode left, right;
    int val;
    treenode(int val){
        this.val = val;
        this.left = null;
        this.right = null;
    }
    
}
class morrispost{
    treenode root;
    public LinkedList<Integer> posttraversal(treenode root){
        LinkedList<Integer> lis = new LinkedList<>();
        if(root==null)
           return lis;
        treenode cur = root, prev;
        while(cur != null){
            if(cur.right == null){
                lis.addFirst(cur.val);
                System.out.print(cur.val);
                cur = cur.left;
            }
            else{
                prev = cur.right;
                while(prev.left != null && prev.left != cur){
                    prev = prev.left;
                }
                if(prev.left == cur){
                    prev.left = null;
                    //lis.add(cur.val);
                    cur = cur.left;
                }
                else{
                    prev.left = cur;
                    lis.addFirst(cur.val);
                    System.out.print(cur.val);
                    cur = cur.right;
                }
            }
        }
        
        return lis;
    }
    public static void main(String[] args) {
        morrispost tree = new morrispost(); 
		tree.root = new treenode(4); 
		tree.root.left = new treenode(2); 
		tree.root.right = new treenode(5); 
		tree.root.left.left = new treenode(1); 
		tree.root.left.right = new treenode(3); 

		LinkedList<Integer> list = tree.posttraversal(tree.root); 
        System.out.println(list);
    }
}
