public class calculatecompliment {
    public static int findcompliment(int n){
        int bitcount =0;
        int x = n;
        while(n>0){
            bitcount++;
            n=n>>1;
        }
        int num = (int)Math.pow(2, bitcount) - 1;

        return num ^ x;
    }
    public static void main(String[] args) {
        int result = calculatecompliment.findcompliment(8);
        System.out.println(result);
    }
}
