package hust.soict.cybersec.aims.media;

public class Track implements Playable, Comparable<Track> {
    private String title;
    private int length;

    public Track(String title, int length) {
        this.title = title;
        this.length = length;
    }

    public Track(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public int getLength() {
        return length;
    }

    public void setTitle(String newTitle) {
        this.title = newTitle;
    }

    public void setLength(int newLength) {
        this.length = newLength;
    }

    @Override
    public void play() {
        System.out.println("Now playing: " + this.getTitle());
        System.out.println("Song length: " + this.getLength());
    }

    @Override
    public boolean equals(Object obj) {
        Track track = (Track) obj;
        return (obj instanceof Track
                && track.getTitle().equals(this.getTitle()) && track.getLength() == this.getLength());
    }

    @Override
    public final int hashCode() {
        return 1;
    }

    @Override
    public int compareTo(Track track) {
        int TitleCompare = this.getTitle().compareTo(track.getTitle());
        return this.equals(track) ? 0 : TitleCompare;
    }

}
