package media;

import java.util.ArrayList;
import java.util.List;

public class Book {
   private int id;
   private String title;
   private String category;
   private float cost;
   private List<String> authors = new ArrayList<String>();
   
   public Book(int id, String title, String category, float cost, List<String> authors) {
    this.id = id;
    this.title = title;
    this.category = category;
    this.cost = cost;
    this.authors = authors;
   }

   // getters and setters
   public int getId() {
    return id;
   }
   public String getTitle() {
    return title;
   }
   public String getCategory() {
    return category;
   }
   public float getCost() {
    return cost;
   }
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
    if (authors.contains(authorName)) {
        authors.remove(authorName);
    }
   }
}
