import java.util.*;
class candlebwplates {
    private int lowerBound ;
    private int upperBound ;
    
    private void binarySearch(ArrayList<Integer> arr, int target) {
        int low = 0 ;
        int high = arr.size()-1 ;
        
        while (low <= high) {
            int mid = low + (high-low)/2 ;
            
            if (arr.get(mid) == target) {
                upperBound = lowerBound = mid ;
                return ;
            }
            else if (arr.get(mid) < target)
                low = mid+1 ;
            else high = mid-1 ;
        }
        lowerBound = low ;
        upperBound = high ;
    }
    public int[] platesBetweenCandles(String s, int[][] queries) {
        int n = s.length() ;
        int m = queries.length ;
        ArrayList<Integer> barIndex = new ArrayList<>() ;
        int[] result = new int [m] ;
        
        for (int i = 0; i < n; i++)
            if (s.charAt(i) == '|')
                barIndex.add(i) ;
        
        for (int i = 0; i < m; i++) {
            binarySearch(barIndex, queries[i][0]) ;
            int j = lowerBound ;
            
            binarySearch(barIndex, queries[i][1]) ;
            int k = upperBound ;
            
            if (j >= k) result[i] = 0 ;
            else result[i] = barIndex.get(k)-barIndex.get(j) -1 - (k-j-1) ;
        }
        return result ;
    }
    public static void main(String[] args) {
        candlebwplates c = new candlebwplates();
        int[] num = c.platesBetweenCandles("***|**|*****|**||**|*", new int[][]{{1,17}, {4,5}});
        for(int n: num){
            System.out.print(n+" ");
        }
    }
}
