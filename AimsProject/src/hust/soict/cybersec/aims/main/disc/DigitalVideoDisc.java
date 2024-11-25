package main.disc;
public class DigitalVideoDisc {
    private String title;
    private String category;
    private String director;
    private int length;
    private float cost;
    private static int nbDigitalVideoDisc = 0;
    private final int id;

    //constructor
    public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
        nbDigitalVideoDisc++;
        this.id = nbDigitalVideoDisc;
        this.title = title;
        this.category = category;
        this.director = director;
        this.length = length;
        this.cost = cost;
    }
    public DigitalVideoDisc(String title) {
        nbDigitalVideoDisc++;
        this.id = nbDigitalVideoDisc;
        this.title = title;
    }
    public DigitalVideoDisc(String title, String category, float cost) {
        nbDigitalVideoDisc++;
        this.id = nbDigitalVideoDisc;
        this.title = title;
        this.category = category;
        this.cost = cost;
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
    public String getTitle() {
        return title;
    }
    public String getCategory() {
        return category;
    }
    public String getDirector() {
        return director;
    }
    public int getLength() {
        return length;
    }
    public float getCost() {
        return cost;
    }
    public int getID() {
        return id;
    }

    public void setTitle(String newTitle) {
        this.title = newTitle;
    }
}