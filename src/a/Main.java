package a;

import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        MyScanner myScanner = new MyScanner(new InputStreamReader(System.in));
        try {
            System.out.print("Enter a string: ");
            String str = myScanner.nextLine();
            System.out.println("You entered: " + str);

            System.out.print("Enter an integer: ");
            int num = myScanner.nextInt();
            System.out.println("You entered: " + num);

            System.out.print("Enter a double: ");
            double d = myScanner.nextDouble();
            System.out.println("You entered: " + d);

            System.out.print("Enter a MyClass (format: a,b): ");
            MyScanner.MyClass myClass = myScanner.nextMyClass();
            System.out.println("You entered: " + myClass);
        } catch (IOException e) {
            System.out.println("Error reading input: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Error parsing number: " + e.getMessage());
        } catch (MyScanner.MyClassFormatException e) {
            System.out.println("Error parsing MyClass: " + e.getMessage());
        }
    }
}
