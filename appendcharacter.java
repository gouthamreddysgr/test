import java.util.*;
class appendcharacter {
    public int appendCharacters(String s, String t){
        int count=t.length();
        for(int i=t.length(); i>0; i--){
            if(s.contains(t.substring(0, i))){
                count = t.length() - i; 
                break;
            }
        }
        return count;
    }
    public static void main(String[] args) {
        appendcharacter a = new appendcharacter();
        int c = a.appendCharacters("coaching", "coding");
        System.out.println(c);
    }

}
