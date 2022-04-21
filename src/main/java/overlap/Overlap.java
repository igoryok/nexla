package overlap;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Overlap {

    public List<Event> freeSlots(List<List<Event>> events) {
        List<Event> results = new ArrayList<>();
        if(events == null) {
            return results;
        }

        Set<Event> set = new TreeSet<>();
        for (List<Event> list : events) {
            set.addAll(list);
        }

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

        if (start < 24) {
            results.add(new Event(start, 24.0));
        }
        return results;
    }
}
