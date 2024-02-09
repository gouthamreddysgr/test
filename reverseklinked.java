class listnode{
    int value=0;
    listnode next;
    listnode(int value){
        this.value=value;
    }
}
public class reverseklinked {
    public static listnode findreverse(listnode head, int p){
        listnode current = head;
        listnode previous = null;
        int listsize = 0;
        while(current!=null){
            listsize++;
            previous = current;
            current = current.next;
        }
        previous.next = head;
        current = head;
        p = p%listsize;
        int skiplength = listsize - p;
        for(int i = 0; i<skiplength-1; i++){
            current = current.next;
        }
        head = current.next;
        current.next = null;
        return head;
    }
    public static void main(String[] args) {
        listnode head = new listnode(1);
        head.next = new listnode(2);
        head.next.next = new listnode(3);
        head.next.next.next = new listnode(4);
        head.next.next.next.next =new listnode(5);
        //head.next.next.next.next.next = new listnode(6);
        listnode res = reverseklinked.findreverse(head, 2); 
        while(res!=null){
            System.out.print(res.value+" ");
            res = res.next;
        }
    }
}
