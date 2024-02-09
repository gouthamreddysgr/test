import java.util.*;
class maxposprod {
    public int getMaxLen2(int[] nums) {
        int len = nums.length, max = 0;
        int[] fneg = new int[len+1]; // the length of longest negative product sub-array 
        int[] fpos = new int[len+1]; // the length of longest positive product sub-array 

        for(int i=1; i<=len; i++){
            if(nums[i-1] > 0){
			// when positive subarray meets a positive number, the length will be increased by one at all case
			// the negative subarray will be increased only if it is not empty. 
                fpos[i] = fpos[i-1] + 1;
                fneg[i] = fneg[i-1] > 0 ? fneg[i-1] + 1 : 0;
            }else if(nums[i-1] < 0){
			// the positive subarray will be increased only if the previous product is negative
			// the negative subarray will be increased only if the previous product is positive
                fpos[i] = fneg[i-1] > 0 ? fneg[i-1] + 1 : 0;
                fneg[i] = fpos[i-1] + 1;
            }
            max = Math.max(fpos[i], max);
        }
        return max;
    }
	public static void main(String[] args) {
        maxposprod m = new maxposprod();
        int n = m.getMaxLen2(new int[]{1, -2, -3, 4});
        System.out.println(n);
    }
}