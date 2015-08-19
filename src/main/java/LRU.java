import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by prince_shah on 8/19/15.
 * <p>
 * LRU is a type of cache which evits least recently used item.
 * We are using LinkedHashMap as it maintains order of inset internally
 * </p>
 *
 */
public class LRU<K, V> extends LinkedHashMap<K, V> {

    private static final long serialVersionUID = 2677398431717512300L;
    private int size;
    private volatile static LRU instance;

    /**
     *
     * @param size of cache
     */
    private LRU(int size) {
        super(size, 0.75F, true);
        this.size = size;
    }

    /**
     * Singleton class to get handle to LRU instance
     *
     * @param size
     * @param <K>
     * @param <V>
     * @return
     */
    public static <K,V> LRU<K, V> getInstance(int size) {
        if(instance == null) {
            instance = new LRU<K,V>(size);
        }
        return instance;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<K,V> eldest) {
        return size() > size;
    }
}