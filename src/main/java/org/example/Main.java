package org.example;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    private static Scanner input = new Scanner(System.in);
    static void main() {

    menuPrincipal();


    }

    private static void menuPrincipal(){

        int choice=0;
        System.out.println("Welcome to Battle Arena!");
        while (choice!=2)
        {
            System.out.println("What would you like to do ? \n \t 1. Play a game \n \t 2. Quit");
            choice = input.nextInt();
            if (choice==1)
                createGame();
        }

    }

    private static void createGame()
    {
        String player1="";
        String player2="";

        while(player1.equals(player2) || player1.isEmpty() || player2.isEmpty())
        {
            System.out.print("Player 1 name : ");
            player1=input.next();
            System.out.print("Player 2 name (different than Player 1) : ");
            player2=input.next();
        }

        new Game(player1,player2);


    }
}
