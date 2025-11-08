package org.example;

import java.util.Objects;

public class Game {

    private Player player1;
    private Player player2;


    public Game(Player player1, Player player2) {
        //TO DO Verification unicite des noms du jeu et des types par equipe
        this.player1 = player1;
        this.player2 = player2;
        play();
    }

    public  void  play (){
        // TO DO - logique du jeu
    }
}
