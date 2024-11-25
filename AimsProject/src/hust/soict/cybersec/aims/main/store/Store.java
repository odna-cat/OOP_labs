package main.store;
import java.util.ArrayList;
import main.disc.DigitalVideoDisc;

public class Store {
    ArrayList<DigitalVideoDisc> itemsInStore;
    
    public void addDVD(DigitalVideoDisc dvd) {
        itemsInStore.add(dvd);
    }
    public void removeDVD(DigitalVideoDisc dvd) {
        itemsInStore.remove(dvd);
    }
}
