/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package process_package;

/**
 *
 * @author paulo
 */
public class Process {
    
    String studentId;
    String name;
    String course;
    double tuition;
    double paidAmount;
    
    String[] paymentHistory = new String[4];
    int paymentCount = 0;
    
    public Process(String id, String name, String course, double tuition){
        this.studentId = id;
        this.name = name;
        this.course = course;
        this.tuition = tuition;
        this.paidAmount = 0;
    }
    
    
    public void makePayment(double payment){
            
        double balance = tuition - paidAmount;
            
            if (balance == 0){           
                System.out.println("==== YOU ARE ALREADY PAID ====");
                return;
            }
        
            if (payment < 0){
                System.out.println("\n!!!!-INVALID PAYMENT AMOUNT-!!!!");
            }else if (payment > balance){
                System.out.println("\n!!!!-INVALID PAYMENT AMOUNT-!!!!");
                System.out.println("==== REMAINING BALANCE: " + String.format("%.2f",balance) + " ====");
            }else if (payment < tuition/5){
                System.out.println("\n!!!!-LOWEST AMOUNT PAYMENT IS 1/5 OF YOUR TUITION-!!!!");
            }else {
                paidAmount += payment;
                System.out.println("\n==== PAYMENT OF PHP " + String.format("%.2f",payment) + " WAS SUCCESFULL ====");
                System.out.println("==== New Balance: " + newBalance() + " ====");
            }       
            
            if (paymentCount < paymentHistory.length){
                paymentHistory[paymentCount] = "Paid: " + String.format("%.2f",payment);
                paymentCount++;
            }
            

        }
    
    public void makePayment(){
        
        double defaultPayment = tuition / 5;
        
        makePayment(defaultPayment);
        System.out.println("\n==== DEFAULT PAYMENT: " + "(" + String.format("%.2f",defaultPayment) + ")" + " WAS SUCCESFULL ====");
        System.out.println("New Balance: " + String.format("%.2f",newBalance()));
       
    }
    
    public double newBalance(){
        
        double paidBalance = tuition - paidAmount;
        return paidBalance;
    }
    
    public void displayAccount(){
        
        System.out.println("\n==== STUDENT INFORMATION ====");
        System.out.println("\nStudent Name: " + name);
        System.out.println("Student ID: " + studentId);
        System.out.println("Course: " + course);
        System.out.printf("Tuition: %.2f",tuition);
        System.out.printf("\nBalance: %.2f",newBalance());
        System.out.println("");
        
    }
   
    public void showPaymentHistory() {
        
        System.out.println("\n==== PAYMENT HISTORY FOR " + name + " ====");
        if (paymentCount == 0) {
            System.out.println("!!!!- NO PAYMENT MADE YET -!!!!");
        } else {
            for (int i = 0; i < paymentCount; i++) {
                System.out.println(paymentHistory[i]);
            }
        }
    }
}
