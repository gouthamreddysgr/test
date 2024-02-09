import java.util.*;
class courseschedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<Integer>[] G = new ArrayList[numCourses];
        int[] degree = new int[numCourses];
        List<Integer> bfs = new ArrayList();
        for (int i = 0; i < numCourses; ++i) G[i] = new ArrayList<Integer>();
        for (int[] e : prerequisites) {
            G[e[1]].add(e[0]);
            degree[e[0]]++;
        }
        for (int i = 0; i < numCourses; ++i) if (degree[i] == 0) bfs.add(i);
        for (int i = 0; i < bfs.size(); ++i)
            for (int j: G[bfs.get(i)])
                if (--degree[j] == 0) bfs.add(j);
        return bfs.size() == numCourses;
    }
    public static void main(String[] args) {
        courseschedule c = new courseschedule();
        boolean r = c.canFinish(3, new int[][]{{2,1},{1,0},{2,0}});
        System.out.println(r);
    }
}