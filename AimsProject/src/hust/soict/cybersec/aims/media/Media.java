package hust.soict.cybersec.aims.media;

import java.util.Comparator;

public abstract class Media extends Object {
    private final int id;
    private String title;
    private String category;
    private float cost = 0;
    private static int idCounter = 0;

    public Media(String title, String category, float cost) {
        idCounter++;
        this.id = idCounter;
        this.title = title;
        this.category = category;
        this.cost = cost;
    }

    public Media(String title) {
        idCounter++;
        this.id = idCounter;
        this.title = title;
    }

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

    public void setTitle(String newTitle) {
        this.title = newTitle;
    }

    public void setCategory(String newCategory) {
        this.category = newCategory;
    }

    public void setCost(float newCost) {
        this.cost = newCost;
    }

    public boolean isMatch(String title) {
        return title.equals(this.title);
    }

    @Override
    public boolean equals(Object obj) {
        Media media = (Media) obj;
        return (obj instanceof Media && isMatch(media.getTitle()));
    }

    @Override
    public final int hashCode() {
        return this.id;
        // Over-simplified
    }

    public static final Comparator<Media> COMPARE_BY_TITLE_COST = new MediaComparatorByTitleCost();
    public static final Comparator<Media> COMPARE_BY_COST_TITLE = new MediaComparatorByCostTitle();
}