package overlap;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class OverlapTest {

    /**
     * List empty:
     * Output: [0-24]
     */
    @Test
    public void freeSlotsEmptyTest() {
        List<List<Event>> input = new ArrayList<>();
        Overlap o = new Overlap();
        List<Event> result = o.freeSlots(input);

        assertEquals(1, result.size());
        assertEquals(new Event(0.00, 24.00) , result.get(0));
    }

    /**
     * A : [9-10], [10-10:30], [1-2]
     * B : [8:30-9:30], [11-11:30], [1-2]
     * Output: [0-8:30], [10:30-11], [11:30-1], [2-24]
     */
    @Test
    public void freeSlotsTest() {
        List<List<Event>> input = new ArrayList<>();
        List<Event> i1 = Arrays.asList(new Event(9.00, 10.00),
                new Event(10.00, 10.30),
                new Event(13.00, 14.00));
        List<Event> i2 = Arrays.asList(new Event(8.30, 9.30),
                new Event(11.00, 11.30),
                new Event(13.00, 14.00));

        input.add(i1);
        input.add(i2);

        Overlap o = new Overlap();
        List<Event> result = o.freeSlots(input);

        assertEquals(4, result.size());
        assertEquals(new Event(0.00, 8.30) , result.get(0));
        assertEquals(new Event(10.30, 11.00) , result.get(1));
        assertEquals(new Event(11.30, 13.00) , result.get(2));
        assertEquals(new Event(14.00, 24.00) , result.get(3));
    }
}
