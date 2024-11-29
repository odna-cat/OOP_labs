package main.cart;
import java.util.*;
import media.Media;

public class Cart {

    public static final int MAX_NUMBERS_ORDERED = 20;
    private int qtyOrdered = 0;

    private ArrayList<Media> itemsOrdered = 
    new ArrayList<>(MAX_NUMBERS_ORDERED);

    public void addMedia(Media item) {
        if (qtyOrdered < MAX_NUMBERS_ORDERED) {
            itemsOrdered.add(item);
            qtyOrdered += 1;
            System.out.println("Item added to cart.");
        } {
            System.out.println("The cart is almost full.");
        }
    }
    public void addMedia(ArrayList<Media> mediaList) {
        if (qtyOrdered + mediaList.size() < MAX_NUMBERS_ORDERED) {
            itemsOrdered.addAll(mediaList);
            qtyOrdered += mediaList.size();
            System.out.println("Items added to cart.");
        } else {
            System.out.println("The cart is almost full.");
        }
    }
    public void addMedia(Media item1, Media item2) {
        if (qtyOrdered + 2 < MAX_NUMBERS_ORDERED) {
            itemsOrdered.add(item1);
            itemsOrdered.add(item2);
            qtyOrdered += 2;
            System.out.println("Items added to cart.");
            } else {
                System.out.println("The cart is almost full.");
            }
        }
    public void removeMedia(Media item) {
        if (qtyOrdered == 0 || !itemsOrdered.contains(item)) {
            System.out.println("Item not available.");
        } else {
            itemsOrdered.remove(item);
            qtyOrdered -= 1;
            System.out.println("Item removed from cart.");
        }
    }
    public float totalCost() {
        float sum = 0;
        for (Media item : itemsOrdered) {
            if (item != null) {
            sum += item.getCost();
        } else {sum += 0;}
    }
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
            if (item.getTitle().equals(title))
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

        }
        System.out.println("Total cost: " + totalCost());
        System.out.println("*************************************************** ");
    }
}