class listnode{
    int value=0;
    listnode next;
    listnode(int value){
        this.value=value;
    }
}
public class reverselinked {
    public static listnode findreverse(listnode head, int p, int q){
        if(p == q){
            return head;
        }
        listnode current = head;
        
        listnode previous = null;
        listnode nxt = null;
        for(int i=0; i<p-1; i++){
            previous = current;
            current = current.next;
        }
        listnode connectfirst = previous;
        listnode lastsubelement = current;
        for(int i=0; i< q-p+1;i++){
            nxt = current.next;
            current.next = previous;
            previous = current;
            current = nxt;
        }
        if(connectfirst!=null){
            connectfirst.next = previous;
        }
        else{
            head = previous;
        }
        lastsubelement.next = current;
        return head;
    }
    public static void main(String[] args) {
        listnode head = new listnode(1);
        head.next = new listnode(2);
        head.next.next = new listnode(3);
        head.next.next.next = new listnode(4);
        head.next.next.next.next =new listnode(5);
        listnode result = reverselinked.findreverse(head, 1, 3); 
        listnode res = reverselinked.findreverse(result,4, 5);
        while(res!=null){
            System.out.print(res.value+" ");
            res = res.next;
        }
    }
}
