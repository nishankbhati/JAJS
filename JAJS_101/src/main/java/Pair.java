import java.util.Objects;
/*
* Data Structure which works in Similar fashion like pair in STL(C++)
* Here first ~ JOBID and second ~ experience
* */
public class Pair implements Comparable<Pair> {

    int first;
    int second;

    public Pair(int first, int second) {
        this.first = first;
        this.second = second;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pair pair = (Pair) o;
        return first == pair.first &&
                second == pair.second;
    }

    @Override
    public int hashCode() {
        return Objects.hash(first, second);
    }

    @Override
    public String toString() {
        return "Pair{" +
                "first=" + first +
                ", second=" + second +
                '}';
    }

    @Override
    public int compareTo(Pair pair) {
        if (first != pair.first)
            return first - pair.first;
        return second - pair.second;
    }
}
