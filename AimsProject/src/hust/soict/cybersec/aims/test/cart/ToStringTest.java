package test.cart;
import java.util.ArrayList;
import java.util.List;
import main.media.*;

public class ToStringTest {
    public static void main(String[] args) {
        List<Media> items = new ArrayList<>();

        // Test items
        Book m1 = new Book("Hamlet", "Play", 15.99f, null);
        m1.addAuthor("William Shakespeare");
        CompactDisc m2 = new CompactDisc("Little Dark Age", "Rock", 0f, "MGMT", null);
        Track t1 = new Track("She Works Out Too Much", 198);
        m2.addTrack(t1);
        Track t2 = new Track("Little Dark Age");
        m2.addTrack(t2);
        DigitalVideoDisc m3 = new DigitalVideoDisc("I Saw The TV Glow");

        items.add(m1);
        items.add(m2);
        items.add(m3);

        for (Media m : items) {
            System.out.println(m.toString());
        }
    }
}
