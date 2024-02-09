class nodup {
 
    public static int findnodup(int[] arr) {
      int nextNonDuplicate = 1; // index of the next non-duplicate element
      for (int i = 1; i < arr.length; i++) {
        if (arr[nextNonDuplicate - 1] != arr[i]) {
          arr[nextNonDuplicate] = arr[i];
          nextNonDuplicate++;
        }
      }
      for(int i=0; i<nextNonDuplicate;i++){
        System.out.print(arr[i]+" ");
      }
   
      return nextNonDuplicate;
    }

   
    public static void main(String[] args) {
        int len = nodup.findnodup(new int[]{2,3,6,6,9});
        System.out.println("Length is: "+len);
    }
    
}
