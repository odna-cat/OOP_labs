package lab01;
import java.util.Scanner;
import java.util.Arrays;

public class Ex225 {
    public static void main(String[] args) {
        // constant array
        int[] arr = {357643,4555,3256,35643,55677,321};
        /*
         * //For user-defined arrays
         * Scanner inp = new Scanner(System.in);
         * String userInp = inp.readline();
         * String[] sUserArr = str.split(" ") // this assumes the delimiter is whitespace
         * int[] userArr = new ArrayList<>();
         * for (String temp : sUserArr) {
         * userArr.add(Integer.parseInt(temp);)
         * }
        */ 
        System.out.print("Given numeric array: ");
        for (int n : arr) {System.out.print(n + " ");}
        Arrays.sort(arr);
        System.out.print("\nSorted array: ");
        for (int n : arr) {System.out.print(n + " ");}
        int sum = 0;
        for (int n : arr) {sum += n;}
        System.out.println("\nSum of array: " + sum);
        int avg = sum / arr.length;
        System.out.println("Average of array: " + avg);
    }    
}
