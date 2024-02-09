import java.util.*;
class permstring {
    public static boolean findstring(String str, String pattern){
        int match = 0, start = 0;
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        for(char ch: pattern.toCharArray()){
            map.put(ch, map.getOrDefault(ch, 0)+1);
        }
        for(int end = 0; end < str.length(); end++){
            char c = str.charAt(end);
            if(map.containsKey(c)){
                map.put(c, map.get(c)-1);
                if(map.get(c)==0){
                    match++;
                }
            }
            if(match == pattern.length()){
                return true;
            }
            if(end>= pattern.length()-1){
                char d = str.charAt(start);
                if(map.containsKey(d)){
                    if(map.get(d) == 0){
                        match--;
                    }
                    map.put(d, map.get(d)+1);
                }
                
            }
        }
        return false;
    }
    public static void main(String[] args) {
        boolean b = permstring.findstring("oidabcf", "abc");
        System.out.println("string found: "+b);
    }
}
