import java.math.*;
import java.util.Arrays;
class sortmintimejobs {
    public int minimumTime(int[] jobs, int[] workers) {
        Arrays.sort(jobs);
        Arrays.sort(workers);
        int maxDay = 0, n = jobs.length;
        for (int i = 0; i < n; ++i) {
            double sum = (double)(jobs[i]);
            double worker = (double)(workers[i]);
            double quo = Math.ceil((sum)/ worker);
            maxDay = Math.max(maxDay, (int)quo);
        }
        return maxDay;
    }
    public static void main(String[] args) {
        sortmintimejobs s = new sortmintimejobs();
        int p = s.minimumTime(new int[]{1}, new int[]{2});
        System.out.println(p);
    }
}
