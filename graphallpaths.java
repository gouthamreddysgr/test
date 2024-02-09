import java.util.*;
class graphallpaths {
    // DFS
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> paths = new ArrayList<>();
        if (graph == null || graph.length == 0) {
            return paths;
        }

        dfs(graph, 0, new ArrayList<>(), paths);
        return paths;
    }

    void dfs(int[][] graph, int node, List<Integer> path, List<List<Integer>> paths) {
        path.add(node);
        if (node == graph.length - 1) {
            paths.add(new ArrayList<>(path));
            return;
        }
        int[] nextNodes = graph[node];
        for (int nextNode: nextNodes) {
            dfs(graph, nextNode, path, paths);
            path.remove(path.size() - 1);
        }
    }
    public static void main(String[] args) {
        int[][] e = {{0,1},{1,2},{2,0}};
        graphallpaths g = new graphallpaths();
        List<List<Integer>> p = g.allPathsSourceTarget(e);
        //System.out.println(g.allPathsSourceTarget(e));
    }
}