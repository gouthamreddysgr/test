import java.util.*;
class stringinc {
    public boolean canMakeSubsequence(String str1, String str2) {
        int j = 0, n = str1.length(), m = str2.length();
        for (int i = 0; i < n && j < m; ++i) {
            int a = str1.charAt(i), b = str2.charAt(j);
            if (a == b || a + 1 == b || a - 25 == b)
                ++j;
        }
        return j == m;
    }
    public static void main(String[] args) {
        stringinc s = new stringinc();
        boolean b = s.canMakeSubsequence("eao", "ofa");
        System.out.println(b);
    }
}