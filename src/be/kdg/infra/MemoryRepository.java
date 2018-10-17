package be.kdg.infra;

import java.io.*;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by jan on 3/12/2016.
 * This memory repository enables you to make a repository for any given classtype with default functionality
 * (entities, get, put, find, findWhere and findOneWhere)
 * ex. private final MemoryRepository<Order> orderRepo = new MemoryRepository<>();
 * Objects in the repo are not automagically updated after manipulating an object in de bussinesslayer.
 * Therefore you are obligated to always persist changes after an update.
 */
public class MemoryRepository<V extends Serializable> implements Repository<V > {

	private Map<Integer, byte[]> data = new HashMap<>();


	@Override
	public Collection<V> entities() {
		return asStream().collect(Collectors.toSet());
	}

	public boolean put(V value) {
		if (value == null) {
			return false;
		}
		return data.put(getKey(value), marshall( value)) != null;
	}

	private byte[] marshall(Serializable entity) {
		try (ByteArrayOutputStream bos = new ByteArrayOutputStream();
		     ObjectOutput out = new ObjectOutputStream(bos)) {
			out.writeObject(entity);
			return bos.toByteArray();
		} catch (IOException e) {
			System.err.println("Error marshalling " + entity + "\n" + e);
			return null;
		}
	}

	private V unmarshall(byte[] marshalled) {
		if (marshalled == null) return null;
		try (ByteArrayInputStream bis = new ByteArrayInputStream(marshalled);
		     ObjectInput in = new ObjectInputStream(bis)) {
			return (V) in.readObject();
		} catch (IOException | ClassNotFoundException e) {
			System.err.println("Error unmarshalling "  + e);
			return null;
		}
	}

	private int getKey(Object entity) {
		return entity.hashCode();
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

	/**
	 * @param predicate (ex. V -> V.getName().equals("Jos"))
	 * @return
	 */
	public Collection<V> findWhere(Predicate<V> predicate) {
		return findStream(predicate).collect(Collectors.toSet());
	}

	private Stream<V> findStream(Predicate<V> predicate) {
		return asStream().filter(predicate);
	}

	private Stream<V> asStream(){
		return data.values().stream().map(v -> unmarshall(v));
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
		return unmarshall(data.get(getKey(entity) ));
	}
}
