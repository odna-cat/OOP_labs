package hust.soict.cybersec.aims.media;

public class DigitalVideoDisc extends Disc implements Playable {
    public DigitalVideoDisc(String title, String category,
            float cost, int length, String director) {
        super(title, category, cost, length, director);
    }

    public DigitalVideoDisc(String title) {
        super(title);
    }

    @Override
    public String toString() {
        return "Title: " + this.getTitle() + " - Category: " + this.getCategory()
                + " - Director: " + this.getDirector() + " - Runtime: " + this.getLength()
                + " - Cost: " + this.getCost();
    }

    @Override
    public void play() {
        System.out.println("Playing DVD: " + this.getTitle());
        System.out.println("DVD length" + this.getLength());
    }
}