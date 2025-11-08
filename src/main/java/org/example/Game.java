package org.example;
import java.util.List;
import java.util.Locale;
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

        String action ="attack";
        List<Character> membersToBeChosen ;
        Character actorCharacter = null;
        Character suffererCharacter = null;
        Player actor=null;
        Player sufferer =null;
        int round = 0;

        while (!player1.isDefeated() && !player2.isDefeated()) {

            System.out.println(stat());

            if ((round% 2)==0)
            {
                actor = player1;
                sufferer = player2;
            }
            else
            {
                actor = player2;
                sufferer = player1;
            }
                actorCharacter=choosingACharacter(actor);
                if (actorCharacter.getTypeName().equals("MAGUS"))
                {
                    action=" heal";
                    sufferer = actor;
                }
                System.out.println("Select whom %s should %s ".formatted(actorCharacter,action));
                suffererCharacter=choosingACharacter(sufferer);
                actorCharacter.action(suffererCharacter);

                round++;
        }

        if (player1.isDefeated())
            System.out.println("%s won in %d rounds".formatted(player2,round/2));
        else
            System.out.println("%s won in %d rounds".formatted(player1,round/2));

        System.out.println(stat());


    }

    private Character choosingACharacter(Player player)
    {
        String chosenMember="";
        Character playingCharacter = null;

        do {
            System.out.println("select a member of %s : ".formatted(player));
            System.out.println(player.aliveMembers());
            chosenMember=input.next().toUpperCase().strip();
        }while(player.findByName(chosenMember)==null);
        for (Character character : player.aliveMembers())
            if (character.getName().equals(chosenMember))
            {
                playingCharacter = character;
                break;
            }

        return playingCharacter;
    }

    private String stat()
    {
        String[] player1Stat =  this.player1.teamStat().toArray( new String[0]);
        String[] player2Stat =  this.player2.teamStat().toArray(new String[0]);
        return "%s \t\t\t\t\t\t\t\t %s \n------- \t\t\t\t\t\t\t ------- \n%s \t\t\t\t\t\t\t\t %s \n%s \t\t\t\t\t\t\t\t %s\n%s \t\t\t\t\t\t\t\t %s ".formatted(player1.toString(),player2.toString(),player1Stat[0],player2Stat[0],player1Stat[1],player2Stat[1],player1Stat[2],player2Stat[2]);
    }
}
