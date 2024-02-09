import java.util.*;
class listnode{
    int value;
    listnode next;
    listnode(int value){
        this.value = value;
    }
}
public class mergeksortedlists {
    public static listnode mergelist(listnode[] lists){
        PriorityQueue<listnode> minheap = new PriorityQueue<>((n1, n2) -> n1.value - n2.value);
        for(listnode root: lists){
            if(root!=null){
                minheap.add(root);
            }
        }
        listnode resultheas = null, resulttail = null;
        while(!minheap.isEmpty()){
            listnode node = minheap.poll();
            if(resultheas == null){
                resultheas = resulttail = node;
            }
            else{
                resulttail.next = node;
                resulttail = resulttail.next;
            }
            if(node.next!=null){
                minheap.add(node.next);
            }
        }
        return resultheas;
    }
    public static void main(String[] args) {
        listnode l1 = new listnode(2);
        l1.next = new listnode(6);
        l1.next.next = new listnode(8);
        listnode l2 = new listnode(3);
        l2.next = new listnode(6);
        l2.next.next = new listnode(7);
        listnode l3 = new listnode(1);
        l3.next = new listnode(3);
        l3.next.next = new listnode(4);
        listnode result =mergeksortedlists.mergelist(new listnode[]{l1, l2, l3});
        while(result!=null){
            System.out.print(result.value+" ");
            result = result.next;
        }
        System.out.println();
    }
    
}
