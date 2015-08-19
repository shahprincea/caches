import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class LRUTest {

    private LRU<Integer, String> lruCache = null;

    @Before
    public void buildCache() {
        lruCache = LRU.getInstance(2);
        lruCache.put(1,"One");
        lruCache.put(2,"Two");
        lruCache.put(3,"Three");
    }

    @Test
    public void testSize() throws Exception {
        Assert.assertEquals(lruCache.size(), 2);
    }

    @Test
    public void testEntries() {
        Assert.assertTrue(lruCache.get(2).equals("Two"));
        Assert.assertTrue(lruCache.get(3).equals("Three"));
    }
}