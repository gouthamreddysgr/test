import java.util.*;

class MinPathAbs {
    public List<List<Integer>> minimumEffortPath(int[][] heights) {
        int rows = heights.length, cols = heights[0].length;
        int[][] dist = new int[rows][cols];
        int[][] prevX = new int[rows][cols];
        int[][] prevY = new int[rows][cols];

        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        minHeap.add(new int[]{0, 0, 0});

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) { dist[i][j] = Integer.MAX_VALUE;
            }
        }

        dist[0][0] = 0;

        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        while (!minHeap.isEmpty()) {
            int[] top = minHeap.poll();
            int effort = top[0], x = top[1], y = top[2];

            if (x == rows - 1 && y == cols - 1) {
                List<List<Integer>> path = new ArrayList<>();
                List<Integer> stepsX = new ArrayList<>();
                List<Integer> stepsY = new ArrayList<>();
                while (x != 0 || y != 0) {
                    stepsX.add(x);
                    stepsY.add(y);
                    int tempX = prevX[x][y];
                    int tempY = prevY[x][y];
                    x = tempX;
                    y = tempY;
                }
                stepsX.add(0);
                stepsY.add(0);
                Collections.reverse(stepsX);
                Collections.reverse(stepsY);
                path.add(stepsX);
                path.add(stepsY);
                return path;
            }

            for (int[] dir : directions) {
                int nx = x + dir[0], ny = y + dir[1];
                if (nx >= 0 && nx < rows && ny >= 0 && ny < cols) {
                    int newEffort = Math.max(effort, Math.abs(heights[x][y] - heights[nx][ny]));
                    if (newEffort < dist[nx][ny]) {
                        dist[nx][ny] = newEffort;
                        minHeap.add(new int[]{newEffort, nx, ny});
                        prevX[nx][ny] = x;
                        prevY[nx][ny] = y;
                    }
                }
            }
        }
        return new ArrayList<>(); // Return empty list if no path found
    }

    public static void main(String[] args) {
        MinPathAbs m = new MinPathAbs();
        List<List<Integer>> path = m.minimumEffortPath(new int[][]{{1, 2, 2}, {3, 8, 2}, {5, 3, 5}});
        System.out.println("Minimum Effort Path: " + path);
    }
}
