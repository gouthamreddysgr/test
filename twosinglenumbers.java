public class twosinglenumbers {
    public static int[] findnum(int[] arr){
        int num = 0;
        for(int i=0; i<arr.length; i++){
            num = arr[i]^num;
        }
        int rightmostbit = 1;
        int x = rightmostbit & num;
        int y=2;
        while((rightmostbit & num)==0){
            rightmostbit = rightmostbit << 1;
        }
        int num1 =0, num2 =0;
        for(int num3: arr){
            if((num3 & rightmostbit)!=0){
                num1 ^= num3;
            }
            else{
                num2 ^=num3;
            }
        }
        return new int[]{num1, num2};
    }
    public static void main(String[] args) {
        int[] result = twosinglenumbers.findnum(new int[]{2,1,3,2});
        System.out.println(result[0]+", "+result[1]);
    }
}
