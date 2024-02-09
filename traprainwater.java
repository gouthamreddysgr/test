import java.util.*;
class traprainwater {
    public int trap(int[] height) {
        int max=-1;
        int ind=0;
        int loc=height[0];
        int num=0;
        for(int i=0; i<height.length; i++){if(height[i]>max){ind=i;}max=Math.max(max, height[i]);}
        for(int i=0; i<ind; i++){
            loc = Math.max(loc, height[i]);
            num += Math.min(loc, max)-height[i];
        }
        loc = height[height.length-1];
        for(int i=height.length-1; i>ind; i--){
            loc = Math.max(loc, height[i]);
            num += Math.min(loc, max)-height[i];
        }
        return num;
    }
    public static void main(String[] args) {
        traprainwater t = new traprainwater();
        int n = t.trap(new int[]{0,1,0,2,1,0,1,3,2,1,2,1});
        System.out.println(n);
    }
}
