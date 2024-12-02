package main.media;

public class Disc extends Media {
    private int length;
    private String director = null;

    public Disc(String title, String category,
    float cost, int length, String director) {
        super(title, category, cost);
        this.length = length;
        this.director = director;
    }
    public Disc(String title, String category,
    float cost) {
        super(title, category, cost);
    }
    public Disc(String title) {
        super(title);
    }

    // getters and setters
    public int getLength() {
        return length;
    }
    public String getDirector() {
        return director;
    }
    public void setLength(int newLength) {
        this.length = newLength;
    }
    public void setDirector(String newDirector) {
        this.director = newDirector;
    }
}
