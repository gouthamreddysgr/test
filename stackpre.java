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
class stackpre{
    treenode root;
    public List<Integer> posttraversal(treenode root){
        List<Integer> lis = new ArrayList<>();
        if(root==null)
           return lis;
        Stack<treenode> stack = new Stack<>();
        stack.add(root);
        while(!stack.isEmpty()){
            treenode element = stack.peek();
            stack.pop();
            if(element != null){
                lis.add(element.val);
                stack.add(element.right);
                stack.add( element.left);
            }
        }
        
        return lis;
    }
    public static void main(String[] args) {
        stackpre tree = new stackpre(); 
		tree.root = new treenode(4); 
		tree.root.left = new treenode(2); 
		tree.root.right = new treenode(5); 
		tree.root.left.left = new treenode(1); 
		tree.root.left.right = new treenode(3); 

		List<Integer> list = tree.posttraversal(tree.root); 
        System.out.println(list);
    }
}
