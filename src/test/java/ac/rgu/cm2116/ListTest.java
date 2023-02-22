package ac.rgu.cm2116;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

/**
 * Generic ListTest class for testing any kind of list
 * Extending classes define the instance to be created, which is then used
 * For these purposes, is a bit easier than paramaterised tests
 */
public abstract class ListTest{

    private List<String> list;

    protected abstract List<String> createInstance();

    @Before
    public void setUp(){
        this.list = createInstance();
    }

    /**
     * Tests the add(T e) method by adding an item, then testing that the list is not empty, *and* that its size is not 1
     */
    @Test
    public void testAdd(){
        this.list.add("hello");
        
        assertFalse(this.list.isEmpty());
        assertEquals(1, this.list.size());
    }

    /**
     * Tests the get(int index) method by adding two items and attempting to retrieve them by index
     */
    @Test
    public void testGetByIndex(){

        String value1 = "hello";
        String value2 = "world";

        this.list.add(value1);
        this.list.add(value2);

        assertEquals(value1, this.list.get(0));
        assertEquals(value2, this.list.get(1));
    }

    /**
     * Tests the remove(int index) method by adding an item then attempting to remove it
     */
    @Test
    public void testRemoveByIndex(){

        String value = "hello";
        this.list.add(value);

        assertEquals(value, this.list.remove(0));
    }

    /**
     * Tests the remove(Object e) method by adding an item then attempting to remove it, and also attempting to remove a non-existent item
     */
    @Test
    public void testRemoveByObject(){

        String value1 = "hello";
        String value2 = "world";

        this.list.add(value1);

        /* Test that the value has been added */
        assertFalse(this.list.isEmpty());

        boolean result1 = this.list.remove(value1);
        boolean result2 = this.list.remove(value2);

        /* Test that the value has been removed, and the list is now emptys */
        assertTrue(result1);
        assertTrue(this.list.isEmpty());

        /* Test that we can't remove a non-existent value */
        assertFalse(result2);
    }
    
}
