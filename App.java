import java.util.*;
import javax.swing.*;

public class App {
	
	public static void main(String[] args) {
		
		System.out.println("Hallo");
		List<Artikel> liste = new ArrayList<Artikel>();
		int check = 0;
		//test
		while(true) {

			Artikel artIndex;
			try {

				artIndex = new Artikel();

			} catch (Exception e) {

				System.out.println(e.getMessage());
				check++;
				break;

			}

			liste.add(artIndex);
			int repeat = JOptionPane.showConfirmDialog(null,"Ja für weiteres Objekt", "Nein", JOptionPane.YES_NO_OPTION);

			if (repeat == 1) {
				break;
			}
		}




		if (check == 0) {
			sortArt(liste);
		}
		
		}

		static String getOperatoren() {
			
			final String[] RMIType = { "Sortierung Nummer", "Sortierung Name", "Sortierung Preis"};
			return (String) JOptionPane.showInputDialog(null, "Sortierungsauswahl", "Input Dialog", JOptionPane.QUESTION_MESSAGE, null, RMIType,RMIType[0]);
		}



		static void sortArt(List<Artikel> liste) {

				while(true) {

					JFrame meinJFrame = new JFrame();
					meinJFrame.setSize(1000, 300);
					JPanel panel = new JPanel();
					JTextArea text = new JTextArea(1000, 300);
					text.setLineWrap(true);
					text.setWrapStyleWord(true);
					JScrollPane scrollpane = new JScrollPane(text);
					panel.add(scrollpane);
					meinJFrame.add(panel);
					meinJFrame.add(text);
					
					String erg = getOperatoren();
			
						if (erg.equals("Sortierung Nummer")) {
					
							Collections.sort(liste, Artikel.COMPARE_BY_NR);	
	
							meinJFrame.setTitle("Sortierung nach Artikelnummer:");
							text.setText(liste.toString() + System.getProperty("line.separator"));
							meinJFrame.setVisible(true);
						
						}
				
						else if (erg.equals("Sortierung Name")) {
					
							Collections.sort(liste, Artikel.COMPARE_BY_NAME);
							
							meinJFrame.setTitle("Sortierung nach Artikelbezeichnung:");
							text.setText(liste.toString() + System.getProperty("line.separator"));
							meinJFrame.setVisible(true);
						
						}
				
						else if (erg.equals("Sortierung Preis")) {
						
							Collections.sort(liste, Artikel.COMPARE_BY_PRICE);
								
							meinJFrame.setTitle("Sortierung nach Verkaufspreis:");
							text.setText(liste.toString() + System.getProperty("line.separator"));
							meinJFrame.setVisible(true);
						} 
						
						else {
					
							System.out.print("Fehler");
						}
						int repeat1 = JOptionPane.showConfirmDialog(null,"Ja für weiteres Sortierverfahren", "Nein", JOptionPane.YES_NO_OPTION);
	
						if (repeat1 == 1) {
							break;
						} else {
							meinJFrame.dispose();
						}
					}
			}
}	