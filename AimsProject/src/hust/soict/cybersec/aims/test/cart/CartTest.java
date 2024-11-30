package test.cart;
import main.cart.Cart;
import main.media.*;

public class CartTest{
    public static void main(String[] args) {
        Cart cart = new Cart();

        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation",
        19.95f, 87, "Roger Allers");
        cart.addMedia(dvd1);

        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction",
        24.95f, 87, "George Lucas");
        cart.addMedia(dvd2);

        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladdin", "Animation", 
        18.99f, 0, null);
        cart.addMedia(dvd3);

        //Test the print method
        cart.print();
        //Test the search methods
        cart.searchID(3);
        cart.searchID(5);
        cart.searchTitle("Aladdin");
        cart.searchTitle("I Saw the TV Glow");
    }
}