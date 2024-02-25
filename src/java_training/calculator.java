package java_training;

import java.util.Scanner;

public class calculator {

    public static float[] get_inp(Scanner scanner){
        System.out.println("Enter first number: ");
        float a = scanner.nextFloat();
        System.out.println("Enter second number: ");
        float b = scanner.nextFloat();
        float inp[] = {a,b};
        scanner.nextLine();
        return inp;
    }
    public static void main(String[] args) throws Exception {

        Scanner scanner = new Scanner(System.in);
        String oper="";

        while(!oper.equals("Exit") && !oper.equals("exit")){
            System.out.println("Choose and type in an operation: ");
            System.out.println("Addition");
            System.out.println("Subtraction");
            System.out.println("Multiplication");
            System.out.println("Division");
            System.out.println("Exit");

            oper = scanner.nextLine();

            if (!oper.equals("Exit") && !oper.equals("exit")){
                float inp[];
                float ans;
                switch (oper){
                    case "Addition","addition": 
                        inp = get_inp(scanner);
                        ans = inp[0]+inp[1]; 
                        System.out.println("The answer is: " + ans);break;
                    case "Subtraction","substraction":
                        inp = get_inp(scanner);
                        ans = inp[0]-inp[1]; 
                        System.out.println("The answer is: " + ans);break;
                    case "Multiplication","multiplication":
                        inp = get_inp(scanner);
                        ans = inp[0]*inp[1]; 
                        System.out.println("The answer is: " + ans);break;
                    case "Division","division":
                        inp = get_inp(scanner);
                        ans = inp[0]/inp[1]; 
                        System.out.println("The answer is: " + ans);break;
                    default:
                        System.out.println("\n"+"\n"+"\n"+"Please enter a valid operation");break;

                }
            }
        }
        
    }
    
}
