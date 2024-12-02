package main.cart;
import java.util.*;
import main.media.Media;

public class Cart {

    public static final int MAX_NUMBERS_ORDERED = 20;
    @SuppressWarnings("FieldMayBeFinal") // remove annotation later
    private ArrayList<Media> itemsOrdered = 
    new ArrayList<>();
    
    public ArrayList<Media> getItemsOrdered() {
        return itemsOrdered;
    }

    public void addMedia(Media item) {
        if (itemsOrdered.size() < MAX_NUMBERS_ORDERED) {
            itemsOrdered.add(item);
            System.out.println("Item added to cart.");
        } {
            System.out.println("The cart is almost full.");
        }
    }
    public void addMedia(ArrayList<Media> mediaList) {
        if (itemsOrdered.size() + mediaList.size() < MAX_NUMBERS_ORDERED) {
            itemsOrdered.addAll(mediaList);
            System.out.println("Items added to cart.");
        } else {
            System.out.println("The cart is almost full.");
        }
    }
    public void addMedia(Media item1, Media item2) {
        if (itemsOrdered.size() + 2 < MAX_NUMBERS_ORDERED) {
            itemsOrdered.add(item1);
            itemsOrdered.add(item2);
            System.out.println("Items added to cart.");
            } else {
                System.out.println("The cart is almost full.");
            }
        }
    public void removeMedia(Media item) {
        if (!itemsOrdered.contains(item)) {
            System.out.println("Item not available.");
        } else {
            itemsOrdered.remove(item);
            System.out.println("Item removed from cart.");
        }
    }

    public float totalCost() {
        float sum = 0;
        for (Media item : itemsOrdered)
            sum += item.getCost();
        return sum;
    }

    public List<Media> searchID(int id) {
        List<Media> results = new ArrayList<>();
        for (Media item : itemsOrdered) {
            if (item.getId() == id)
                results.add(item);
        }
        return results;
    }
    public List<Media> searchTitle(String title) {
        List<Media> results = new ArrayList<>();
        for (Media item : itemsOrdered) {
            if (item.isMatch(title))
                results.add(item);
        }
        return results;
    }

    public void sortByTitleCost() {
        Collections.sort(this.itemsOrdered, Media.COMPARE_BY_TITLE_COST);
        this.print();
    }
    public void sortByCostTitle() {
        Collections.sort(this.itemsOrdered, Media.COMPARE_BY_COST_TITLE);
        this.print();
    }

    public void print() {
        System.out.println("***********************CART*********************** ");
        if (!itemsOrdered.isEmpty()) {
            System.out.println("Ordered items:");
            for (Media item : itemsOrdered) {
                item.toString();
            }
            System.out.println("Total cost: " + totalCost());
        } else {System.out.println("Nothing has been added to cart yet.");}
        System.out.println("*************************************************** ");
    }
    public void clear() {
        this.itemsOrdered.clear();
    }
}