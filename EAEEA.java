/* 
Author: Antonios F. Takos
Initial Date: May 2nd, 2022
*/
import java.util.*;
import java.lang.*;
// import java.util.function.IntFunction;
public class EAEEA {
    static Scanner input = new Scanner(System.in);
    static int A, B;   // a = numerator / a and b = denominator / b ; a / b
    static int X, Y;
    static int GCD;

    public static void Title_Banner() {
        System.out.println(" \t\t-----------------------------------------------------------------------");
        System.out.println("\t\t|                     Euclidean's Algorithms Program                  |");
        System.out.println("\t\t|                         by: Antonios F. Takos                       |");
        System.out.println(" \t\t-----------------------------------------------------------------------");
        System.out.println(); // line break
    } // <--- Title_Banner() method ends here

    public static void getValues() { // <--- placed inside method for conditional statement's menu recursion
        System.out.print("Please input a value for [A]: ");
        A = input.nextInt();
        System.out.print("Please input a value for [B]: ");
        int temp_B = input.nextInt();
        if(temp_B > A) {
            System.out.println("B MUST be <= A");
            System.out.println("Let's try that again!\n");
            getValues();
        }
        else {
            B = temp_B;
        } 
    } // <--- getValues() method ends here


    public static void Algo_Menu() {
        System.out.println("\nWhich algorithm would you like to run?: ");
        System.out.println("(1): Euclidean Algorithm [EA]");
        System.out.println("(2): EXTENDED Euclidean Algorithm [EEA]");
        System.out.print("\nUSER_CHOICE: ");
        int choice = input.nextInt();
        if(choice == 1) {
            System.out.println("\n------------ Euclidean Algorithm ------------");
    
            GCD = Euclidean_Algorithm(A,B);
            System.out.println("GCD(" + A + "," + B + ") = " + GCD + "\n");
        }
        else if(choice == 2) {
            System.out.println("\n------------ EXTENDED Euclidean Algorithm ------------");
            GCD = EXTENDED_EA(A,B,X,Y);
            System.out.println("\nGCD(" + A + "," + B + ") = " + GCD + "\n");
        }

        else {
            System.out.println("INVALID INPUT. Please try again\n");
            Algo_Menu();
        }

    } // <--- Algo_Menu() method ends here

    public static int Euclidean_Algorithm(int a, int b) {
        System.out.println("("+ a +","+ b +")"); // output: (a,b)
        int quotient = (int)(a / b);
        int remainder = (int)(a % b);
        System.out.println("("+ a + " = " + b + "(" + quotient + ")" + " + " + remainder + ")" + "\n"); // output: (a = b(q) + r)

        if(remainder != 0) {
            return Euclidean_Algorithm(b, remainder);
        }
        else {
            return b;
        }
    } // <--- Euclidean_Algorithm() method ends here

    public static int EXTENDED_EA(int a, int b, int x, int y) {
        System.out.println("This is the start of a method run!");
        System.out.println("a = " + a + ", b = " + b + ", x = " + x + ", y = " + y + "\n");

        if (a == 0) {
            x = 0;
            y = 1;
            return b;
        }
  
        int Xa = 1, Yb = 1; 
        int gcd = EXTENDED_EA(b % a, a, Xa, Yb);
  
  
        System.out.println("The line below the recursive call!");
        x = Yb - (b / a) * Xa;
        y = Xa;

        System.out.println("x = " + x + " y = " + y);
        return gcd;
        
    } // <--- EXTENDED_EA() method ends here

    public static void main(String[] args) {
        Title_Banner();
        System.out.println("\nIn this program you will repeatdely divide the numerator / A with the denominator / B, \nand you will find the Greatest Common Denominator (GCD)\n");
        getValues();
        System.out.println("A = " + A + "\nB = " + B);
        Algo_Menu();
    } // <--- main() method ends here

}// <-- EAEEA{} class ends here