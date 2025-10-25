/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package process_package;
import java.util.Scanner;
/**
 *
 * @author paulo
 */
public class TuitionManager {
    
    Process s1 = new Process("001", "Balaba | Marcky Paulo", "BSIT", 25000.00);
    Process s2 = new Process("002", "Garma | Jescy Ann", "BSN", 32000.00);
    Process s3 = new Process("003", "Legaspi | Apriljoy", "BSN", 32000.00);
    Process s4 = new Process("004", "Manuel | Lawrence", "BSA", 25000.00);
    Process s5 = new Process("005", "Santos | Albertjan", "BSCE", 27000.00);
   
    Scanner userInput = new Scanner(System.in);
    
    public void startingPoint(){
       
        int choice;
        
        do{
            System.out.println("\n~~~~CHOOSE A COMMAND~~~~");
            System.out.println("1) Show Profile Details");
            System.out.println("2) Make Payment");
            System.out.println("3) Payment History");
            System.out.println("4) Exit");
            System.out.print("Enter choice: ");
            
            while(!(userInput.hasNextInt())){
                System.out.println("\n!!!!-PLEASE ENTER A VALID NUMBER-!!!!\n");
                userInput.next();
                System.out.print("Enter choice: ");
            }

            choice = userInput.nextInt();
            userInput.nextLine(); //eto and taga kuha or consume ng newline
            
            
            switch (choice){
        
                case 1 -> studentInfoDisplay();
                
                case 2 -> payTuition();
                
                case 3 -> viewPaymentHistory();
                
                default -> System.out.println("\n!!!!-INVALID CHOICE: TRY AGAIN-!!!!\n");
        
        }
            
            
        }while(choice != 4);
    
        
        }
    
    private Process findMatchId(){
        
        System.out.print("\nEnter you Student ID: ");
        String inputId = userInput.nextLine();
        
        if (inputId.equals(s1.studentId)) return s1;
        if (inputId.equals(s2.studentId)) return s2;
        if (inputId.equals(s3.studentId)) return s3;
        if (inputId.equals(s4.studentId)) return s4;
        if (inputId.equals(s5.studentId)) return s5;
        
        System.out.println("\n!!!!-ERROR: STUDENT NOT FOUND-!!!!");
        return null;
        
    }
    
    private void studentInfoDisplay(){
        
        Process student = findMatchId();
        
        if(student == null)return;
        
        student.displayAccount();

    }
    
    private void payTuition(){
        
        Process student = findMatchId();
        
        if(student == null)return;
        
            int choicePayment;

            System.out.println("\n~~~~CHOOSE PAYMENT~~~~\n");
            System.out.println("1) Custom Amount");
            System.out.println("2) Default Payment (1/5 of tuition)");
            System.out.print("Enter payment method: ");

            while(!(userInput.hasNextInt())){

                    System.out.println("\n!!!!-PLEASE ENTER A VALID NUMBER-!!!!\n");
                    userInput.next();
                    System.out.print("Enter choice: ");
                }

            choicePayment = userInput.nextInt();
            userInput.nextLine(); //consumes the leftover newline made from the previous input



            switch (choicePayment){

                case 1 -> {
                    
                            System.out.print("Enter pay amount: ");
                            while (!(userInput.hasNextDouble())) {
                                System.out.println("!!!!-PLEASE ENTER A VALID NUMBER-!!!!");
                                userInput.next();
                            }
                            double pay = userInput.nextDouble();
                            userInput.nextLine();
                            
                            student.makePayment(pay);
                    
                          }
                case 2 -> student.makePayment();                
                
                default -> System.out.println("\n!!!!-INVALID PAYMENT CHOICE: TRY AGAIN-!!!!\n");
            
        }
    }
    
    private void viewPaymentHistory() {
        
        Process student = findMatchId();
        
        if (student == null)return; 
            
        student.showPaymentHistory();
        
    }
      
}
