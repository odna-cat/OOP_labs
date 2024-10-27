

public class Cart {

    public static final int MAX_NUMBERS_ORDERED = 20;
    private int qtyOrdered;

    private final DigitalVideoDisc itemsOrdered[] = 
    new DigitalVideoDisc[MAX_NUMBERS_ORDERED];

    public void addDigitalVideoDisc(DigitalVideoDisc disc) {
        if (qtyOrdered < 20) {
            itemsOrdered[qtyOrdered] = disc;
            qtyOrdered += 1;
            System.out.println("Item added to cart.");
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
}