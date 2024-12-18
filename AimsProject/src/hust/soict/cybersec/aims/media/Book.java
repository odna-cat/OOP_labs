package hust.soict.cybersec.aims.media;

import java.util.ArrayList;
import java.util.List;

public class Book extends Media {
    private List<String> authors = new ArrayList<>();

    public Book(String title, String category, float cost, List<String> authors) {
        super(title, category, cost);
        this.authors = authors;
    }

    public Book(String title) {
        super(title);
    }

    // getters and setters
    public List<String> getAuthors() {
        return authors;
    }

    // actual methods
    public void addAuthor(String authorName) {
        if (!authors.contains(authorName)) {
            authors.add(authorName);
        }
    }

    public void removeAuthor(String authorName) {
        if (authors.contains(authorName))
            authors.remove(authorName);
    }

    @Override
    public String toString() {
        return "Title: " + this.getTitle() + " - Category: " + this.getCategory()
                + " - Authors: " + this.authors.toString() + "- Cost: " + this.getCost();
    }
}
