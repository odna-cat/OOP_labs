package media;

public class Disc extends Media {
    private int length;
    private String director;

    public Disc(int id, String title, String category,
    float cost, int length, String director) {
        super();
        this.length = length;
        this.director = director;
    }
    public Disc(String title, String category,
    float cost, int length, String director) {
        super();
        this.length = length;
        this.director = director;
    }
    // getters
    public int getLength() {
        return length;
    }
    public String getDirector() {
        return director;
    }
}
