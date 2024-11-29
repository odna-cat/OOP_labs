package media;

import java.util.List;
import java.util.ArrayList;
import javax.swing.plaf.basic.BasicSliderUI;

public class CompactDisc extends Disc implements Playable {
    private int id;
    private String title;
    private String category;
    private float cost;    
    private int length;
    private String director;

    private String artist;
    private List<Track> tracks = new ArrayList<Track>();

    public CompactDisc(int id, String title, String category,
    float cost, int length, String director) {
        super(title, category, cost, length, director);
    }

    public String getArtist() {
        return artist;
    }

    public void addTrack(Track track) {
        if (!tracks.contains(track)) {
            tracks.add(track);
        }
    }
    public void removeTrack(Track track) {
        if (tracks.contains(track)) {
            tracks.remove(track);
        }
    }
    public int getLength() {
        int length = 0;
        for (Track track : tracks) {
            length += track.getLength();
        }
        return length;
    }

    @Override
    public void play() {
        System.out.println("Now playing: " + this.getTitle());
        System.out.println("Length: " + this.getLength());
        for (Track track : tracks) {
            track.play();
        }
    }
}
