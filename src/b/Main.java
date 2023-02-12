package b;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        PasswordChecker passwordChecker = new PasswordChecker();
        passwordChecker.add(new RequireLowercaseCharacter());
        passwordChecker.add(new MinimumLengthRequirement(3));
        passwordChecker.add(new MaximumLengthRequirement(20));
        passwordChecker.add(new RequireUppercaseCharacter());
        passwordChecker.add(new RequireSpecialCharacter());
        passwordChecker.add(new RequireNumber());

        System.out.println("Enter password: ");
        String password = in.nextLine();

        try {
            passwordChecker.check(password);
            System.out.println("Password is strong enough");
        } catch (Exception e) {
            System.out.println("Password is not strong enough: " + e.getMessage());
        }
    }
}