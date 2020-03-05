package dsassignment1_spring2019;

import Exceptions.ElementNotFoundException;
import Exceptions.EmptyCollectionException;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @version Spring 2019
 * @author Paul Franklin, Kyle Kiefer
 */
public class ShoppingListArray implements ShoppingListADT {

    private static final int DEFAULT_SIZE = 5;
    private Grocery[] shoppingList;
    private int size;

    /**
     * Default constructor of ShoppingArray object.
     */
    public ShoppingListArray() {
        shoppingList = new Grocery[DEFAULT_SIZE];
        size = 0;
    }

    /**
     * Constructor of ShoppingArray object that parses from a file.
     *
     * @param filename the name of the file to parse
     * @throws FileNotFoundException if an error occurs when parsing the file
     */
    public ShoppingListArray(String filename) throws FileNotFoundException {
        shoppingList = new Grocery[DEFAULT_SIZE];
        size = 0;
        scanFile(filename);
    }

    /**
     * Method get an entry from the list located at index.
     *
     * @param index the index to retrieve the entry from
     * @return the entry located at index
     * @throws IndexOutOfBoundsException
     * @throws Exceptions.EmptyCollectionException
     */
    @Override
    public Grocery find(int index) throws IndexOutOfBoundsException,
            EmptyCollectionException {
        if (this.isEmpty()) {
            throw new EmptyCollectionException("ECE - find");
        }
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException("IOOBE - find");
        }

        return shoppingList[index];
    }

    /**
     * Method to add a new entry. Only new entries can be added. Combines 
     * quantities if entry already exists.
     *
     * @param entry the entry to be added
     */
    @Override
    public void add(Grocery entry) {

        // Check if exists
        if (contains(entry)) {
            //Adds the quantity of new entry into existing entry
            combineQuantity(entry);
            return;
        }

        // Expand if necessary
        if (size == shoppingList.length) {
            this.expandCapacity();
        }

        shoppingList[size] = entry;
        size++;
    }

    /**
     * Method to remove an entry.
     *
     * @param ent to be removed
     * @return true when entry was removed
     */
    @Override
    public boolean remove(Grocery ent) {
        Grocery entry = null;

        // Search for entry
        int i = 0;
        for (; i < size; i++) {
            if (shoppingList[i].compareTo(ent) == 0) {
                entry = shoppingList[i];
                shoppingList[i] = null;
                break;
            }
        }

        // Return false if not found
        if (entry == null) {
            return false;
        }

        // Shift elements
        for (; i + 1 < size; i++) {
            shoppingList[i] = shoppingList[i + 1];
        }

        shoppingList[size - 1] = null;

        size--;
        return true;
    }

    /**
     * Method to locate the index of an entry.
     *
     * @param ent to find the index
     * @return the index of the entry
     * @throws ElementNotFoundException if no entry was found
     */
    @Override
    public int indexOf(Grocery ent) throws ElementNotFoundException {
        for (int i = 0; i < size; i++) {
            if (shoppingList[i].compareTo(ent) == 0) {
                return i;
            }
        }

        throw new ElementNotFoundException("indexOf");
    }

    /**
     * Method to determine whether the object contains an entry.
     *
     * @param ent to find
     * @return true if and only if the entry is found
     */
    @Override
    public boolean contains(Grocery ent) {
        boolean hasItem = false;

        for (int i = 0; i < size; i++) {
            if (shoppingList[i] != null
                    && shoppingList[i].compareTo(ent) == 0) {
                hasItem = true;
                break;
            }
        }

        return hasItem;
    }

    /**
     * Gets the size of the collection.
     *
     * @return the size of the collection
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * Gets whether the collection is empty.
     *
     * @return true if and only if the collection is empty
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Returns a string representing this object.
     *
     * @return a string representation of this object
     */
    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append(String.format("%-25s", "NAME"));
        s.append(String.format("%-18s", "CATEGORY"));
        s.append(String.format("%-10s", "AISLE"));
        s.append(String.format("%-10s", "QUANTITY"));
        s.append(String.format("%-10s", "PRICE"));
        s.append('\n');
        s.append("------------------------------------------------------------"
                + "-------------");
        s.append('\n');
        for (int i = 0; i < size; i++) {
            s.append(String.format("%-25s", shoppingList[i].getName()));
            s.append(String.format("%-18s", shoppingList[i].getCategory()));
            s.append(String.format("%-10s", shoppingList[i].getAisle()));
            s.append(String.format("%-10s", shoppingList[i].getQuantity()));
            s.append(String.format("%-10s", shoppingList[i].getPrice()));
            s.append('\n');
            s.append("--------------------------------------------------------"
                    + "-----------------");
            s.append('\n');
        }

        return s.toString();
    }

    /**
     * Add the quantity of a duplicate entry into the existing
     *
     * @param entry duplicate
     */
    private void combineQuantity(Grocery entry) {
        try {
            int index = this.indexOf(entry);
            shoppingList[index].setQuantity(shoppingList[index].getQuantity()
                    + entry.getQuantity());
        } catch (ElementNotFoundException e) {
            System.out.println("combineQuantity - ECE");
        }

    }

    /**
     * Scans the specified file to add items to the collection.
     *
     * @param filename the name of the file to scan
     * @throws FileNotFoundException if the file is not found
     */
    private void scanFile(String filename) throws FileNotFoundException {
        Scanner scanner = new Scanner(getClass().getResourceAsStream(filename))
                .useDelimiter("(,|\r\n)");

        while (scanner.hasNext()) {
            Grocery temp = new Grocery(scanner.next(), scanner.next(),
                    Integer.parseInt(scanner.next()),
                    Float.parseFloat(scanner.next()),
                    Integer.parseInt(scanner.next()));
            
            add(temp);
        }
    }

    /**
     * Expands the capacity of the collection.
     */
    private void expandCapacity() {
        shoppingList = Arrays.copyOf(shoppingList, size * 2);
    }

}
