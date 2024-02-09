import java.util.*;

public class topkfrequent {
    public static List<Integer> findkfrequent(int[] nums, int k){
        Map<Integer, Integer> map = new HashMap<>();
        for(int num: nums){
            map.put(num, map.getOrDefault(num, 0)+1);
        }

        PriorityQueue<Map.Entry<Integer, Integer>> queue = new PriorityQueue<Map.Entry<Integer, Integer>>((e1, e2) -> e1.getValue() - e2.getValue());
        for(Map.Entry<Integer, Integer> entry: map.entrySet()){
            queue.add(entry);
            if(queue.size()>k){
                queue.poll();
            }
        }
        List<Integer> topknums = new ArrayList<>(k);
        while(!queue.isEmpty()){
            topknums.add(queue.poll().getKey());
        }
        return topknums;
    }
    public static void main(String[] args) {
        List<Integer> result = topkfrequent.findkfrequent(new int[]{1, 3, 5, 12, 11, 12, 11}, 2);
        System.out.println(result);
    }
}
