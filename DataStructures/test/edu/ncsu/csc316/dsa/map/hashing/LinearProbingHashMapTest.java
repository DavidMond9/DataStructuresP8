package edu.ncsu.csc316.dsa.map.hashing;

import static org.junit.Assert.*;
import java.util.Iterator;
import org.junit.Before;
import org.junit.Test;
import edu.ncsu.csc316.dsa.map.Map;

/**
 * Test class for LinearProbingHashMap
 * Checks the expected outputs of the Map abstract data type behaviors when using
 * a linear probing hash map data structure 
 *
 * @author Dr. King
 * @author // Your Name Here 
 *
 */
public class LinearProbingHashMapTest {

    // 'Testing' Map used (no randomization) to check placement of entries in the hash table
	/** Map to test no randomization */
    private Map<Integer, String> testMap;
    
    // 'Production' Map (with randomization) to check correctness of ADT behaviors
    /** Map to test with randomization */
    private Map<Integer, String> prodMap;

    /**
     * Create a new instance of a linear probing hash map before each test case executes
     */     
    @Before
    public void setUp() {
        // Use the "true" flag to indicate we are testing.
        // Remember that (when testing) alpha = 1, beta = 1, and prime = 7
        // based on our AbstractHashMap constructor.
        // That means you can draw the hash table by hand
        // if you use integer keys, since Integer.hashCode() = the integer value, itself
        // Finally, apply compression. For example:
        // for key = 1: h(1) = ( (1 * 1 + 1) % 7) % 7 = 2
        // for key = 2: h(2) = ( (1 * 2 + 1) % 7) % 7 = 3
        // for key = 3: h(3) = ( (1 * 3 + 1) % 7) % 7 = 4
        // for key = 4: h(4) = ( (1 * 4 + 1) % 7) % 7 = 5
        // for key = 5: h(5) = ( (1 * 5 + 1) % 7) % 7 = 6
        // for key = 6: h(6) = ( (1 * 6 + 1) % 7) % 7 = 0
        // etc.
        testMap = new LinearProbingHashMap<Integer, String>(7, true);
        prodMap = new LinearProbingHashMap<Integer, String>();
    }
    
    /**
     * Test the output of the put(k,v) behavior
     */     
    @Test
    public void testPut() {
        assertEquals(0, testMap.size());
        assertTrue(testMap.isEmpty());
        assertNull(testMap.put(1, "one"));
        assertNull(testMap.put(2, "two"));
        
        
        Iterator<Map.Entry<Integer, String>> iterator = testMap.entrySet().iterator();
        assertTrue(iterator.hasNext());
        assertEquals((int) iterator.next().getKey(), 1);
        assertEquals((int) iterator.next().getKey(), 2);
        assertEquals(testMap.size(), 2);
        
        
        
        assertEquals(0, prodMap.size());
        assertTrue(prodMap.isEmpty());
        assertNull(prodMap.put(1, "one"));
        assertNull(prodMap.put(3, "three"));
        assertNull(prodMap.put(5, "five"));
        assertNull(prodMap.put(2, "two"));
        
        Iterator<Map.Entry<Integer, String>> iterator2 = prodMap.entrySet().iterator();
        assertTrue(iterator2.hasNext());
        assertEquals((int) iterator2.next().getKey(), 5);
        assertEquals((int) iterator2.next().getKey(), 3);
        assertEquals(prodMap.size(), 4);
        
        
    }
    
    /**
     * Test the output of the get(k) behavior
     */     
    @Test
    public void testGet() {
        assertTrue(testMap.isEmpty());
        assertEquals(0, testMap.size());
        assertTrue(testMap.isEmpty());
        assertNull(testMap.put(1, "one"));
        assertNull(testMap.put(2, "two"));
        
        
        Iterator<Map.Entry<Integer, String>> iterator = testMap.entrySet().iterator();
        assertTrue(iterator.hasNext());
        assertEquals((int) iterator.next().getKey(), 1);
        assertEquals((int) iterator.next().getKey(), 2);
        assertEquals(testMap.size(), 2);
        
        
        
        assertEquals(0, prodMap.size());
        assertTrue(prodMap.isEmpty());
        assertNull(prodMap.put(1, "one"));
        assertNull(prodMap.put(3, "three"));
        assertNull(prodMap.put(5, "five"));
        assertNull(prodMap.put(2, "two"));
        
        Iterator<Map.Entry<Integer, String>> iterator2 = prodMap.entrySet().iterator();
        assertTrue(iterator2.hasNext());
        assertEquals((int) iterator2.next().getKey(), 3);
        assertEquals((int) iterator2.next().getKey(), 5);
        assertEquals(prodMap.size(), 4);
        
        assertEquals(testMap.get(1), "one");
        assertEquals(testMap.get(2), "two");
        assertEquals(prodMap.get(1), "one");
        assertEquals(prodMap.get(5), "five");
        
    }
    
    /**
     * Test the output of the remove(k) behavior
     */ 
    @Test
    public void testRemove() {
    	assertTrue(testMap.isEmpty());
        assertEquals(0, testMap.size());
        assertTrue(testMap.isEmpty());
        assertNull(testMap.put(1, "one"));
        assertNull(testMap.put(2, "two"));
        
        
        Iterator<Map.Entry<Integer, String>> iterator = testMap.entrySet().iterator();
        assertTrue(iterator.hasNext());
        assertEquals((int) iterator.next().getKey(), 1);
        assertEquals((int) iterator.next().getKey(), 2);
        assertEquals(testMap.size(), 2);
        
        
        
        assertEquals(0, prodMap.size());
        assertTrue(prodMap.isEmpty());
        assertNull(prodMap.put(1, "one"));
        assertNull(prodMap.put(3, "three"));
        assertNull(prodMap.put(5, "five"));
        assertNull(prodMap.put(2, "two"));
        
        assertEquals(testMap.remove(1), "one");
        assertEquals(testMap.remove(2), "two");
        
        assertEquals(prodMap.remove(1), "one");
        assertEquals(prodMap.remove(2), "two");
    }
    
    /**
     * Test the output of the iterator() behavior, including expected exceptions
     */     
    @Test
    public void testIterator() {
        testMap.put(1, "one");
        testMap.put(2, "two");
        testMap.put(3,  "three");
        
        prodMap.put(1,  "one");
        prodMap.put(4, "four");
        prodMap.put(2, "two");
        
        Iterator<Integer> it = testMap.iterator();
        assertTrue(it.hasNext());
    }
    
    /**
     * Test the output of the entrySet() behavior
     */     
    @Test
    public void testEntrySet() {
        
    	testMap.put(1, "one");
        testMap.put(2, "two");
        testMap.put(3,  "three");
        
        prodMap.put(1,  "one");
        prodMap.put(4, "four");
        prodMap.put(2, "two");
        Iterator<Map.Entry<Integer, String>> it = testMap.entrySet().iterator();
        assertEquals((int) it.next().getKey(), 1);
        assertEquals((int) it.next().getKey(), 2);
        
        Iterator<Map.Entry<Integer, String>> it2 = prodMap.entrySet().iterator();
        assertEquals((int) it2.next().getKey(), 4);
        assertEquals((int) it2.next().getKey(), 1);

        
    }
    
    /**
     * Test the output of the values() behavior
     */  
    @Test
    public void testValues() {
    	testMap.put(1, "one");
        testMap.put(2, "two");
        testMap.put(3,  "three");
        
        prodMap.put(1,  "one");
        prodMap.put(4, "four");
        prodMap.put(2, "two");
        
        Iterator<String> it = testMap.values().iterator();
        assertEquals(it.next(), "one");
        assertEquals(it.next(), "two");
        Iterator<String> it2 = prodMap.values().iterator();
        assertEquals(it2.next(), "one");
        assertEquals(it2.next(), "two");

    }
}