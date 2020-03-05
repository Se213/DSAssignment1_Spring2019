
package dsassignment1_spring2019;

import Exceptions.ElementNotFoundException;
import Exceptions.EmptyCollectionException;

/**
 * @version Spring 2019
 * @author Paul Franklin, Kyle Kiefer
 */
public interface ShoppingListADT {
    
    /**
     * Method to add a new entry. Only new entries can be added. Combines 
     * quantities if entry already exists.
     *
     * @param entry the entry to be added
     */
    public void add(Grocery entry);
    
    /**
     * Method to remove an entry.
     *
     * @param ent to be removed
     * @return true when entry was removed
     */
    public boolean remove(Grocery ent);
    
    /**
     * Method to find an entry.
     *
     * @param index to find
     * @return the entry if found
     * @throws Exceptions.EmptyCollectionException
     */
    public Grocery find(int index) throws IndexOutOfBoundsException,
            EmptyCollectionException;
    
    /**
     * Method to locate the index of an entry.
     *
     * @param ent to find the index
     * @return the index of the entry
     * @throws ElementNotFoundException if no entry was found
     */
    public int indexOf(Grocery ent) throws ElementNotFoundException;
    
    /**
     * Method to determine whether the object contains an entry.
     *
     * @param ent to find
     * @return true if and only if the entry is found
     */
    public boolean contains(Grocery ent);
    
    /**
     * Gets the size of the collection.
     *
     * @return the size of the collection
     */
    public int size();
    
    /**
     * Gets whether the collection is empty.
     *
     * @return true if and only if the collection is empty
     */
    public boolean isEmpty();
    
    /**
     * Returns a string representing this object.
     *
     * @return a string representation of this object
     */
    @Override
    public String toString();
}
