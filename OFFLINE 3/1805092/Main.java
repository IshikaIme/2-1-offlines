import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        while(true) {
            try {
                Expression exp = new Expression();

                System.out.println("Enter your expression: ");
                Scanner sc = new Scanner(System.in);
                System.out.println("Valid expression, Computed value: " + exp.Expressionevaluate(sc.next()));


            } catch (Exception e) {
                System.out.println("Not Valid");
            }
        }

    }
}
