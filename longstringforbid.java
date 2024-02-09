import java.util.*;
class longstringforbid {
    public int longestValidSubstring(String word, List<String> forbidden){
        Set<String> set = new HashSet<>(forbidden);
        List<String> list = new ArrayList<>();
        int maxForbid=0, end = word.length(), maxLength =0;
        for(String s: forbidden){
            maxForbid = Math.max(s.length(), maxForbid);
        }
        for(int i = end-1; i>=0; i--){
            for(int j=i+1; j<=end &&j-i<=maxForbid ; j++){
                if(set.contains(word.substring(i, j))){
                    end=j-1;
                    break;
                }
            }
            String r = word.substring(i, end);
            if(!r.isEmpty()){
                list.add(word.substring(i, end));
            }
            maxLength = Math.max(end-i, maxLength);
        }
        for(String s: list){System.out.println(s);}
        return maxLength;
    }
    public static void main(String[] args) {
        longstringforbid l = new longstringforbid();
        int num = l.longestValidSubstring("leetcode", new ArrayList<>(Arrays.asList("de","le","e")));
        System.out.println(num);
    }
}
