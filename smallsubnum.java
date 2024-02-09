class smallsubnum {
    public static int findnum(int sum, int[] arr ){
        int wstart = 0;
        int totalsum = 0;
        int length = Integer.MAX_VALUE;
        for(int start=0; start<arr.length; start++){
            totalsum += arr[start];
            while(totalsum >= sum){
                /*if(totalsum == sum){
                    length = Math.min(length, start-wstart+1);
                }*/
                length = Math.min(length, start-wstart+1);
                totalsum = totalsum - arr[wstart];
                wstart++;
            }
        }
        return length == Integer.MAX_VALUE? 0 : length;
    }
    public static void main(String[] args) {
        int num = smallsubnum.findnum(4, new int[]{2,1,5,2,3,2});
        System.out.println(("The number is: "+num));
    }
    
}
