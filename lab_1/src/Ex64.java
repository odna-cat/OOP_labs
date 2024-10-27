import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
public class DaysOfMonth {
    public static boolean isLeap (int year) {
        if (year % 4 != 0) {
            return false;
        } if (year % 100 == 0 && year % 400 != 0) {
            return false;
        } else {return true;}
    }
    public static void monthDays (String month, int year) {
        List<String> jan = Arrays.asList("January","Jan.","Jan","1");
        List<String> feb = Arrays.asList("February","Feb.","Feb","2");
        List<String> mar = Arrays.asList("March","Mar.","Mar","3");
        List<String> apr = Arrays.asList("April","Apr.","Apr","4");
        List<String> may = Arrays.asList("May", "5");
        List<String> jun = Arrays.asList("June","Jun.","Jun","6");
        List<String> jul = Arrays.asList("July","Jul.","Jul","7");
        List<String> aug = Arrays.asList("August","Aug.","Aug","8");
        List<String> sep = Arrays.asList("September", "Sep.", "Sep","9");
        List<String> oct = Arrays.asList("October","Oct.","Oct","10");
        List<String> nov = Arrays.asList("November","Nov.","Nov","11");
        List<String> dec = Arrays.asList("December","Dec.","Dec","12");

         List<List<String>> thirty = Arrays.asList(apr,jun,sep,nov);
         List<List<String>> thirtyOne = Arrays.asList(jan,mar,may,jul,aug,oct,dec);

         List<String> flat30 = new ArrayList<>();
         thirty.forEach(flat30::addAll);
         List<String> flat31 = new ArrayList<>();
         thirtyOne.forEach(flat31::addAll);

        if (feb.contains(month)) {
            if (isLeap(year)) {
                System.out.println("29");
            } else {
                System.out.println("28");
            }
         } if (flat30.contains(month)) {
                System.out.println("30");
         } if (flat31.contains(month)) {
                System.out.println("31");
            }
        }
    public static void main(String[] args) throws Exception {
        var input = new Scanner(System.in);
        String month = input.nextLine(); // returns String
        int year = input.nextInt();
        monthDays(month,year); 
        input.close();
    }
}
