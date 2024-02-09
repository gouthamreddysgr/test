import java.util.*;
class coursetwo {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] a = new int[numCourses];
        int z=0, num=0;
        List<Integer> source =new ArrayList<>();
        Map<Integer, List<Integer>> m = new HashMap<>();
        Map<Integer, Integer> inDegree = new HashMap<>();
        if(prerequisites.length==0){
            for(int i=0; i< numCourses; i++){
                a[i] = i;
            }
            return a;
        }
        for(int i=0; i< numCourses; i++){ m.put(i, new ArrayList<>());inDegree.put(i,0);}
        for(int[] p: prerequisites){
            m.get(p[1]).add(p[0]);
            inDegree.put(p[0], inDegree.getOrDefault(p[0], 0)+1);
        }
        for(int i=0; i< numCourses; i++){
            if(inDegree.get(i)==0){
                source.add(i);
            }
        }
        if(source.isEmpty()){return new int []{};}
        while(!source.isEmpty()){
            int size = source.size();
            while(size-->0){
                int n = source.remove(0);
                a[z++] = n;
                num++;
                inDegree.put(n, inDegree.getOrDefault(n,0)-1);
                List<Integer> ld = m.get(n);
                for(int i: ld){
                    inDegree.put(i, inDegree.getOrDefault(i,0)-1);
                }
                
                for(int y=0; y<numCourses; y++){
                    
                    if(inDegree.get(y)==0 && !source.contains(y)){
                        source.add(y);
                    }
                }
            }
        }
        return num==numCourses?a:new int[]{};
    }
    public static void main(String[] args) {
        coursetwo c = new coursetwo();
        int[] r = c.findOrder(3, new int[][]{{0,1},{1,2}});
        for (int course : r) {
            System.out.print(course + " ");
        }
    }
}