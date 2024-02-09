import java.io.*;
import java.util.*;
import java.lang.*;

public class inversions {

  private static int enhMergeCountInv(int[] arr, int left,
    int right) {

    int countInv = 0;

    if (left < right) {
      int mid = (left + right) / 2;

      countInv += enhMergeCountInv(arr, left, mid);

      countInv += enhMergeCountInv(arr, mid + 1, right);

      countInv += mergeArrayCountInv(arr, left, mid, right);
    }

    return countInv;
  }

  //counting the inversion when merging arrays
  private static int mergeArrayCountInv(int[] arr, int ll,
    int mm, int rr) {
    int[] left = Arrays.copyOfRange(arr, ll, mm + 1);

    int[] right = Arrays.copyOfRange(arr, mm + 1, rr + 1);

    int ii = 0, jj = 0, kk = ll, swaps = 0;

    while (ii < left.length && jj < right.length) {
      if (left[ii] <= right[jj])
        arr[kk++] = left[ii++];
      else {
        arr[kk++] = right[jj++];
        swaps += (mm + 1) - (ll + ii);
      }
    }
    while (ii < left.length)
      arr[kk++] = left[ii++];
    while (jj < right.length)
      arr[kk++] = right[jj++];
    return swaps;
  }

  // Driver code
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter Size of Array:");
    int n = sc.nextInt();
    int arr[] = new int[n];

    System.out.println("Enter Array:");
    for (int x = 0; x < n; x++)
      arr[x] = sc.nextInt();
    System.out.println("\nInversion Count:" +
      enhMergeCountInv(arr, 0, arr.length - 1));
  }
}