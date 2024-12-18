package hust.soict.cybersec.aims.media;

import java.util.Comparator;

public class MediaComparatorByTitleCost implements Comparator<Media> {
    @Override
    public int compare(Media m1, Media m2) {
        int CostCompare = m1.getCost() < m2.getCost() ? -1 : m1.getCost() > m2.getCost() ? 1 : 0;
        int TitleCompare = m1.getTitle().compareTo(m2.getTitle());
        return (TitleCompare == 0) ? CostCompare : TitleCompare;
    }
}
