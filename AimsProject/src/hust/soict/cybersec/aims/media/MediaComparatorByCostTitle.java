package hust.soict.cybersec.aims.media;

import java.util.Comparator;

public class MediaComparatorByCostTitle implements Comparator<Media> {
    @Override
    public int compare(Media m1, Media m2) {
        int CostCompare = m1.getCost() < m2.getCost() ? -1 : m1.getCost() > m2.getCost() ? 1 : 0;
        int TitleCompare = m1.getTitle().compareTo(m2.getTitle());
        return (CostCompare == 0) ? TitleCompare : CostCompare;
    }
}