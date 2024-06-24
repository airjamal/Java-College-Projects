import java.awt.*;
import java.util.Scanner;

public class main {
    //	Map1

    public static String[][] lab = { { "�", "�", "�", "�", "�", "�", "�", "�", "�", "�", "�", "�", "�" },
            { "�", ".", ".", ".", ".", ".", "�", "�", ".", ".", ".", ".", "�" },
            { "�", ".", "�", "�", "�", ".", ".", "�", ".", ".", "�", ".", "�" },
            { "�", ".", ".", ".", "�", "�", ".", "�", "�", ".", "�", ".", "." },
            { "�", "�", "�", ".", "�", ".", ".", ".", ".", ".", "�", ".", "�" },
            { "�", ".", ".", ".", "�", "�", ".", "�", "�", ".", "�", ".", "�" },
            { "�", ".", "�", "�", ".", ".", ".", "�", ".", ".", "�", ".", "�" },
            { ".", ".", "�", ".", ".", "�", ".", "�", ".", "�", "�", ".", "�" },
            { "�", "�", "�", "�", "�", "�", "�", "�", "�", "�", "�", "�", "�" }, };

//	Map2

    public static String[][] lab2 = { { "�", "�", "�", "�", "�", "�", "�" }, { ".", ".", "�", ".", ".", ".", "�" },
            { "�", ".", ".", ".", "�", ".", "�" }, { "�", ".", "�", ".", "�", ".", "�" },
            { "�", ".", "�", "�", "�", ".", "�" }, { "�", ".", ".", "�", ".", ".", "." },
            { "�", "�", "�", "�", "�", "�", "�" },

    };

//	Map3

    public static String[][] lab3 = { { "�", "�", "�", "�", "�", "�", "�", "�", "�", "�", "�", "�", "�", "�", "�" },
            { "�", ".", ".", "�", ".", ".", ".", ".", ".", ".", ".", ".", "�", ".", "�" },
            { "�", "�", ".", "�", ".", "�", "�", "�", ".", "�", "�", ".", "�", ".", "�" },
            { "�", ".", ".", "�", ".", ".", ".", "�", ".", ".", "�", ".", ".", ".", "�" },
            { "�", ".", "�", "�", ".", ".", "�", "�", "�", "�", "�", ".", "�", "�", "�" },
            { "�", ".", "�", "�", "�", ".", ".", "�", ".", ".", "�", ".", "�", ".", ".",},
            { ".", ".", ".", ".", "�", "�", ".", "�", "�", ".", "�", ".", "�", ".", "�" },
            { "�", ".", "�", ".", ".", ".", ".", ".", ".", ".", "�", ".", ".", ".", "�" },
            { "�", ".", "�", ".", "�", "�", ".", "�", "�", ".", "�", ".", "�", ".", "�" },
            { "�", ".", "�", "�", "�", "�", ".", "�", ".", ".", "�", ".", "�", ".", "�" },
            { "�", ".", ".", ".", "�", ".", ".", "�", ".", "�", "�", ".", "�", ".", "�" },
            { "�", "�", "�", "�", "�", "�", "�", "�", "�", "�", "�", "�", "�", "�", "�" }, };

    // Wird verwendet, um die Richtung des Algorithmus zu speichern und zu �ndern

    public static String[] richtung = { "^", ">", "v", "<" };

    public static int richtungIndex;

    public static String vorwaerts; // String-Darstellung der aktuellen Richtung

    public static int schritte; // Fuer die Aufzaehlung der Schritte im Labyrinth.

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int kartenAuswahl;
        System.out.println("Welches Labyrinth soll BB-8 durchlaufen?");
        System.out.println("\nStandard Labyrinth (1), kleines Labyrinth (2) oder gro�es Labyrinth (3)");

        do {
            kartenAuswahl = sc.nextInt();
            if (kartenAuswahl == 1) {
                lab = lab;
                Point startingPoint = new Point(0, 7);
                Point exit = new Point(0, 12);
                richtungIndex = 1; // Startpunktrichtung East.
                vorwaerts = richtung[richtungIndex];
                bb8Navigierung(startingPoint, exit);
                schritte = -1; // Erste Iteration wird als Iteration 0 angezeigt.
            } else if (kartenAuswahl == 2) {
                lab = lab2;
                Point startingPoint = new Point(0, 2);
                Point exit = new Point(0, 6);
                richtungIndex = 1; // Startpunktrichtung East.
                vorwaerts = richtung[richtungIndex];
                bb8Navigierung(startingPoint, exit);
                schritte = -1; // Erste Iteration wird als Iteration 0 angezeigt.
            } else if (kartenAuswahl == 3) {
                lab = lab3;
                Point startingPoint = new Point(0, 6);
                Point exit = new Point(0, 14);
                richtungIndex = 1; // Startpunktrichtung East.
                vorwaerts = richtung[richtungIndex];
                bb8Navigierung(startingPoint, exit);
                schritte = -1; // Erste Iteration wird als Iteration 0 angezeigt.
            } else
                System.out.println("Eingabe Fehlerhaft! Bitte nochmal Versuchen");
        } while (kartenAuswahl < 1 || kartenAuswahl > 3);
    }

    // Vorherige Festlegung: Point p ist ein Punkt und keine Wand im Labyrinth

    /**
     * Navigierung des Labyrinths mit der Rechten-Hand-Regel bis der Ausgang gefunden wurde
     */

    public static void bb8Navigierung(Point p, Point exit) // Loesung des Labyrinth
    {

        // Zeichensetzung

        if (vorwaerts.equals("^")) // North
            lab[p.y][p.x] = "^";

        else if (vorwaerts.equals(">")) // East
            lab[p.y][p.x] = ">";

        else if (vorwaerts.equals("v")) // South
            lab[p.y][p.x] = "v";

        else // West
            lab[p.y][p.x] = "<";

        schritte++; // Aufzaehlung der Schritte von BB-8

        try // Weg-Animierung
        {
            Thread.sleep(200);  // 200 ms bis zum naechsten Schritt
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        for (int i = 0; i < 100; ++i) // Zeigt in der Console den letzten gemachten Schritt der Navigierung an
            System.out.println();

        // Ausgang/R2-D2 gefunden

        if (isExit(p, exit)) // basis
        {

            lab[p.y][p.x] = "A"; // 'A' wenn Ausgang gefunden wurde

            System.out.println("BB-8 hat R2-D2 gefunden!!!\n");

            printLabyrinth(lab, lab, true);

            System.out.println();

            System.out.println("\nAusgang in " + schritte + " Schritten gefunden.");

        } else {
            System.out.println("BB-8 sucht nach R2-D2...\n");

            System.out.println("Schritte: " + schritte);

            printLabyrinth(lab,lab,false);

            System.out.println("\nDerzeitige Richtung: " + vorwaerts);

            // Rechte-Hand-Methode

            if (lookRight(p) != "�") {
                turnRight();
                moveForward(p);
                bb8Navigierung(p, exit);
            } else if (lookForward(p) != "�") {
                moveForward(p);
                bb8Navigierung(p, exit);
            } else if (lookLeft(p) != "�") {
                turnLeft();
                moveForward(p);
                bb8Navigierung(p, exit);
            } else // Dead End
            {
                turnRight();
                turnRight();
                moveForward(p);
                bb8Navigierung(p, exit);
            }
        }
    }

    public static void turnRight() // Rechte Drehung Methode
    {
        richtungIndex = (richtungIndex + 1) % 4;

        vorwaerts = richtung[richtungIndex];
    }

    public static void turnLeft() // Linke Drehung Methode
    {
        richtungIndex = (richtungIndex + 3) % 4;

        vorwaerts = richtung[richtungIndex];
    }

    /**
     * Basierend auf die Forwaertrichtung und den derzeitigen Punkt, bestimmt diese
     * Methode was direkt danach kommt.
     * @return Charakter der derzeitig in Richtung rechts ist
     */

    public static String lookRight(Point p) // Rechte Sichtdrehung
    {
        if (vorwaerts.equals("^")) // North
            return lab[p.y][p.x + 1];

        else if (vorwaerts.equals(">")) // East
            return lab[p.y + 1][p.x];

        else if (vorwaerts.equals("v")) // South
            return lab[p.y][p.x - 1];

        else // West
            return lab[p.y - 1][p.x];
    }

    /**
     * Basierend auf die Forwaertrichtung und den derzeitigen Punkt, bestimmt diese
     * Methode was direkt danach kommt.
     * @return Charakter der derzeitig in Richtung vorn ist
     */

    public static String lookForward(Point p) // Frontale Sichtdrehung
    {
        if (vorwaerts.equals("^")) // North
            return lab[p.y - 1][p.x];

        else if (vorwaerts.equals(">")) // East
            return lab[p.y][p.x + 1];

        else if (vorwaerts.equals("v")) // South
            return lab[p.y + 1][p.x];

        else // West
            return lab[p.y][p.x - 1];
    }

    /**
     * Basierend auf die Forwaertrichtung und den derzeitigen Punkt, bestimmt diese
     * Methode was direkt danach kommt.
     * @return Charakter der derzeitig in Richtung links ist
     */

    public static String lookLeft(Point p) // Linke Sichtdrehung
    {
        if (vorwaerts.equals("^")) // North
            return lab[p.y][p.x - 1];

        else if (vorwaerts.equals(">")) // East
            return lab[p.y - 1][p.x];

        else if (vorwaerts.equals("v")) // South
            return lab[p.y][p.x + 1];

        else // West
            return lab[p.y + 1][p.x];
    }

    /**
     * Basierend auf die Forwaertsrichtung, veraendert diese Methode die x-/y-Werte
     * von Point p um dann eine Position nach vorne zu gehen und markiert dann die
     * vorherige Position
     */

    public static void moveForward(Point p) // Point p wird eine Postion nach vorne bewegt
    {

        if (vorwaerts.equals("^")) // North
            p.y--;

        else if (vorwaerts.equals(">")) // East
            p.x++;

        else if (vorwaerts.equals("v")) // South
            p.y++;

        else // West
            p.x--;
    }

    /**
     * Basierend auf die Forwaertsrichtung, bestimmt diese Methode ob der derzeitige
     * Punkt ein Ausgang ist oder nicht.
     */
    public static boolean isExit(Point p, Point exit) // Bestimmt ob Point p am Ausgang ist oder
    // nicht
    {

// Kombiniert die Richtung und Waende des Labyrinth um den Ausgang zu bestimmen

        if (vorwaerts.equals("^") && p.y == exit.x)
            return true;

        else if (vorwaerts.equals(">") && p.x == exit.y)
            return true;

        else if (vorwaerts.equals("v") && p.y == exit.y)
            return true;

        else if (vorwaerts.equals("<") && p.x == exit.x)
            return true;
        else
            return false;
    }

    public static void printLabyrinth(String bb8Navigierung[][], String lab[][],boolean isExit) {
        if(isExit == false) {
            for (int y = 0; y < lab.length; y++) {
                for (int x = 0; x < lab[y].length; x++) {
                    System.out.print(" " + lab[y][x]);
                }
                System.out.println();
            }
        }
        else if(isExit== true) {
            System.out.println("\nDas hat BB-8 alles gesehen:\n ");
            for (int i = 0; i < bb8Navigierung.length; i++) {
                System.out.println();
                for (int j = 0; j < bb8Navigierung[i].length; j++) {
                    String old = "�";
                    old = old.replace("�", " ");
                    bb8Navigierung[i][j] = old;
                    System.out.print(bb8Navigierung[i][j] + "  ");
                }
            }
        }
    }
    // Ende
}
