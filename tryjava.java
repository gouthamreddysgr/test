import java.util.Arrays;

class samplejav {
    public static int findmax(int a, int[] b){
        int sum = 0;
        int z = 0;
        double[] result = new double[b.length-a + 1];
        int max =0;
        for(int x = 0; x < b.length ; x++){
            sum+=b[x];
            if(x >= a-1){
                max = Math.max(max,sum);
                sum = sum - b[z];
                z++;
            }
        }
        return max;
    }
    public static void main(String[] args) {
        int x = samplejav.findmax(3, new int[] {2, 1, 5, 1, 3, 2});
        System.out.println("Max is: "+x);
    
    }
    
}