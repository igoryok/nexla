package overlap;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/*
*
List<List<Event>>

A : [9-10], [10-10:30], [1-2]
B : [8:30-9:30], [11-11:30], [1-2]
Output: [0-8:30], [10:30-11], [11:30-1], [2-24]
if List empty: [0-24]

*/
public class Overlap {

    public List<Event> freeSlots(List<List<Event>> events) {

        Set<Event> set = new TreeSet<>();
        for (List<Event> list : events) {
            set.addAll(list);
        }
        List<Event> results = new ArrayList<>();

        double start = 0.0;

        for (Event element : set) {
            if (element.getStart() <= start) {
                if (element.getEnd() >= start) {
                    start = element.getEnd();
                }
            } else {
                results.add(new Event(start, element.getStart()));
                start = element.getEnd();
            }
        }

        if(start < 24) {
            results.add(new Event(start, 24.0));
        }
        return results;
    }
}
