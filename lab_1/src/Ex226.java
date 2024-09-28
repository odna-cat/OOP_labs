import java.util.Scanner;

public class Equation {
    // In theory using double[] consts is better for larger lists of numbers
    // Only one switch-case statement is needed - in the solving method or in main
    // If doing JOptionPane, use several JTextFields

   public static void main (String[] args) {
    System.out.println("Choose the type of equation you want to solve by entering the corresponding number:\n"
    .concat("1. First degree linear equation\n")
    .concat("2. First degree system of equations with two variables\n")
    .concat("3. Second degree linear equation"));
    
    var input = new Scanner(System.in);
    int opt = input.nextInt();

    switch(opt){
        case(1) ->  {
            System.out.print("a: ");
            double a = input.nextDouble();
            System.out.print("b: ");
            double b = input.nextDouble();

            if (a != 0) {
                double solution = -b / a;
                System.out.printf("The solution is: %f", solution);
            } else {
                if (b == 0) {
                    System.out.print("The solution is all x");
                } else {
                    System.out.print("No solution");
                }
            }
            input.close();
        }

        case(2) ->  {
            // form a11*x1 + a12*x2 = b1; a21*x1 + a22*x2 = b2
            System.out.print("a11: ");
            double a11 = input.nextDouble();
            System.out.print("a12: ");
            double a12 = input.nextDouble();
            System.out.print("b1: ");
            double b1 = input.nextDouble();
            System.out.print("a21: ");
            double a21 = input.nextDouble();
            System.out.print("a22: ");
            double a22 = input.nextDouble();
            System.out.print("b2: ");
            double b2 = input.nextDouble();

            double det = (a11*a22 - a12*a21);
            double det1 = (b1*a22 - b2*a12);
            double det2 = (a11*b1 - a21*b2);
            // I don't like Cramer's Rule, it's personal
            if (det != 0) {
                // Consistent system with unique solution
                double[] solution = {det1/det,det2/det};
                for (double f:solution) System.out.printf("%6.2f",f);
                System.out.println();
            } else {
                if (det1 == 0 || det2 == 0){
                    System.out.println("Infinite solutions");
                } else {
                    System.out.println("No solutions");
                }
            }
            input.close();
        }
        case(3) ->  {
            // form ax^2 + bx + c = 0
            System.out.print("a: ");
            double a = input.nextDouble();
            System.out.print("b: ");
            double b = input.nextDouble();
            System.out.print("c:");
            double c = input.nextDouble();

            if (a != 0) {
                double dis = b*b - 4*a*c;
                // discriminant cases
                if (dis < 0) {
                    System.out.println("No solution");
                } if (dis == 0) {
                    double solution = -b / (2*a);
                    System.out.printf("The solution is %f", solution);
                } else {
                    double x1 = ((-b) + Math.sqrt(dis))/(2*a);
                    double x2 = ((-b) - Math.sqrt(dis))/(2*a);
                    System.out.print("The solutions are "+ x1 + " and " + x2);
                }
            } else {
                // a repeat of ax + b = 0
                if (b != 0) {
                    double solution = -c / b;
                    System.out.printf("The solution is: %f", solution);
                } else {
                if (c == 0) {
                    System.out.print("The solution is all x");
                } else {
                    System.out.print("No solution");
                    }
                }
            }
            input.close();
        }
        default ->  {
            System.out.println("You did not enter a valid value. Try again.");
            input.close();
        }
    }
   } 
}