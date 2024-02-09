import java.util.*;
class countkfree {
    public long countTheNumOfKFreeSubsets(int[] nums, int k) {
        Arrays.sort(nums); 
        Map<Integer, Integer> size = new HashMap(); 
        int m = 0; 
        for (int x : nums) {
            size.put(x, 1 + size.getOrDefault(x-k, 0)); 
            size.remove(x-k); 
            m = Math.max(m, size.get(x)); 
        }
        long[] fib = new long[m+2]; 
        fib[0] = fib[1] = 1; 
        for (int i = 2; i < m+2; ++i) fib[i] = fib[i-2] + fib[i-1]; 
        long ans = 1; 
        for (int v : size.values()) 
            ans *= fib[v+1]; 
        return ans; 
    }
    public static void main(String[] args) {
        countkfree c = new countkfree();
        long r = c.countTheNumOfKFreeSubsets(new int[]{5,4,6}, 1);
        System.out.println(r);
    }
}