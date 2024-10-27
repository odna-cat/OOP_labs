public class Aims{
    public static void main(String[] args) throws Exception {
        // Create a new Cart
        Cart anOrder = new Cart();

        // Create new DVD objects and add to cart
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation",
        "Roger Allers", 87, 19.95f);
        anOrder.addDigitalVideoDisc(dvd1);

        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction",
        "George Lucas", 87, 24.95f);
        anOrder.addDigitalVideoDisc(dvd2);

        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladdin", "Animation", 
        null, 0,18.99f);
        anOrder.addDigitalVideoDisc(dvd3);

        // Calculate total cost of cart items
        System.out.print("Total cost is: ");
        System.out.println(anOrder.totalCost());

        // Remove item and calculate total cost item
        anOrder.removeDigitalVideoDisc(dvd3);
        System.out.print("Total cost is: ");
        System.out.println(anOrder.totalCost());
    }
}
