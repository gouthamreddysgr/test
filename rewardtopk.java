import java.util.*;
class rewardtopk {
    public List<Integer> topStudents(String[] positive_feedback, String[] negative_feedback, String[] report, int[] student_id, int k) {
        Set<String> pos = new HashSet<>();
        Set<String> nos = new HashSet<>();
        List<Integer> l = new ArrayList<>();
        Map<Integer, Integer> m = new HashMap<>();
        int[] arr = new int[k];
        int i = 0;
        for(String p: positive_feedback){
            pos.add(p);
        }
        for(String n: negative_feedback){
            nos.add(n);
        }
        for(String s: report){
            String[] words = s.split("\\s+");
            for(String w: words){
                if(pos.contains(w)){
                    m.put(student_id[i], m.getOrDefault(student_id[i], 0)+3);
                }
                else if(nos.contains(w)){
                    m.put(student_id[i], m.getOrDefault(student_id[i], 0)-1);
                }
            }
            
            i++;
        }
        List<Map.Entry<Integer, Integer>> entryList = new ArrayList<>(m.entrySet());
        entryList.sort(Comparator
                .<Map.Entry<Integer, Integer>, Integer>comparing(entry -> entry.getValue(), Comparator.reverseOrder())
                .thenComparing(entry -> entry.getKey()));
        int kk=0;
        for(Map.Entry<Integer, Integer> n: entryList){
            if(kk==k){break;}
            l.add(n.getKey());
            kk++;
        }
        return l;
    }
    public static void main(String[] args) {
        rewardtopk r = new rewardtopk();
        List<Integer> l = r.topStudents(new String[]{"pyuknvau","nc","hwcpe","wn"}, new String[]{"bjzzjcgxv","dibldp","pmlb"}, new String[]{"qws z pmlb xmcugvuos lpnygddx bjzzjcgxv hwcpe pmlb pmlb rocg","hwcpe pyuknvau dibldp bjzzjcgxv bjzzjcgxv hwcpe wn pmlb pyuknvau wodnvd","dibldp dibldp gna dibldp pmlb pyuknvau pyuknvau nc iygs rkhtnjreq","pmlb aas wn hwcpe bjzzjcgxv otird pyuknvau fdl bjzzjcgxv dibldp"}, new int[]{357574114,899543310,676388750,793586311}, 2);
        System.out.println(l);
    }
}