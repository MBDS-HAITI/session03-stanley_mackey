package org.example;
import java.util.Scanner;

import java.util.Objects;

public class Game {

    private Player player1;
    private Player player2;
    private static Scanner input = new Scanner(System.in);


    public Game(Player player1, Player player2) {
        //TO DO Verification unicite des noms du jeu et des types par equipe
        this.player1 = player1;
        this.player2 = player2;
        System.out.println("Beginning the game");
        play();
    }

    private void play() {
        while ()
        System.out.println(stat());
    }

    private String stat()
    {
        String[] player1Stat =  this.player1.teamStat().toArray( new String[0]);
        String[] player2Stat =  this.player2.teamStat().toArray(new String[0]);
        return "%s \t\t\t\t\t\t\t\t %s \n------- \t\t\t\t\t\t\t ------- \n%s \t\t\t\t\t\t\t\t %s \n%s \t\t\t\t\t\t\t\t %s\n%s \t\t\t\t\t\t\t\t %s ".formatted(player1.toString(),player2.toString(),player1Stat[0],player2Stat[0],player1Stat[1],player2Stat[1],player1Stat[2],player2Stat[2]);
    }
}
