package main.store;
import java.util.ArrayList;
import main.media.Media;

public class Store {
    ArrayList<Media> itemsInStore;
    
    public void addItem(Media item) {
        itemsInStore.add(item);
    }
    public void removeItem(Media item) {
        itemsInStore.remove(item);
    }
}
