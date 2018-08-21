package be.kdg.infra;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by jan on 3/12/2016.
 */
public class MemoryRepository<V> implements Repository<V> {

    private Set<V> data = new HashSet<>();


    @Override
    public Collection<V> entities() {
        return data;
    }

    @Override
    public boolean put(V value) {
        return data.add(value);
    }

    /**
     * Just a wrapper around addContract for update semantics
     *
     * @param entity entity to be updated
     */
    @Override
    public void update(V entity) {
        put(entity);
    }

    public Collection<V> findWhere(Predicate<V> predicate) {
        return findStream(predicate).collect(Collectors.toSet());
    }

    private Stream<V> findStream(Predicate<V> predicate) {
        return data.stream().filter(predicate);
    }

    @Override
    public List<V> findWhere(Predicate<V> predicate, Comparator<V> sorter) {
        Stream<V> result = findStream(predicate);
        if (sorter != null) {
            result = result.sorted(sorter);
        }
        return result.collect(Collectors.toList());
    }

    @Override
    public V findOneWhere(Predicate<V> predicate) {
        return findStream(predicate).findAny
                ().orElse(null);
    }

    /**
     * @param entity entity die we uit de dB willen restoren
     * @return the entity as in the repo or null
     * For efficiency reasons the store would better be implemented as a Map
     */
    @Override
    public V get(V entity) {
        for (V e : data) {
            if (e.equals(entity)) {
                return e;
            }
        }
        return null;
    }
}
