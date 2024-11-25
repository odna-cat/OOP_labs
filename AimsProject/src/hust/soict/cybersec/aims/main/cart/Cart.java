package main.cart;
import java.util.*;
import main.disc.DigitalVideoDisc;
public class Cart {

    public static final int MAX_NUMBERS_ORDERED = 20;
    private int qtyOrdered = 0;

    private final DigitalVideoDisc itemsOrdered[] = 
    new DigitalVideoDisc[MAX_NUMBERS_ORDERED];

    public void addDigitalVideoDisc(DigitalVideoDisc disc) {
        if (qtyOrdered < MAX_NUMBERS_ORDERED) {
            itemsOrdered[qtyOrdered] = disc;
            qtyOrdered += 1;
            System.out.println("Item added to cart.");
        } else {
            System.out.println("The cart is almost full.");
        }
    }
    public void addDigitalVideoDisc(DigitalVideoDisc [] dvdList) {
        if (qtyOrdered + dvdList.length < MAX_NUMBERS_ORDERED) {
            for (int i = 0; i < dvdList.length; i++) {
                itemsOrdered[qtyOrdered+i] = dvdList[i];
            }
            qtyOrdered += dvdList.length;
            System.out.println("Items added to cart.");
        } else {
            System.out.println("The cart is almost full.");
        }
    }
    public void addDigitalVideoDisc(DigitalVideoDisc dvd1, DigitalVideoDisc dvd2) {
        if (qtyOrdered + 2 < MAX_NUMBERS_ORDERED) {
            itemsOrdered[qtyOrdered] = dvd1;
            itemsOrdered[qtyOrdered + 1] = dvd2;
            qtyOrdered += 2;
            System.out.println("Items added to cart.");
            } else {
                System.out.println("The cart is almost full.");
            }
        }
    public void removeDigitalVideoDisc(DigitalVideoDisc disc) {
        if (qtyOrdered == 0) {
            System.out.println("Empty cart.");
        } else {
            for (int i = 0; i < itemsOrdered.length; i++) {
                if (itemsOrdered[i] == disc) {
                    itemsOrdered[i] = null;
                    break;
                }
            }
            qtyOrdered -= 1;
            System.out.println("Item removed from cart.");
        }
    }
    public float totalCost() {
        float sum = 0;
        for (DigitalVideoDisc disc : itemsOrdered) {
            if (disc != null) {
            sum += disc.getCost();
        } else {sum += 0;}
    }
       return sum;
    }

    public void searchID(int id) {
        List<DigitalVideoDisc> results = new ArrayList<>();
        for (int i = 0; i < qtyOrdered; i++) {
            if (itemsOrdered[i].getID() == id)
                results.add(itemsOrdered[i]);
        }
        if (!results.isEmpty()) {
            System.out.println("Search results for discs with ID " + id + ": ");
            for (int i = 0; i < results.size(); i++) {
                System.out.println(results.get(i).toString());
            }
        } else {
            System.out.println("No matching results.");
        }
    }

    public void searchTitle(String title) {
        List<DigitalVideoDisc> results = new ArrayList<>();
        for (int i = 0; i < qtyOrdered; i++) {
            if (itemsOrdered[i].isMatch(title)) {
                results.add(itemsOrdered[i]);
            }
        }
        if (!results.isEmpty()) {
            System.out.println("Search results for discs with title" + title + ": ");
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
        for (int i = 0; i < qtyOrdered; i++) {
            System.out.println((i+1) + ". " + itemsOrdered[i].toString());
        }
        System.out.println("Total cost: " + totalCost());
        System.out.println("*************************************************** ");
    }
}