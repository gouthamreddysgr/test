import java.util.*;
class palindomefour {
    public boolean palindrome(String s){
        int stringLength = s.length();
        int count=0;
        for(int i=0, j=stringLength-1; i<stringLength; i++,j--){
            if(i==j || i>j){
                break;
            }
            if(s.charAt(i) != s.charAt(j)){
                count++;
            }
            
        }
        return (count>2)? false: true;
    }
    public static void main(String[] args) {
        palindomefour p = new palindomefour();
        boolean b = p.palindrome("zhak");
        System.out.println(b);
    }
}
