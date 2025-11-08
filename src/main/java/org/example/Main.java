package org.example;
import java.util.ArrayList;
import java.util.List;
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
        String[] player_names = {"",""};
        Player[] players ={null,null};
        Character[] characters = {null,null,null,null,null,null};

        for (int i=0;i<2;i++)
        {
            System.out.print("Player %d name (unique) : ".formatted(i+1));
            player_names[i]=input.next().toUpperCase().strip();
            if(i==1 && player_names[i].equals(player_names[i-1]))
            {
                i-=1;
                continue;
            }
            System.out.println("Choosing character for %s".formatted(player_names[i]));
            choosingCharacter(characters,i);
            players[i]=new Player(player_names[i],List.of(characters[i*3],characters[i*3+1],characters[i*3+2]));

        }
        new Game(players[0],players[1]);



    }

    private static void choosingCharacter(Character[] alreadyPresent,int playerPosition)
    {
    List<String> availableType = new ArrayList<>(List.of("WARRIOR","MAGUS","COLOSSUS","DWARF"));
    boolean uniqueName = true;
        for(int i = 0 ; i < 3 ; i++)
        {
            String choosenName ="";
            String choosenType ="";
            do
            {
                uniqueName = true;
                System.out.print("Character name (unique) no %d:".formatted(i+1));
                choosenName=input.next().toUpperCase().strip();
                for (Character character : alreadyPresent)
                    if( character != null && character.getName().equals(choosenName))
                    {
                        uniqueName= false;
                         break;
                    }
            }while(!uniqueName);

            System.out.println("Available Type ");
            for(String type :availableType)
                System.out.println("\t %s".formatted(type));
            do{
                System.out.print("%s  type : ".formatted(choosenName));
                choosenType=input.next().toUpperCase().strip();
            }while(!availableType.contains(choosenType));
            availableType.remove(choosenType);
            Character c = switch (choosenType) {
                case "WARRIOR"  -> new Warrior(choosenName);
                case "COLOSSUS" -> new Colossus(choosenName);
                case "MAGUS"    -> new Magus(choosenName);
                case "DWARF"    -> new Dwarf(choosenName);
                default -> throw new IllegalArgumentException("unknown Type: " + choosenType);
            };
            alreadyPresent[playerPosition*3+i]=c;
        }
    }
}
