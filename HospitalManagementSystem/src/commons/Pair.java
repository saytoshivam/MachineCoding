package commons;

public class Pair<S,T> {
    private final S first;
    private final T second;

    public S getFirst() {
        return first;
    }

    public T getSecond() {
        return second;
    }

    public Pair(S first, T second) {
        this.first = first;
        this.second = second;
    }
}
