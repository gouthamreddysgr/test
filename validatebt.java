import java.util.*;
class validatebt {
    public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
        Set<Integer> reached = new HashSet<>();
        for (int i = 0; i < n; i++) {
            if (leftChild[i] != -1) reached.add(leftChild[i]);
            if (rightChild[i] != -1) reached.add(rightChild[i]);
        }
        if (reached.size() != n - 1) return false;
        
        int root = -1;
        for (int i = 0; i < n; i++) {
            if (!reached.contains(i)) {
                root = i;
                break;
            }
        }
        
        Set<Integer> visited = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        queue.add(root);
        
        while (!queue.isEmpty()) {
            int curr = queue.poll();
            if (visited.contains(curr)) return false;
            visited.add(curr);
            if (leftChild[curr] != -1) queue.add(leftChild[curr]);
            if (rightChild[curr] != -1) queue.add(rightChild[curr]);
        }
        
        return visited.size() == n;
    }
    public static void main(String[] args) {
        validatebt v = new validatebt();
        boolean b = v.validateBinaryTreeNodes(4, new int[]{1,-1,3,-1}, new int[]{2,3,-1,-1});
        System.out.println(b);
    }
}