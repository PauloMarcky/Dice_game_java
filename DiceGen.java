/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dice_generator;
import java.util.Random;
import java.util.Scanner;
import com.mycompany.main.Main;
/**
 *
 * @author paulo
 */
public class DiceGen {
    
    public int firstDice;
    public int secondDice;
    public int result;
    public static int newMoney;
    public static int bet;
    
    public void eMoney (String username, int balance ){
        System.out.print("\nWELCOME " + username);
        System.out.print("\nBalance: " + balance + " Php");
    }
    
    public int  userBet (){
        
        Scanner input = new Scanner(System.in);
        
        System.out.print("\n\nEnter Bet: ");
        bet = input.nextInt();
        
        return bet;
        
    }
    
    public String diceResult(String[] dices){
        
        Random rand = new Random();
        
        firstDice = rand.nextInt(6) + 1;
        secondDice = rand.nextInt(6) + 1;
        result = firstDice + secondDice;
        
        String DiceResults = "DICE 1: " + dices[firstDice - 1] + "\n" + "DICE 2: " + dices[secondDice - 1];

        return DiceResults;
        
    }
    
    public String Identifier(int bet){
        
        String wonStatement = "YOU WON!";
        String loseStatement = "BETTER LUCK NEXT TIME!";
        
        if (result % 2 == 0){
            int wonMoney = bet * 2;
            Main.money += wonMoney;
            return wonStatement;
        }else{           
            Main.money -= bet;
            return loseStatement;
        }
        
    }
    
    public void resultMoney(){
        System.out.print("Balance: " + Main.money + "\n----------------------------------------------------------------------");
    }
    
}
