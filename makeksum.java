import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class makeksum {
    public long makeSubKSumEqual(int[] arr, int k) {
    long res = 0;
    for (int i = 0; i < k; ++i) {
        List<Integer> cycle = new ArrayList<>();
        for (int j = i; arr[j] != 0; j = (j + k) % arr.length) {
            cycle.add(arr[j]);
            arr[j] = 0;
        }
        Collections.sort(cycle);
        for (int n : cycle)
            res += Math.abs(n - cycle.get(cycle.size() / 2));
    }
    return res;
}
public static void main(String[] args) {
    makeksum m = new makeksum();
    long num = m.makeSubKSumEqual(new int[]{1,4,1,3}, 2);
    System.out.println(num);
}
}
