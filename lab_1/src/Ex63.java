import java.util.Scanner;

public class TriangleOfStars {
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        int h = inp.nextInt();
        inp.close();

        for (int i=0;i<h;i++) {
            for (int j=0;j<h-i-1;j++) {System.out.print(" ");}
            for (int k=0;k<(2*i+1);k++) {System.out.print("*");}
            System.out.print("\n");
        }
    }
}
