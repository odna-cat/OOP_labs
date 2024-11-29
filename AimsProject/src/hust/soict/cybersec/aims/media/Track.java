package media;

public class Track implements Playable {
    private String title;
    private int length;

    public Track(String title, int length) {
        this.title = title;
        this.length = length;
    }    

    public String getTitle() {
        return title;
    }
    public int getLength() {
        return length;
    }

    public void play() {
        System.out.println("Now playing: " + this.getTitle());
        System.out.println("Song length: " + this.getLength());
    }
}
