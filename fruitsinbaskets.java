import java.util.HashMap;
class fruitsinbaskets {
    public static int numfruits(int num, char[] arr){
        int start=0;
        int len= Integer.MIN_VALUE;
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        char c,d;
        for(int end = 0; end< arr.length; end++){
            c = arr[end];
            map.put(c, map.getOrDefault(c, 0)+1);
            while(map.size() > num){
                d= arr[start];
                map.put(d, map.get(d)-1);
                if(map.get(d) == 0){
                    map.remove(d);
                }
                start++;
            }
            len = Math.max(len, end-start+1);
        }
        return len;
    }
    public static void main(String[] args) {
        int num = fruitsinbaskets.numfruits(2, new char[]{'A', 'B', 'C', 'A', 'C'});
        System.out.println("The number is : "+num);
    }
    
}
