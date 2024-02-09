import java.util.*;
class trypract {
    private static final int[][] offset = {{-1,0},{0,-1},{1,0},{0,1}};
    public int numIslands(char[][] grid){
        int[][] visited = new int[grid.length][grid[0].length];
        int num=0;
        //visited[0][0] = 1;
        for(int i=0; i<grid.length; i++){
            for(int j=0; j< grid[0].length; j++){
                if(visited[i][j]==0 && grid[i][j]=='1'){
                    num++;
                    visit(grid, visited, i, j);
                }
            }
        }
        return num;
    }
    public void visit(char[][] grid, int[][] visited, int i, int j){
        if(i<0 || j<0 || i>grid.length-1 || j>grid[0].length-1 || grid[i][j]=='0' || visited[i][j]==1){
            return;
        }
        visited[i][j]=1;
        for(int[] a: offset){
            int x=a[0]+i;
            int y=a[1]+j;
            visit(grid, visited, x, y);
        }
    }
    public static void main(String[] args) {
        trypract t = new trypract();
        int num = t.numIslands(new char[][]{{'1','1'}});
        //int num = t.numIslands(new char[][]{{'1','1','0','0','0'},{'1','1','0','0','0'},{'0','0','1','0','0'},{'0','0','0','1','1'}});
        System.out.println(num);
    }
}
