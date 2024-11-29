package media;

public class DigitalVideoDisc extends Disc implements Playable {
    private final int id;
    private String title;
    private String category;
    private float cost;

    private String director;
    private int length;
    private static int nbDigitalVideoDisc = 0;

    //constructor
    //TODO: Disc.id and DigitalVideoDisc.id should be different?
    public DigitalVideoDisc(String title, String category,
    float cost, int length, String director) {
        super(title, category,
        cost, length, director);
        nbDigitalVideoDisc++;
        this.id = nbDigitalVideoDisc;
    }

    @Override
    public String toString() { 
        return "Title: " + this.title + " - Category: " + this.category
        + " - Director: " + this.director + " - Runtime: " + this.length
        + " - Cost: " + this.cost;      
    }
    public boolean  isMatch(String title) {
        return (title.equals(this.title));
    }

    // getters and setters
    public void setTitle(String newTitle) {
        this.title = newTitle;
    }

    @Override
    public void play() {
        System.out.println("Playing DVD: " + this.getTitle());
        System.out.println("DVD length" +  this.getLength());
    }
}