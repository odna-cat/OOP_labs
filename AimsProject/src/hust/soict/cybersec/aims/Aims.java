package hust.soict.cybersec.aims;

import hust.soict.cybersec.aims.cart.Cart;
import hust.soict.cybersec.aims.media.*;
import hust.soict.cybersec.aims.store.Store;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Aims {
    public static void main(String[] args) throws Exception {
        Store store = new Store();
        Cart cart = new Cart();
        showMenu(store, cart);
    }

    public static int intInput() {
        @SuppressWarnings("resource") // Delete later
        Scanner scan = new Scanner(System.in);
        int option = scan.nextInt();
        return option;
    }

    public static String strInput() {
        @SuppressWarnings("resource")
        Scanner scan = new Scanner(System.in);
        String str = scan.nextLine();
        return str;
    }

    public static void showMenu(Store store, Cart cart) throws IOException {
        System.out.println("AIMS: ");
        System.out.println("--------------------------------");
        System.out.println("1. View store");
        System.out.println("2. Update store");
        System.out.println("3. See current cart");
        System.out.println("0. Exit");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2-3");
        int option = intInput();
        switch (option) {
            case 1 -> storeMenu(store, cart);
            case 2 -> {
                storeUpdate(store);
                showMenu(store, cart);
            }
            case 3 -> {
                cartMenu(cart);
                showMenu(store, cart);
            }
            case 0 -> System.exit(0);
            default -> throw new IOException();
        }
    }

    public static void storeUpdate(Store store) throws IOException {
        System.out.println("Options");
        System.out.println("--------------------------------");
        System.out.println("1. Add media");
        System.out.println("2. Remove media");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number 0-1-2");
        int option = intInput();
        switch (option) {
            case 1 -> {
                System.out.println("Options:");
                System.out.println("--------------------------------");
                System.out.println("1. Add book");
                System.out.println("2. Add CD");
                System.out.println("3. Add DVD");
                System.out.println("0. Back");
                System.out.println("--------------------------------");
                System.out.println("Please choose a number 0-1-2-3");
                int option1 = intInput();
                switch (option1) {
                    case 1 -> {
                        Book book = new Book(strInput());
                        store.addItem(book);
                    }
                    case 2 -> {
                        CompactDisc cd = new CompactDisc(strInput());
                        store.addItem(cd);
                    }
                    case 3 -> {
                        DigitalVideoDisc dvd = new DigitalVideoDisc(strInput());
                        store.addItem(dvd);
                    }
                    case 0 -> {
                    }
                }
                storeUpdate(store);
            }
            case 2 -> {
                store.removeItem(getSearchResult(search(store)));
            }
            case 0 -> {
            }
            default -> throw new IOException();
        }
    }

    public static void storeMenu(Store store, Cart cart) throws IOException {
        store.print();
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. See a media's details");
        System.out.println("2. Add a media to cart");
        System.out.println("3. Play a media");
        System.out.println("4. See current cart");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2-3-4");
        int option = intInput();
        switch (option) {
            case 1 -> mediaDetailsMenu(getSearchResult(search(cart)), cart);
            case 2 -> cart.addMedia(getSearchResult(search(cart)));
            case 3 -> play(getSearchResult(search(store)));
            case 4 -> cartMenu(cart);
            case 0 -> showMenu(store, cart);
            default -> throw new IOException();
        }
    }

    public static void mediaDetailsMenu(Media item, Cart cart) throws IOException {
        System.out.println(item.toString());
        System.out.println("Options");
        System.out.println("--------------------------------");
        System.out.println("1. Add to cart");
        System.out.println("2. Play");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2");
        System.out.println("--------------------------------");
        int option = intInput();
        switch (option) {
            case 1 -> cart.addMedia(item);
            case 2 -> {
                if (item instanceof DigitalVideoDisc dvd) {
                    dvd.play();
                }
                if (item instanceof CompactDisc cd) {
                    cd.play();
                }
            }
            case 0 -> {
            }
            default -> throw new IOException();
        }
    }

    public static void cartMenu(Cart cart) throws IOException {
        cart.print();
        System.out.println("Options");
        System.out.println("--------------------------------");
        System.out.println("1. Filter media in cart");
        System.out.println("2. Sort media in cart");
        System.out.println("3. Remove media in cart");
        System.out.println("4. Play a media");
        System.out.println("5. Place order");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number 0-1-2-3-4-5");
        System.out.println("--------------------------------");
        int option = intInput();
        List<Media> results = new ArrayList<>();
        switch (option) {
            case 1 -> {
                filter(cart);
                cartMenu(cart);
            }
            case 2 -> {
                sort(cart);
                cartMenu(cart);
            }
            case 3 -> {
                results = search(cart);
                cart.removeMedia(getSearchResult(results));
            }
            case 4 -> {
                Media item = getSearchResult(results);
                play(item);
                cartMenu(cart);
            }
            case 5 -> placeOrder(cart);
            case 0 -> {
            }
            default -> throw new IOException();
        }
    }

    public static void placeOrder(Cart cart) {
        System.out.println("Your order has been placed.");
        cart.clear();
        System.exit(0);
    }

    public static void filter(Cart cart) throws IOException {
        System.out.println("Filter by:");
        System.out.println("--------------------------------");
        System.out.println("1. ID");
        System.out.println("2. Title");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number 0-1-2");
        int option1 = intInput();
        switch (option1) {
            case 1 -> {
                System.out.println("Enter search ID: ");
                int id = intInput();
                printSearchResults(cart.searchID(id));
            }
            case 2 -> {
                System.out.println("Enter search title: ");
                String title = strInput();
                printSearchResults(cart.searchTitle(title));
            }
            case 0 -> {
            }
            default -> throw new IOException();
        }
    }

    public static void sort(Cart cart) throws IOException {
        System.out.println("Sort by:");
        System.out.println("--------------------------------");
        System.out.println("1. Title");
        System.out.println("2. Cost");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number 0-1-2");
        int option1 = intInput();
        switch (option1) {
            case 1 -> cart.sortByTitleCost();
            case 2 -> cart.sortByCostTitle();
            case 0 -> {
            }
            default -> throw new IOException();
        }
    }

    public static List<Media> search(Cart cart) {
        System.out.println("Search by: ");
        System.out.println("1. Title");
        System.out.println("2. ID");
        System.out.println("0. Back");
        int option = intInput();
        List<Media> results = new ArrayList<>();
        switch (option) {
            case 1 -> {
                System.out.println("Enter title: ");
                String title = strInput();
                results = cart.searchTitle(title);
            }
            case 2 -> {
                System.out.println("Enter ID: ");
                int id = intInput();
                results = cart.searchID(id);
            }
            case 0 -> {
            }
        }
        return results;
    }

    public static List<Media> search(Store store) {
        System.out.println("Search by: ");
        System.out.println("--------------------------------");
        System.out.println("1. Title");
        System.out.println("2. ID");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please chose a number 0-1-2");
        int option = intInput();
        List<Media> results = new ArrayList<>();
        switch (option) {
            case 1 -> {
                String title = strInput();
                results = store.searchTitle(title);
            }
            case 2 -> {
                int id = intInput();
                results = store.searchID(id);
            }
            case 0 -> {
            }
        }
        return results;
    }

    public static void play(Media item) {
        if (item instanceof DigitalVideoDisc dvd)
            dvd.play();
        if (item instanceof CompactDisc cd)
            cd.play();
        if (!(item instanceof DigitalVideoDisc) && !(item instanceof CompactDisc))
            System.out.println("Something went wrong.");
    }

    public static Media getSearchResult(List<Media> results) {
        if (!results.isEmpty()) {
            System.out.println("Input index of item you want");
            try (Scanner scan = new Scanner(System.in)) {
                int index = scan.nextInt();
                return results.get(index);
            }
        } else {
            return null;
        }
    }

    public static void printSearchResults(List<Media> results) {
        if (!results.isEmpty()) {
            System.out.println("Search results matching your query: ");
            for (int i = 0; i < results.size(); i++) {
                System.out.println(results.get(i).toString());
            }
        } else {
            System.out.println("No matching results.");
        }
    }
}
