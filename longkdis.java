import java.util.HashMap;
class longkdis {
    public static int kdis(int num, String str){
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        int start=0;
        int length = Integer.MIN_VALUE;
        char c;
        char d;
        for(int end=0; end < str.length(); end++){
            c = str.charAt(end);
            map.put(c, map.get(c) == null ?1: map.get(c)+1);
            while(map.size() >num){
                d = str.charAt(start);
                map.put(d, map.get(d)-1);
                if(map.get(d) == 0){
                    map.remove(d);
                }
                start++;

            }
            length = Math.max(length, end-start+1);
        }
        return length;
    }
    public static void main(String[] args) {
        int num = longkdis.kdis(2, "araaci");
        System.out.println("The number is: "+num);
    }
    
}
