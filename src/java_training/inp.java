package java_training;

import java.util.Scanner;

public class inp {
    public static void main(String[] args) throws Exception {

        Scanner scanner = new Scanner(System.in); // <- not an actual input

        int inpInt = scanner.nextInt(); // <- input is happenning here

        System.out.println(inpInt);

        scanner.nextLine();
        // Scanner does not get rid of the \n character after scanning for int
        // so we have to do it manually, scan it

        String inpStr = scanner.nextLine();
        System.out.println(inpStr);

        scanner.close();
    }
}
