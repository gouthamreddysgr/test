import java.util.*;
class minuniq{
    public int partitionstring(String s){
        int[] lastSeen = new int[26];
        Arrays.fill(lastSeen, -1);
        int count = 1, substringStart = 0;

        for (int i = 0; i < s.length(); i++) {
            if (lastSeen[s.charAt(i) - 'a'] >= substringStart) {
                count++;
                substringStart = i;
            }
            lastSeen[s.charAt(i) - 'a'] = i;
        }

        return count;
    }
    public static void main(String[] args) {
        minuniq m = new minuniq();
        int a = m.partitionstring("abacaba");
        System.out.println(a);
    }
}