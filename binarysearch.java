import java.util.*;
class binarysearch {
    public int search(int[] nums, int target) {
        // Set the left and right boundaries
        int left = 0, right = nums.length;
        
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] >= target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        
        if (left > 0 ) {
            return nums[left-1];
        } else {
            return -1;
        } 
    }
    public int searchL(int[] nums, int target) {
        // Set the left and right boundaries
        int left = 0, right = nums.length;
        
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (target <= nums[mid]) {
                right = mid ;
            } else {
                left = mid+1;
            }
        }
        
        if (left < nums.length ) {
            return left;
        } else {
            return -1;
        } 
    }
    public static void main(String[] args) {
        binarysearch b = new binarysearch();
        int n = b.search(new int[]{1, 2, 3, 5, 5, 5,9,18}, 7);
        System.out.println(n);
        int l = b.searchL(new int[]{1, 3, 3, 5, 5, 7,9,18}, 2);
        System.out.println(n);
        System.out.println(l);
    }
}