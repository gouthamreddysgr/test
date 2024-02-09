import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class treenode{
    int val;
    treenode left;
    treenode right;
    treenode(int val){
        this.val = val;
    }
}
public class reversebfs {
    public static List<List<Integer>> findreverse(treenode root){
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        if(root == null){
            return list;
        }
        Queue<treenode> q = new LinkedList<>();
        q.offer(root);
        boolean l2r = true;
        while(!q.isEmpty()){
            int levelsize = q.size();
            List<Integer> currentlevel = new ArrayList<>(levelsize);
            for(int i = 0; i < levelsize; i++){
                treenode currentnode = q.poll();
                if(l2r){
                    currentlevel.add(currentnode.val);
                }
                else{
                    currentlevel.add(0,currentnode.val);
                }
                //currentlevel.add(currentnode.val);
                if(currentnode.left!=null){
                    q.offer(currentnode.left);
                }
                if(currentnode.right!=null){
                    q.offer(currentnode.right);
                }
            }
            list.add(0,currentlevel);
            l2r = !l2r;
        }
        return list;
    }
    public static void main(String[] args) {
        treenode root = new treenode(12);
        root.left = new treenode(7);
        root.right = new treenode(1);
        root.left.left = new treenode(9);
        root.right.left = new treenode(10);
        root.right.right = new treenode(5);
        List<List<Integer>> result = reversebfs.findreverse(root);
        System.out.println(result);
    }
}
