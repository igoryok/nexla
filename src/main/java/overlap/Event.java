package overlap;

import java.util.Objects;

public class Event implements Comparable<Event> {

    private Double start;
    private Double end;

    public Event(Double start, Double end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Event event = (Event) o;
        return start.equals(event.start) && end.equals(event.end);
    }

    @Override
    public int hashCode() {
        return Objects.hash(start, end);
    }

    public Double getStart() {
        return start;
    }

    public void setStart(Double start) {
        this.start = start;
    }

    public Double getEnd() {
        return end;
    }

    public void setEnd(Double end) {
        this.end = end;
    }

    @Override
    public int compareTo(Event o) {
        int cmp = this.start.compareTo(o.getStart());
        if (cmp != 0) {
            return cmp;
        }
        cmp = this.end.compareTo(o.getEnd());
        return cmp;
    }

    @Override
    public String toString() {
        return "Event{" +
                "start=" + start +
                ", end=" + end +
                '}';
    }
}
