import java.util.Scanner;

public class Main {

    public static void main(String []args) {

        Scanner sc = new Scanner(System.in);

        final int field = 11;
        int minionsLinks, minionsRechts, gezogenLinks = 0, gezogenRechts = 0, norbert;
        String whosTurn = " ";

        int playerCounter = 0, cpuCounter = 0, counter = 0;

        String direction = " ";
        int numMinions = 0;

        double randomDirection;

        double coin = (Math.random() * 10);
        if (coin < 5)
            whosTurn = "p";
        else
            whosTurn = "c";

        norbert = (int) (Math.random() * 12);
        minionsRechts = field - norbert;
        minionsLinks = norbert - 1;
        System.out.println("Mission without Norbert!\n");
        playingField(norbert, minionsRechts, minionsLinks, gezogenRechts, gezogenLinks);
        System.out.println("\n");
        System.out.println("PlayerTeam: " + playerCounter + " Minions");
        System.out.println("CpuTeam: " + cpuCounter + " Minions");

        while (counter <= 11) {

            numMinions = 0;
            if (whosTurn == "p") {
                System.out.println("---");
                System.out.println("Its your Turn!");

                System.out.println("From which side will you pick? (l)eft or (r)ight");
                do {
                    direction = sc.nextLine();
                    if (!(direction.toLowerCase() == "r" || direction.toLowerCase() == "l")) {
                        System.out.println("Invalid input, please try again\n");
                    }
                } while (!(direction == "r" || direction == "l"));
                System.out.println("How many minions shall be picked");

                do {
                    numMinions = sc.nextInt();
                    if (!(numMinions >= 1 && numMinions <= 3 || numMinions + counter > 10))
                        System.out.println("Invalid input, please try again\n");
                } while (!(numMinions >= 1 && numMinions <= 3) || numMinions + counter > 10);
                playerCounter += numMinions;
            } else if (whosTurn == "c") {
                System.out.println("---");
                System.out.println("Computers turn!");

                do {
                    if (minionsLinks == 0)
                        direction = "r";
                    else if (minionsRechts == 0)
                        direction = "l";
                    else {
                        randomDirection = (Math.random());
                        if (randomDirection < 0.5) {
                            direction = "l";
                            System.out.println("\nComputer chooses left");
                        } else if (randomDirection >= 0.5) {
                            direction = "r";
                            System.out.println("\nComputer chooses right");
                        }
                    }

                    if (direction == "r") {
                        if (minionsRechts >= 3)
                            numMinions = 3;
                        else if (minionsRechts >= 2)
                            numMinions = 2;
                        else if (minionsRechts >= 1)
                            numMinions = 1;
                        else
                            numMinions = 1;
                    } else if (direction == "l") {
                        if (minionsLinks >= 3)
                            numMinions = 3;
                        else if (minionsLinks >= 2)
                            numMinions = 2;
                        else if (minionsLinks >= 1)
                            numMinions = 1;
                        else
                            numMinions = 1;
                    }
                    System.out.println("\nDer Computer nimmt " + numMinions + " Minion(s) in sein Team\n");
                } while (!(direction == "r" || direction == "l"));
                cpuCounter += numMinions;
            }

            if (direction == "l") {
                gezogenLinks = gezogenLinks + numMinions;
                minionsLinks = minionsLinks - numMinions;
            } else if (direction == "r") {
                gezogenRechts = gezogenRechts + numMinions;
                gezogenRechts = gezogenRechts - numMinions;
            }
            counter = playerCounter + cpuCounter;

            if(whosTurn == "p")
                whosTurn = "c";
            else if(whosTurn == "c")
                whosTurn = "p";

            if(minionsLinks == 0 && minionsRechts == 0){
                System.out.println("The game is over!");
                if(whosTurn == "p")
                    System.out.println("Player has Norbert in their team!\n");
                else
                    System.out.println("Computer has Norbert in their team!\n");
                counter = 12;
            } else if (minionsLinks < 0 || minionsRechts < 0){
                if(direction == "r")
                    playerCounter += minionsRechts;
                else
                    playerCounter += minionsLinks;
                System.out.println("The game is over!");
                System.out.println("Player has Norbert in their team!\n");
                counter = 12;
            }

            playingField(norbert, minionsRechts, minionsLinks, gezogenRechts, gezogenLinks);
            System.out.println("\n");
            System.out.println("Player team: " + playerCounter + " Minions");
            System.out.println("Computer team: " + cpuCounter + " Minions\n");
        }


    }

    public static void playingField(int norbert,int minionRechts,int minionLinks,int gezogenRechts,int gezogenLinks){
        for (int i = 0; i < gezogenLinks; i++)
            System.out.print("- ");
        for (int i = 0; i < minionLinks; i++)
            System.out.print("M ");
        System.out.print("O ");
        for (int i = 0; i < minionRechts; i++)
            System.out.print("M ");
        for (int i = 0; i < gezogenRechts; i++)
            System.out.print("- ");
    }
}
