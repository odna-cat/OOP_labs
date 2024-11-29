package media;

public abstract class Media extends Object {
    private int id;
    private String title;
    private String category;
    private float cost;

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
}