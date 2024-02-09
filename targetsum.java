import java.util.ArrayList;
import java.util.List;

class targetsum {
    public static List<Integer> targetfind(int[] lis, int target){
        List<Integer> result = new ArrayList<Integer>();
        int len = lis.length;
        int start = 0;
        int end = len - 1;
        for(int star = 0; star < end; star++){
            int endelement = lis[end];
            int startelement = lis[start];
            int sum = startelement+endelement;
            if(sum < target){
                start++;
            }
            else if(sum > target){
                end--;
            }
            else{
                result.add(start);
                result.add(end);
            }
        }
        if(result.isEmpty()){
            result.add(-1);
            result.add(-1);
        }
        return result;
    }
    public static void main(String[] args) {
        List<Integer> num = List.of(1,2,3,4,6);
        List<Integer> print = targetsum.targetfind(new int[]{1,2,3,4,6}, 10);
        System.out.println("The index position is: "+print.toString());
    }
    
}
