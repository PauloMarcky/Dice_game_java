/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.main;
import dice_generator.DiceGen;
import java.util.Scanner;

/**
 *
 * @author paulo
 */
public class Main {
    
    public static int money;
    public static int bet;
    
    public static void main(String[] args) {
        
        String[] stringDices = {"1","2","3","4","5","6"};
        Scanner input = new Scanner(System.in);
        
        System.out.print("Enter Username: ");
        String username = input.nextLine();
        
        System.out.print("Withdraw amount: ");
        money = input.nextInt();
        
        DiceGen player = new DiceGen();
        
        while(bet < money){
            player.eMoney(username, money);

            bet = player.userBet();

            String yourDice = player.diceResult(stringDices);
            System.out.println(yourDice); 

            String result = player.Identifier(bet);
            System.out.println("\n" + result);

            player.resultMoney();
        }
        
    }
}
