import java.util.*;
class fib {
    public int fi(int n) {
        if(n==0){return 0;}
        if(n==1){return 1;}
        int p1=1, p=0, num=0;
        int temp;
        for(int i=2; i<=n; i++){
            num = p1 + p;
            temp=p1;
            p=p1;
            p1=temp;

        }
        return num;
    }
    public static void main(String[] args) {
        fib f = new fib();
        int nu = f.fi(4);
    }
}