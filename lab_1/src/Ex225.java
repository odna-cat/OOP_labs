/* 
2.2.5 Write a program to calculate sum, difference, product, and quotient of 2 double numbers
which are entered by users.
*/
import javax.swing.JOptionPane;
public class Calculator {
    public static void main (String[] args) {
        String strNum1, strNum2, strOperator;

        strNum1 = JOptionPane.showInputDialog(null, "Input the first number: ",
        "Input the first number", JOptionPane.INFORMATION_MESSAGE);
        strNum2 = JOptionPane.showInputDialog(null, "Input the second number: ",
        "Input the second number", JOptionPane.INFORMATION_MESSAGE);
        strOperator = JOptionPane.showInputDialog(null, "Enter the operator: ", "Input the operation",
        JOptionPane.INFORMATION_MESSAGE);

        double num1 = Double.parseDouble(strNum1);
        double num2 = Double.parseDouble(strNum2);
        double result = 0;
        char op = strOperator.charAt(0);
        
        boolean invalidDivision = (op == '/' && num2 == 0.0);
        boolean invalidOperator = false;

        // This series of switch-case statements is held together with duct tape
        // At least it works

        if (invalidDivision == false) {
            switch(op) {
                case '+' -> result = num1 + num2;
                case '-' -> result = num1 - num2;
                case '*' -> result = num1 * num2;
                case '/' -> result = num1 / num2;
                default -> invalidOperator = true;
            }
            if (invalidOperator == true) {
                JOptionPane.showMessageDialog(null, "You did not enter a valid operator, try again.");}
            if (invalidOperator == false) {
                JOptionPane.showMessageDialog(null, result, "Your result is: ", JOptionPane.INFORMATION_MESSAGE);}
        } else {
            JOptionPane.showMessageDialog(null, "You cannot divide by zero, try again.");
        }
        
        System.exit(0);
        
    }
}