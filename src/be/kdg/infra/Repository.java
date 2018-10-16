package be.kdg.infra;

import java.io.Serializable;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

/**
 * Created by jan on 3/12/2016.
 */
public interface Repository<V > {

    Collection<V> entities();

    boolean put(V value);

    void update(V value);

    Collection<V> findWhere(Predicate<V> predicate);

    List<V> findWhere(Predicate<V> predicate, Comparator<V> sorter);

    /**
     * @param predicate where condition
     * @return found object or null. This REALLY should return an Optional, but we do not want to
     * confuse users that do not know Optional
     */
    V findOneWhere(Predicate<V> predicate);

    V get(V entity);
}
