package test.cart;
import main.cart.Cart;
import main.disc.DigitalVideoDisc;

public class CartTest{
    public static void main(String[] args) {
        Cart cart = new Cart();

        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King",
        "Animation", "Roger Allers", 87, 19.95f);
        cart.addDigitalVideoDisc(dvd1);

        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars",
        "Science Fiction", "George Lucas", 87, 25.95f);
        cart.addDigitalVideoDisc(dvd2);

        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladdin",
        "Animation", 18.99f);
        cart.addDigitalVideoDisc(dvd3);

        //Test the print method
        cart.print();
        //Test the search methods
        cart.searchID(3);
        cart.searchID(5);
        cart.searchTitle("Aladdin");
        cart.searchTitle("I Saw the TV Glow");
    }
}