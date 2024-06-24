
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
		int zaehlerBurg = 0;
		int[] zutatenNummer = { 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		boolean[] burgerAnzahl = { false, false, false, false, false, false, false, false, false, false };
		boolean done = false;

		/**
		 * @array aktZutat - Der Speicher fuer die maximale Anzahl der Zutaten
		 * @array burger - Der Speicher fuer die maximale Anzahl der Burger
		 */

		/**
		 * Eine For-Schleife für die Aufzaehlung mehrerer Burger
		 */

		Burgir[] burger = new Burgir[10];
		for (int i = 0; i < burger.length; i++) {
			burger[i] = new Burgir();
		}

		System.out.println("\nSchoenen guten Tag bei der Krossen Krabbe ihre Bestellung bitte\n");

		System.out.println("Um alle moeglichen Zutaten anzusehen, die wir anbieten, schreiben Sie bitte 'MENU'.\n");

		System.out.println("Wenn Sie 'NEUER BURGER' eingeben, dann koennen Sie einen neuen Burger erstellen.\n");

		System.out
				.println("Wenn Sie 'ZUTAT' mit der jeweiligen Nummer eingibst, dann erhaelt ihr Burger diese Zutat.\n");

		System.out.println(
				"Wenn Sie denken, dass dieser Burger ihr Traumburger ist, dann koennen Sie mit 'OK' ihren Burger abschliessen.\n");

		System.out.println("Mit 'MEINE BURGER' koennen Sie ihre Burger anzeigen lassen.\n");

		System.out.println(
				"Um Ihren Burger abzuschließen und erstellen zu lassen, koennen Sie mit 'BESTELLEN' dies tun.\n");

		System.out.println("Geben Sie ihren erste Wahl ein:\n ");

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

				break;

			case "neuer burger":
				System.out.println("\n" + "Wie soll ihr Burger heissen?");
				String burgerName = StaticScanner.nextString();

				System.out.println(
						"\nSie koennen jetzt ihre Zutaten hinzufuegen, schreiben Sie 'ZUTAT' um dies zu tun.\n");

				/**
				 * for (int i = 0; burger[i] != null && i < 9; i++) {
				 * burger[i].setName(burgerName); }
				 */
				burger[zaehlerBurg].setName(burgerName);
				zaehlerBurg++;

				System.out.println();
				break;

			case "zutat":
				System.out.println("\nGeben sie bitte ihrer gewuenschte Zutatsnummer ein");

				// Eingabe
				int eingabeNummer = StaticScanner.nextInt();

				// if-Anweisung für die Aufnahme der Zutaten

				if (burger[aktBurger].hinzufuegen() != false) {
					System.out
							.println("Sie können keine Zutaten mehr hinzufuegen, schreiben Sie 'OK' zum fortsetzen.\n");
				} else {
					for (int i = 0; i < menu.getZutatListe().length; i++) {
						for (int j = 0; j < menu.getZutatListe()[i].length; j++) {
							if (menu.getZutatListe()[i][j] != null
									&& menu.getZutatListe()[i][j].getNummer() == eingabeNummer) {
								burger[aktBurger].getZutaten()[zutatenNummer[aktBurger]] = menu.getZutatListe()[i][j];
								zutatenNummer[aktBurger]++;
								System.out.println("\nSie haben die Zutat " + menu.getZutatListe()[i][j].getName()
										+ " hinzugefuegt.\n");
							}
						}
					}
				}
				break;

			case "meine burger":
				for (int i = 0; i < burger.length; i++) {
					burger[i].getGesamtPreis();
					if (burger[i].getName() != null) {
						System.out.println("\n" + burger[i].getName() + " " + burger[i].getGesamtPreis() + " Euro");
						System.out.println(burger[i].toString() + "\n");
					}
				}
				break;

			case "ok":
				int broetchenCounter = 0;
				for (Zutat zutatListe : burger[aktBurger].getZutaten() ) {
					if (zutatListe instanceof Broetchen) {
						broetchenCounter += 1;
					}
				}
			
				if (burger[aktBurger] != null && broetchenCounter == 1) {
				System.out.println("Der '" + burger[aktBurger].getName() + "' wurde zu Ihrer Bestellung hinzugefuegt.");
					for (int o = 0; o < burger.length; o++) {
						burger[aktBurger] = null;
					}
				} else {
					System.out.println("\nSie haben kein Broetchen zu Ihrem Burger hinzugefuegt, bitte fuegen Sie ein Broetchen dazu.\n");

				}
				System.out.println("Wenn Sie fertig sind schreiben sie 'MEINE BURGER' um ihre Burger anzusehen und falls Sie mit ihrer Wahl zufrieden sind dann schreiben Sie 'BESTELLEN'.\n");
				
				break;

			case "bestellen":

				for (int i = 0; i < burger.length; i++) {
					if (burger[i].getName() != null) {
						System.out
								.println("\n" + burger[i].getName() + " - " + burger[i].getGesamtPreis() + " Euro.\n");
						System.out
								.println("\nIst in " + burger[i].getZubereitungszeit() + " Minuten fertig zubereitet.");
						System.out.println("Der Burger hat eine Hoehe von " + burger[i].getBerechneHoehe() + " mm.\n");

					}
				}
			}
		}
}}
