import java.util.*;
class Interval{
    int start;
    int end;
    Interval(int start, int end){
        this.start = start;
        this.end = end;
    }
}
class mergedlist {
    public static List<Interval> mergelist(List<Interval> list){
        if(list.size()<2){
            return list;
        }
        Collections.sort(list, (a,b) -> Integer.compare(a.start, b.start));
        List<Interval> mlist = new LinkedList<Interval>();
        Iterator<Interval> intervalitr = list.iterator();
        Interval interval = intervalitr.next();
        int start = interval.start;
        int end = interval.end;
        while(intervalitr.hasNext()){
            interval = intervalitr.next();
            if(interval.start <= end){
                end = Math.max(interval.end, end);
            }
            else{
                mlist.add(new Interval(start, end));
                start = interval.start;
                end = interval.end;
            }
        }
        mlist.add(new Interval(start, end));
        return mlist;
    }
    public static void main(String[] args) {
        List<Interval> input = new ArrayList<Interval>();
        input.add(new Interval(1, 4));
        input.add(new Interval(2, 5));
        input.add(new Interval(7, 9));
        for(Interval interval: mergedlist.mergelist(input)){
            System.out.print("["+interval.start+", "+interval.end+"] ");
        }
    }
}
