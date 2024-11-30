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

    public void searchID(int id) {
        List<Media> results = new ArrayList<>();
        for (Media item : itemsOrdered) {
            if (item.getId() == id)
                results.add(item);
        }
        if (!results.isEmpty()) {
            System.out.println("Search results for items with ID " + id + ": ");
            for (int i = 0; i < results.size(); i++) {
                System.out.println(results.get(i).toString());
            }
        } else {
            System.out.println("No matching results.");
        }
    }

    public void searchTitle(String title) {
        List<Media> results = new ArrayList<>();
        for (Media item : itemsOrdered) {
            if (item.isMatch(title))
                results.add(item);
        }
        if (!results.isEmpty()) {
            System.out.println("Search results for items with title" + title + ": ");
            for (int i = 0; i < results.size(); i++) {
                System.out.println(results.get(i).toString());
            }
        } else {
            System.out.println("No matching results.");
        }
    }


    public void print() {
        System.out.println("***********************CART*********************** ");
        System.out.println("Ordered items:");
        // for (int i = 0; i < qtyOrdered; i++) {
        //     System.out.println((i+1) + ". " + itemsOrdered[i].toString());
        // }
        for (Media item : itemsOrdered) {
            item.toString();
        }
        System.out.println("Total cost: " + totalCost());
        System.out.println("*************************************************** ");
    }
}