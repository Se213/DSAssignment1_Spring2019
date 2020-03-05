package dsassignment1_spring2019;

/**
 * @version Spring 2019
 * @author Paul Franklin, Kyle Kiefer
 */
public class Grocery implements Comparable<Grocery> {

    private String name;
    private String category;
    private int aisle;
    private float price;
    private int quantity;

    /**
     * Constructor of Entry object. Objects that match name and category are considered identical
     *
     * @param name the name of the item in the entry
     * @param category the category of the item in the entry
     */
    public Grocery(String name, String category) {
        this.name = name;
        this.category = category;
        this.aisle = -1;
        this.price = 0.0f;
        this.quantity = 0;
    }

    /**
     * Constructor of Entry object.
     *
     * @param name the name of the item in the entry
     * @param category the category of the item in the entry
     * @param aisle the aisle where the item in the entry is located
     * @param price the price of the item in the entry
     * @param quantity the quantity of the item to purchase
     */
    public Grocery(String name, String category, int aisle, float price,
            int quantity) {
        this.name = name;
        this.category = category;
        this.aisle = aisle;
        this.price = price;
        this.quantity = quantity;
    }

    /**
     * Gets the name of the item.
     *
     * @return the name of the item
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the item.
     *
     * @param name the name of the item
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the category of the item.
     *
     * @return the category of the item
     */
    public String getCategory() {
        return category;
    }

    /**
     * Sets the category of the item.
     *
     * @param category the category of the item
     */
    public void setCategory(String category) {
        this.category = category;
    }

    /**
     * Gets the aisle of the item.
     *
     * @return the aisle of the item
     */
    public int getAisle() {
        return aisle;
    }

    /**
     * Sets the aisle of the item.
     *
     * @param aisle the aisle of the item
     */
    public void setAisle(int aisle) {
        this.aisle = aisle;
    }

    /**
     * Gets the price of the item.
     *
     * @return the price of the item
     */
    public float getPrice() {
        return price;
    }

    /**
     * Sets the price of the item.
     *
     * @param price the price of the item
     */
    public void setPrice(float price) {
        this.price = price;
    }

    /**
     * Gets the quantity of the item.
     *
     * @return the quantity of the item
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * Sets the quantity of the item.
     *
     * @param quantity the quantity of the item
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    /**
     * Returns a string representing this object.
     *
     * @return a string representation of this object
     */
    @Override
    public String toString() {
        return "Entry{" + "name=" + name + ", category=" + category
                + ", aisle=" + aisle + ", price=" + price + ", quantity="
                + quantity + '}';
    }

    @Override
    public int compareTo(Grocery t) {
        if (this.getName().toUpperCase().compareTo(t.getName().toUpperCase()) == 0) {
            return this.getCategory().compareToIgnoreCase(t.getCategory().toUpperCase());
        }
        return this.getName().compareToIgnoreCase(t.getName().toUpperCase());
    }

}
