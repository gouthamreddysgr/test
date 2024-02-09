import java.util.*;
class reorgstring {
    public String reorganizeString(String s) {
        if (s == null || s.length() <= 1) {
            return s;
        }

        // Count character frequencies
        Map<Character, Integer> charFreq = new HashMap<>();
        for (char c : s.toCharArray()) {
            charFreq.put(c, charFreq.getOrDefault(c, 0) + 1);
        }

        // Sort characters by frequency
        PriorityQueue<Character> pq = new PriorityQueue<>((a, b) -> charFreq.get(b) - charFreq.get(a));
        pq.addAll(charFreq.keySet());

        // Create result string
        StringBuilder result = new StringBuilder();
        while (!pq.isEmpty()) {
            char current = pq.poll();
            if (result.length() == 0 || result.charAt(result.length() - 1) != current) {
                result.append(current);
                charFreq.put(current, charFreq.get(current) - 1);
                if (charFreq.get(current) > 0) {
                    pq.offer(current);
                }
            } else {
                
                if (pq.isEmpty()) {
                    return "";
                }
                char next = pq.poll();
                result.append(next);
                charFreq.put(next, charFreq.get(next) - 1);
                if (charFreq.get(next) > 0) {
                    pq.offer(next);
                }
                pq.offer(current);
            }
        }
        return result.toString();
    }
    public static void main(String[] args) {
        reorgstring r = new reorgstring();
        String s = r.reorganizeString("bbacb");
    }
}