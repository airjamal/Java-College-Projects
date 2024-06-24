
/**
 * Burger Klasse
 *
 * @author Berhan, Jamal, Sefa
 *
 */

public class Menu{

	// 2D-Array für die Zutat Liste
	 Zutat[][] zutatListe = new Zutat[6][4];

	public Menu() {
		
			//Null-Setzen der Karte
		for (Zutat[] zutatSub : zutatListe) {
			for (Zutat zutatListe : zutatSub) {
				zutatListe = null;
			}
		}
		
		// Die Liste der Zutaten in einem 2D-Array
		zutatListe[0][0] = new Broetchen(11, "Hamburger (Standard) ", 0.85f, true, false, true, 90, 27);
		zutatListe[0][1] = new Broetchen(12, "Hamburger Sesam", 0.95f, true, false, true, 90, 28);
		zutatListe[0][2] = new Broetchen(13, "Vegan- Broetchen", 0.55f, false, true, true, 240, 34);
		zutatListe[0][3] = new Broetchen(14, "Ciabatta", 0.45f, false, false, true, 330, 41);

		zutatListe[1][0] = new Bratling(21, "Rindfleisch (Original)", 1.85f, true, false, false, 270, 25);
		zutatListe[1][1] = new Bratling(22, "Haehnchenfleisch gegrillt", 1.15f, false, false, false, 180, 11);
		zutatListe[1][2] = new Bratling(23, "Falafel-Bratling", 1.45f, false, true, true, 210, 21);
		zutatListe[1][3] = new Bratling(24, "Gemuese-Bratling", 1.75f, false, false, true, 360, 41);

		zutatListe[2][0] = new Salat(31, "Eisbergsalat", 0.18f, true);
		zutatListe[2][1] = new Salat(32, "Rucolasalat", 0.25f, false);

		zutatListe[3][0] = new Gemuese(41, "Tomate", 0.25f, true,3, 3);
		zutatListe[3][1] = new Gemuese(42, "Salzgurke", 0.15f, true, 4, 2);
		zutatListe[3][2] = new Gemuese(43, "Rote Zwiebelringe", 0.08f, false,5, 2);
		zutatListe[3][3] = new Gemuese(44, "Jalapeno-Ringe", 0.08f, false,5, 2);

		zutatListe[4][0] = new Sauce(51, "Ketchup", 0.10f, true, true, true, 5, "normal");
		zutatListe[4][1] = new Sauce(52, "Sandwich-Sauce", 0.15f, true, false, true, 10, "normal");
		zutatListe[4][2] = new Sauce(53, "Chili-Sauce", 0.25f, false, true, true, 8, "scharf");
		zutatListe[4][3] = new Sauce(54, "Honig-Senf-Sauce", 0.18f, false, false, true, 8, "suess");
		
		zutatListe[5][0] = new Kaese(125, "Sandwich-Kaese", 0.39f, true, true, 80, "Kuhmilch");
		zutatListe[5][1] = new Kaese(126, "Gouda", 0.59f, false, true, 140, "Kuhmilch");
		zutatListe[5][2] = new Kaese(127, "Salakis", 0.75f, false, true, 8, "Schafsmilch");
		zutatListe[5][3] = new Kaese(128, "Landana Rosso", 0.95f, false, true, 8, "Ziegenmilch");
		
	}

	// Die Methode um die Karte anzuzeigen
	public void zeigeMenu() {
		System.out.println("Unsere Karte:");
		for (int i = 0; i < zutatListe.length; i++) {
			System.out.println(); // Spacer
			for (int j = 0; j < zutatListe[0].length; j++) {
				if (zutatListe[i][j] != null)
					System.out.println((i + 1) + "" + (j + 1) + " " + zutatListe[i][j].toString());
			}
		}
	}

	// 2D-Array Getter Methode für die Zutat Liste
	public Zutat[][] getZutatListe() {
		return zutatListe;
	}

	// Setter Methode für die Zutat Liste
	public void setZutatListe(Zutat[][] zutatListe) {
		this.zutatListe = zutatListe;
	}

	

}
