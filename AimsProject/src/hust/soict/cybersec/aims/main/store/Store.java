package main.store;
import java.util.ArrayList;
import java.util.List;
import main.media.Media;

public class Store {
    @SuppressWarnings("FieldMayBeFinal")
    private ArrayList<Media> itemsInStore = new ArrayList<>();
    
    public void addItem(Media item) {
        itemsInStore.add(item);
        System.out.println("Item added to store.");
    }
    public void removeItem(Media item) {
        if (itemsInStore.contains(item)) {
            itemsInStore.remove(item);
            System.out.println("Item removed from store.");
        } else {System.out.println("Item not available.");}
    }

    public void print() {
        System.out.println("***********************STORE*********************** ");
        if (!itemsInStore.isEmpty()) {
        System.out.println("Items in store:");
            for (Media media : itemsInStore) {
                media.toString();
            }
        } else {System.out.println("There's nothing in the store right now.");}
        System.out.println("*************************************************** ");
    }

    public List<Media> searchID(int id) {
        List<Media> results = new ArrayList<>();
        for (Media item : itemsInStore) {
            if (item.getId() == id)
                results.add(item);
        }
        return results;
    }
    public List<Media> searchTitle(String title) {
        List<Media> results = new ArrayList<>();
        for (Media item : itemsInStore) {
            if (item.isMatch(title))
                results.add(item);
        }
        return results;
    }
}
