import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class mergeintervals {
    public int[][] merge(int[][] intervals) {
        if (intervals.length <= 1) {
            return intervals;
        }

        // Sort the intervals based on their start times
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        List<int[]> mergedIntervals = new ArrayList<>();
        int[] currentInterval = intervals[0];
        //int[][] result = new int[intervals.length][intervals[0].length];
        for (int i = 1; i < intervals.length; i++) {
            int[] nextInterval = intervals[i];

            // If the current and next intervals overlap, merge them
            if (currentInterval[1] >= nextInterval[0]) {
                currentInterval[1] = Math.max(currentInterval[1], nextInterval[1]);
            } else {
                mergedIntervals.add(currentInterval);
                currentInterval = nextInterval;
            }
        }

        // Add the last interval
        mergedIntervals.add(currentInterval);

        return mergedIntervals.toArray(new int[mergedIntervals.size()][]);
    }

    // Example usage
    public static void main(String[] args) {
        mergeintervals mergeinterval = new mergeintervals();

        int[][] intervals1 = { { 1, 3 }, { 2, 6 }, { 8, 10 }, { 15, 18 } };
        int[][] result1 = mergeinterval.merge(intervals1);
        System.out.println(Arrays.deepToString(result1)); // Output: [[1, 6], [8, 10], [15, 18]]

        int[][] intervals2 = { { 1, 4 }, { 4, 5 } };
        int[][] result2 = mergeinterval.merge(intervals2);
        System.out.println(Arrays.deepToString(result2)); // Output: [[1, 5]]
    }
}
