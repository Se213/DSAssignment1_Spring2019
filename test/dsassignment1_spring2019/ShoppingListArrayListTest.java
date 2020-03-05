package dsassignment1_spring2019;

import Exceptions.ElementNotFoundException;
import Exceptions.EmptyCollectionException;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * @version Spring 2019
 * @author Paul Franklin, Kyle Kiefer
 */
public class ShoppingListArrayListTest {

    private final ShoppingListArrayList instance;

    /**
     * Initialize instance and entries
     */
    public ShoppingListArrayListTest() {
        instance = new ShoppingListArrayList();
    }

    /**
     * Test of add method, of class ShoppingArray.
     */
    @Test
    public void testAdd() {
        //create an object, just one since I just need to make sure it adds
        Grocery entry1 = new Grocery("Mayo", "Dressing / Mayo", 1, 2.99f, 1);
        //ensure the instance list is empty before using the add method
        assertTrue(instance.isEmpty());
        // add the object by calling the add method
        instance.add(entry1);
        // assert that the list isn't empty anymore. This is sufficient because no other objects
        //were added or created other than entry1
        assertFalse(instance.isEmpty());
        

    }

    /**
     * Test of remove method, of class ShoppingArrayList.
     */
    @Test
    public void testRemove() {
        Grocery entry1 = new Grocery("Mayo", "Dressing / Mayo", 1, 2.99f, 1);
        Grocery entry2 = new Grocery("Green Tea", "Tea", 6, 1.99f, 2);
        Grocery entry3 = new Grocery("Lucky Charms", "Cereal", 7, 3.99f, 1);

        // Test element not found case
        assertFalse(instance.remove(entry1));

        instance.add(entry1);
        assertEquals(1, instance.size());
        assertTrue(instance.contains(entry1));

        instance.remove(entry1);

        // Test general case (size)
        assertEquals(0, instance.size());

        // Test general case (content)
        assertFalse(instance.contains(entry1));
        
        instance.add(entry1);
        instance.add(entry2);
        instance.add(entry3);
        
        // Test remove shifts elements
        // Before shift
        try {
            assertTrue(instance.find(0).equals(entry1));
            assertTrue(instance.find(1).equals(entry2));
            assertTrue(instance.find(2).equals(entry3));
        }
        catch (EmptyCollectionException e) {
            fail("Unexpected ECE - testRemove");
        }
        
        assertTrue(instance.remove(entry1));
        
        // After shift
        try {
            assertTrue(instance.find(0).equals(entry2));
            assertTrue(instance.find(1).equals(entry3));
        }
        catch (EmptyCollectionException e) {
            fail("Unexpected ECE - testRemove");
        }
        
        // Collection bounds changed
        try {
            instance.find(2);
            fail();
        }
        catch (IndexOutOfBoundsException | EmptyCollectionException e) {
            assertTrue(e instanceof IndexOutOfBoundsException);
        }
    }

    /**
     * Test of find method, of class ShoppingArrayList.
     */
    @Test
    public void testFind() throws IndexOutOfBoundsException, EmptyCollectionException {
        //create 3 objects to add to the array
        Grocery entry1 = new Grocery("Mayo", "Dressing / Mayo", 1, 2.99f, 1);
        Grocery entry2 = new Grocery("Green Tea", "Tea", 6, 1.99f, 2);
        Grocery entry3 = new Grocery("Lucky Charms", "Cereal", 7, 3.99f, 1);
        //test that the list is empty
        assertTrue(instance.isEmpty());
        //then add the entries...(sorry for the order)
        instance.add(entry3);
        instance.add(entry1);
        instance.add(entry2);
        //test to make sure the object found by the method being tested is entry3 which is the first object added
        
        assertTrue(instance.find(0)==entry3);
    }

    /**
     * Test of indexOf method, of class ShoppingArrayList.
     */
    @Test
    public void testIndexOf() throws ElementNotFoundException {
        //make objects to be added to instance
        Grocery entry1 = new Grocery("Mayo", "Dressing / Mayo", 1, 2.99f, 1);
        Grocery entry2 = new Grocery("Green Tea", "Tea", 6, 1.99f, 2);
        Grocery entry3 = new Grocery("Lucky Charms", "Cereal", 7, 3.99f, 1);
        // add the objects
        instance.add(entry3);
        instance.add(entry1);
        instance.add(entry2);
        //check that each object is in the correct index
        assertTrue(instance.indexOf(entry3)==0);
        assertTrue(instance.indexOf(entry2)==2);
        assertTrue(instance.indexOf(entry1)==1);

    }

    /**
     * Test of contains method, of class ShoppingArrayList.
     */
    @Test
    public void testContains() {
        Grocery entry1 = new Grocery("Mayo", "Dressing / Mayo", 1, 2.99f, 1);

        // Test element does not exist case
        assertFalse(instance.contains(entry1));

        instance.add(entry1);

        // Test element exists case
        assertTrue(instance.contains(entry1));
    }

    /**
     * Test of size method, of class ShoppingArrayList.
     */
    @Test
    public void testSize() {
        //create 3 Grocery objects to be added to 'instance'
         Grocery entry1 = new Grocery("Mayo", "Dressing / Mayo", 1, 2.99f, 1);
        Grocery entry2 = new Grocery("Green Tea", "Tea", 6, 1.99f, 2);
        Grocery entry3 = new Grocery("Lucky Charms", "Cereal", 7, 3.99f, 1);
        //assert that the instance list is empty. this is a valid test because the isEmpty test passed.
        assertTrue(instance.isEmpty());
        //add the entry
        instance.add(entry1);
        //check that the size method returns 1 after one element was added
        assertTrue(instance.size()==1);
        //add 2nd entry
        instance.add(entry2);
        //check that the size method returns 2 after another element was added
        assertTrue(instance.size()==2);
        //add 3rd entry
        instance.add(entry3);
        //check that the size method returns 3 after another element was added
        assertTrue(instance.size()==3);
        
        

    }

    /**
     * Test of isEmpty method, of class ShoppingArrayList.
     */
    @Test
    public void testIsEmpty() {
        //create 3 grocery objects to add to the 'instance' test list
        Grocery entry1 = new Grocery("Mayo", "Dressing / Mayo", 1, 2.99f, 1);
        Grocery entry2 = new Grocery("Green Tea", "Tea", 6, 1.99f, 2);
        Grocery entry3 = new Grocery("Lucky Charms", "Cereal", 7, 3.99f, 1);
        //assert that instance.isEmpty(); returns true before items are added
        //this is reliable because the isEmpty() method passed tests later on
        assertTrue(instance.isEmpty());
        //add all 3 entires to the list, the order is weird because of how I copied
        // and pasted from the already done testRemove method.
        instance.add(entry3);
        instance.add(entry1);
        instance.add(entry2);
        //test that the is empty method works by ensureing that the list isn't empty anymore
        //by calling the method in question
        assertFalse(instance.isEmpty());

    }

}
