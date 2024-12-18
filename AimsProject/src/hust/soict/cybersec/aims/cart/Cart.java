package hust.soict.cybersec.aims.cart;

import hust.soict.cybersec.aims.media.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.*;

public class Cart {

    public static final int MAX_NUMBERS_ORDERED = 20;
    @SuppressWarnings("FieldMayBeFinal") // remove annotation later
    private ObservableList<Media> itemsOrdered = FXCollections.observableArrayList();

    public ObservableList<Media> getItemsOrdered() {
        return itemsOrdered;
    }

    public void addMedia(Media item) {
        if (itemsOrdered.size() == MAX_NUMBERS_ORDERED) {
            System.out.println("The cart is almost full.");
            return;
        }

        itemsOrdered.add(item);
        System.out.println(item.getTitle() + " has been added.");
    }

    public void addMedia(Media[] mediaList) {
        for (Media item : mediaList) {
            addMedia(item);
        }
    }

    public void addMedia(Media item1, Media item2) {
        addMedia(item1);
        addMedia(item2);
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

    public ObservableList<Media> searchID(int id) {
        ObservableList<Media> results = FXCollections.observableArrayList();
        for (Media item : itemsOrdered) {
            if (item.getId() == id)
                results.add(item);
        }
        return results;
    }

    public ObservableList<Media> searchTitle(String title) {
        ObservableList<Media> results = FXCollections.observableArrayList();
        for (Media item : itemsOrdered) {
            if (item.isMatch(title))
                results.add(item);
        }
        return results;
    }

    public void sortByTitleCost() {
        Collections.sort(this.itemsOrdered, Media.COMPARE_BY_TITLE_COST);
    }

    public void sortByCostTitle() {
        Collections.sort(this.itemsOrdered, Media.COMPARE_BY_COST_TITLE);
    }

    public void print() {
        System.out.println("***********************CART*********************** ");
        if (!itemsOrdered.isEmpty()) {
            System.out.println("Ordered items:");
            for (Media item : itemsOrdered) {
                item.toString();
            }
            System.out.println("Total cost: " + totalCost());
        } else {
            System.out.println("Nothing has been added to cart yet.");
        }
        System.out.println("*************************************************** ");
    }

    public void clear() {
        this.itemsOrdered.clear();
    }
}