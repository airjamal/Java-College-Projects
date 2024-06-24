
import de.hsrm.mi.prog.util.StaticScanner;

/**
 * Main Class fuer die Ausfuehrung der Burger
 * 
 * @author Berhan, Jamal, Sefa
 * 
 */

public class Controller {

	/**
	 * Ablauf des Programms
	 * 
	 */
	public static void main(String[] args) {

		/*
		 * Anzeige der Speisekarte
		 * 
		 * @see Klasse Menu
		 */
		Menu menu = new Menu();

		/**
		 * aktBurger - Der aktuelle Burger zaehlerBurger - Aufzaehlung des Burgers
		 * zutatenNummer - Die Nummer der Zutaten gesamtZeit - Die gesamte Zeit
		 * gesamtPreis - Der gesamte Preis burgerAnzahl - Der Speicher der Burger die
		 * wir haben koennen done - Beendung des Burgers
		 * 
		 */
		int aktBurger = 0;
		int burgerCounter = 0;
		int[] zutatenNummer = { 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		int numZutaten = 0;
		int gesamtZeit = 0;
		float gesamtPreis = 0;
		boolean[] burgerAnzahl = { false, false, false, false, false, false, false, false, false, false };
		boolean done = false;
		Burgir[] burger = new Burgir[10];
		Zutat [] tempZutaten = new Zutat[9];
		/**
		 * @array aktZutat - Der Speicher fuer die maximale Anzahl der Zutaten
		 * @array burger - Der Speicher fuer die maximale Anzahl der Burger
		 */

		/**
		 * Eine For-Schleife f�r die Aufzaehlung mehrerer Burger
		 */

		
//		for (int i = 0; i < burger.length; i++) {
//			burger[i] = new Burgir();
//		}

		System.out.println("\nSchoenen guten Tag bei der Krossen Krabbe ihre Bestellung bitte\n");

		System.out.println("Um dir alle moeglichen Zutaten anzusehen, die wir parat haben, musst du 'menu' eingeben\n");

		System.out.println("wenn du 'neuer burger' eingibst, dann kannst du einen ganz neuen Burger erstellen\n");

		System.out
				.println("wenn du 'zutat' mit der jeweiligen Nummer eingibst, dann hast du auch schon deine Zutaten\n");

		System.out.println(
				"wenn du denkst, dass dieser Burger dein Traumburger ist und du schon seit deiner Kindheit auf ihn wartest, dann kannst du mit 'ok' deinen zusammengefuegtem Burger abschliessen\n ");

		System.out.println("'meine burger' zeigt dir deine Meisterwerke von Burger an\n");

		System.out.println(
				"um dem ganzen ein Ende zu setzen muss du 'bestellen' eingeben und schon wird dein Burger erstellt\n");

		System.out.println();

		System.out.println("Die Karte beschreibt die folgende Reihenfolge:\n");
		System.out.println("Nr, Zutat, Preis, Klassisch, Vegan, Vegetarisch\n");

		System.out.println("So was moechtest du haben:\n ");

		/**
		 * Mit dieser While-Schleife wird das Programm durchlaufen und hiermit erstellt
		 * man seine Burger
		 */
		while (done != true) {

			String eingabe = StaticScanner.nextString();
			eingabe = eingabe.toLowerCase();
			switch (eingabe) {

			case "menu":
				// Menu-Anzeige
				menu.zeigeMenu();
				System.out.println();

				System.out.println(
						"---------------------------------------------------------------------------------------------------------\n");

				System.out.println("So was moechtest du als naechstes tun?\n");

				System.out.println("'menu' = anzeigen des Menus\n");
				System.out.println("'neuer burger' = erstellen eines Burgers\n");
				System.out.println(
						"'zutat'mit gewuenschter nummer dazu = hinzufuegen der Zutat zu einem bestimmten Burger\n");
				System.out.println("'ok' = abschliessen den aktuellen Burgers\n");
				System.out.println("'meine burger' = anzeigen der Burger\n");
				System.out.println("'bestellen' = erstellen der Burger\n");
				System.out.println();

				break;

			case "neuer burger":
				System.out.println("\n" + "Wie soll ihr Burger heissen?");
				String burgerName = StaticScanner.nextString();

				for (int i = 0; burger[i] == null && i < 9; i++) {
					burger[i].setName(burgerName);
				}

				//burger[zaehlerBurg].setName(burgerName);
				//zaehlerBurg++;

				System.out.println();

				System.out.println(
						"---------------------------------------------------------------------------------------------------------\n");

				System.out.println("So was moechtest du als naechstes tun?\n");

				System.out.println("'menu' = anzeigen des Menus\n");
				System.out.println("'neuer burger' = erstellen eines Burgers\n");
				System.out.println(
						"'zutat'mit gewuenschter nummer dazu = hinzufuegen der Zutat zu einem bestimmten Burger\n");
				System.out.println("'ok' = abschliessen den aktuellen Burgers\n");
				System.out.println("'meine burger' = anzeigen der Burger\n");
				System.out.println("'bestellen' = erstellen der Burger\n");

				System.out.println();

				break;

			case "zutat":

				System.out.println("Geben sie bitte ihrer gewuenschte Zutatsnummer ein");

				// Eingabe
				int eingabeNummer = StaticScanner.nextInt();

				// if-Anweisung f�r die Aufnahme der Zutaten
						
						if (done != true) {
							
						burger[aktBurger].hinzufuegen();
						
						for (int i = 0; i < menu.getZutatListe().length; i++) {
							for (int j = 0; j < menu.getZutatListe()[i].length; j++) {
 
								if (menu.getZutatListe()[i][j] != null && menu.getZutatListe()[i][j].getNummer() == eingabeNummer) {
									burger[aktBurger].getZutaten()[zutatenNummer[aktBurger]] = menu.getZutatListe()[i][j];
									zutatenNummer[aktBurger]++;

									System.out.println("\n" + "Sie haben die Zutat "
											+ menu.getZutatListe()[i][j].getName() + " hinzugefuegt. ");

								}
							}

					}	
					
						} else {

						System.out.println(
								"Wenn sie keine weitere Zutaten hinzufuegen wollen schreiben sie 'ok' zum fortsetzen.\n");
						System.out.println("Ansonsten beliebige eingabe waehlen\n");

						System.out.println();

						System.out.println(
								"---------------------------------------------------------------------------------------------------------\n");

						System.out.println("So was moechtest du als naechstes tun?\n");

						System.out.println("'menu' = anzeigen des Menus\n");
						System.out.println("'neuer burger' = erstellen eines Burgers\n");
						System.out.println(
								"'zutat'mit gewuenschter nummer dazu = hinzufuegen der Zutat zu einem bestimmten Burger\n");
						System.out.println("'ok' = abschliessen den aktuellen Burgers\n");
						System.out.println("'meine burger' = anzeigen der Burger\n");
						System.out.println("'bestellen' = erstellen der Burger\n");

						System.out.println();
				} 
				break;

			case "meine burger":
				for (int i = 0; i < burger.length; i++) {
					burger[i].getGesamtPreis();
					if (burger[i].getName() != null) {
						gesamtPreis += burger[i].getPreis();
						gesamtZeit += burger[i].zubereiten();
						System.out.println("\n" + burger[i].getName() + " " + burger[i].getGesamtPreis() + " Euro");
						System.out.println(burger[i].toString() + "\n");
					}
				}
				break;
			case "ok":
			int broetchenCounter = 0;
				for ( Zutat zutat : tempZutaten ) {
					if (zutat instanceof Broetchen){
						broetchenCounter += 1;
					}
				}
				if(tempZutaten[1] != null && broetchenCounter == 1){

					// �berpr�fen!!!

					burger[burgerCounter] = new Burgir(burgerName, tempZutaten);
					burgerCounter += 1;
					System.out.println("Der '" + burgerName + "' wurde Ihrer Bestellung hinzugefuegt.");
					for(int i = 0; i < tempZutaten.length; i++){
						tempZutaten[i] = null;
					}
					numZutaten = 0;
				}else{
					System.out.println("Wie du hast kein Broetchen???!!?? Du brauchst ein Broetchen!!!");
				}
				System.out.println();

				System.out.println(
						"---------------------------------------------------------------------------------------------------------\n");

				System.out.println("So was moechtest du als naechstes tun?\n");

				System.out.println("'menu' = anzeigen des Menus\n");
				System.out.println("'neuer burger' = erstellen eines Burgers\n");
				System.out.println("'zutat' mit gewuenschter nummer dazu = hinzufuegen der Zutat zu einem bestimmten Burger\n");
				System.out.println("'ok' = abschliessen den aktuellen Burgers\n");
				System.out.println("'meine burger' = anzeigen der Burger\n");
				System.out.println("'bestellen' = erstellen der Burger\n");

				System.out.println();
				break;

			case "bestellen":

				System.out.println();
				for (int i = 0; i < burger.length; i++) {
					for (int j = 0; j < burger[i].zutaten.length; j++) {
						if (burger[i].getName() != null && burger[i].zutaten[j] != null) {
							burger[i].zutaten[j].zubereiten();
						}
					}
				}
				for (int i = 0; i < burgerCounter; i++) {
					if (burger[i].getName() != null) {
						gesamtPreis = gesamtPreis +  burger[i].getPreis();
						gesamtZeit = gesamtZeit +burger[i].zubereiten();
						System.out.println(burger[i].getName() + "---" + gesamtPreis + " Euro");
						System.out.print("Ist in " + gesamtZeit + " Sekunden fertig zubereitet.");
					}
				}
			}
		}
}}
