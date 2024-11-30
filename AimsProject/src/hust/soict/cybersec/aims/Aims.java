import java.util.Collections;
import main.cart.Cart;
import main.media.*;

public class Aims{
    public static void main(String[] args) throws Exception {
        // Create a new Cart
        Cart cart = new Cart();

        // Create new DVD objects and add to cart
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation",
        19.95f, 87, "Roger Allers");
        cart.addMedia(dvd1);

        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction",
        24.95f, 87, "George Lucas");
        cart.addMedia(dvd2);

        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladdin", "Animation", 
        18.99f, 0, null);
        cart.addMedia(dvd3);

        // Sorting
        Collections.sort(cart.getItemsOrdered(), Media.COMPARE_BY_TITLE_COST);

        // Calculate total cost of cart items
        System.out.print("Total cost is: ");
        System.out.println(cart.totalCost());

        // Remove item and calculate total cost item
        cart.removeMedia(dvd3);
        System.out.print("Total cost is: ");
        System.out.println(cart.totalCost());
    }
}
