package java_training;

import java.util.Scanner;

public class calc3{

    public static float[] get_inp(Scanner scanner){
        System.out.println("Enter first number: ");
        float a = scanner.nextFloat();
        System.out.println("Enter second number: ");
        float b = scanner.nextFloat();
        float inp[] = {a,b};
        scanner.nextLine();
        return inp;
    }

    public static void printOptions(){
        System.out.println("Choose and type in an operation: ");
        System.out.println("Addition");
        System.out.println("Subtraction");
        System.out.println("Multiplication");
        System.out.println("Division");
        System.out.println("Exit");

    }
    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);
        String oper = "";

        while(!oper.equals("Exit") && !oper.equals("exit")){
            printOptions();
            oper = scanner.nextLine();
            float inp[];
            switch (oper){
                case "Addition","addition": 
                    inp = get_inp(scanner);
                    Addition add = new Addition(inp[0], inp[1]); 
                    System.out.println("The answer is: " + add.operate());break;
                case "Subtraction","subtraction":
                    inp = get_inp(scanner);
                    Subtraction sub = new Subtraction(inp[0], inp[1]);
                    System.out.println("The answer is: " + sub.operate());break;
                case "Multiplication","multiplication":
                    inp = get_inp(scanner);
                    Multiplication mul = new Multiplication(inp[0], inp[1]);
                    System.out.println("The answer is: " + mul.operate());break;
                case "Division","division":
                    inp = get_inp(scanner);
                    if  (inp[1] == 0){System.out.println("Don't divide by 0");break;}
                        else{Division div= new Division(inp[0], inp[1]);System.out.println("The answer is: " + div.operate());break; }
                    
                case "Exit", "exit" : break;
                default:
                    System.out.println("\n"+"\n"+"\n"+"Please enter a valid operation");break;
        
            }
        }

        scanner.close();
    }
}