import java.util.*;

public class MySearch<T> {

    protected int count;
    protected Set<T> marked;
    protected Map<T, T> edgeTo;
    protected final T source;

    public MySearch(T source) {
        this.source = source;
        marked = new HashSet<>();
        edgeTo = new HashMap<>();
    }

    public boolean hasPathTo(T v) {
        return marked.contains(v);
    }

    public Iterable<T> pathTo(T v) {
        if (!hasPathTo(v)) return null;
        LinkedList<T> ls = new LinkedList<>();
        for (T i = v; i != source; i = edgeTo.get(i)) {
            ls.push(i);
        }
        ls.push(source);

        return ls;
    }

    public int getCount() {
        return count;
    }
}
