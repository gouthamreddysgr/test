import java.util.*;
 
class TripletSumToZero {
 
  public static int searchTriplets(int[] arr, int target) {
    Arrays.sort(arr);
    int difference = Integer.MAX_VALUE;
    int dif = Integer.MAX_VALUE;
    List<List<Integer>> triplets = new ArrayList<>();
    for (int i = 0; i < arr.length - 2; i++) {
      if (i > 0 && arr[i] == arr[i - 1]) // skip same element to avoid duplicate triplets
        continue;
      int x = arr[i];
      int tarsum = target - x;
      if(i==0){
        dif = Math.min(searchPair(arr, tarsum, i + 1, triplets, difference, target), dif);
      }
      else{
        dif = Math.min(searchPair(arr, tarsum, i + 1, triplets, difference, target), dif);
      }
    }
 
    return target-dif;
  }
 
  private static int searchPair(int[] arr, int targetSum, int left, List<List<Integer>> triplets, int difference, int tar) {
    int right = arr.length - 1;
    int sum = Integer.MAX_VALUE;
    while (left < right) {
      int currentSum = arr[left] + arr[right];
      if (currentSum == targetSum) { // found the triplet
        triplets.add(List.of(-targetSum, arr[left], arr[right]));
        left++;
        right--;
        while (left < right && arr[left] == arr[left - 1])
          left++; // skip same element to avoid duplicate triplets
        while (left < right && arr[right] == arr[right + 1])
          right--; // skip same element to avoid duplicate triplets
      } else if (targetSum > currentSum)
        left++; // we need a pair with a bigger sum
      else
        right--; // we need a pair with a smaller sum
      if(Math.abs(targetSum - currentSum) < Math.abs(difference)){
        difference = targetSum - currentSum;
        //sum = Math.min(tar-targetSum + currentSum, sum);
        
      }
    }
    return difference;
  }
 
  public static void main(String[] args) {
    System.out.println(TripletSumToZero.searchTriplets(new int[] { -2, 0, 1, 2 }, 2));
    System.out.println(TripletSumToZero.searchTriplets(new int[] { 1, 0, 1, 1}, 100));
  }
}