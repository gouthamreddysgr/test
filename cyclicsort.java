class cyclicsort {
    public static int findsort(int[] arr){
        for(int i = 0; i< arr.length; i++){
            if(arr[i] < arr.length && arr[i]!=arr[arr[i]]){
                swap(arr, i, arr[i]);
                i--;
            }

        }
        for(int i=0; i<arr.length; i++){
            if(arr[i]!=i){
                return i;
            }
        }
        return arr.length;
    }
    private static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    public static void main(String[] args) {
        int result = cyclicsort.findsort(new int[]{4, 0, 3, 1});
        System.out.println(result);
        /*for(int i=0; i<result.length; i++){
            System.out.print(result[i]+" ");
        }*/
    }
}
