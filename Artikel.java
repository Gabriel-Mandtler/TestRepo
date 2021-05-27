import java.util.Comparator;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Artikel {
	
	protected int Artikelnummer;
	protected String Artikelbezeichnung;
	protected double Verkaufspreis;
	
	public Artikel() throws Exception {
				
		JTextField f1 = new JTextField();
		JTextField f2 = new JTextField();
		JTextField f3 = new JTextField();
        
		Object[] message = {"Artikelnummer", f1, "Artikelbezeichnung",f2, "Verkaufspreis", f3};
		JOptionPane pane = new JOptionPane(message, JOptionPane.PLAIN_MESSAGE, JOptionPane.OK_CANCEL_OPTION);
        pane.createDialog(null, "Artikel").setVisible(true);
        
        if(f1.getText().length() == 0 || f2.getText().length() == 0 || f3.getText().length() == 0) {
        
			throw new Exception("Eine Eingabe ist erforderlich!");
			
        } else {
			String t1 = f1.getText();
			int Artikelnummer = Integer.parseInt(t1);
			String t2 = f2.getText();
			String Artikelbezeichnung = t2;
			String t3 = f3.getText();
			double Verkaufspreis = Double.parseDouble(t3);

			this.Artikelnummer = Artikelnummer;
			this.Artikelbezeichnung = Artikelbezeichnung;
			this.Verkaufspreis = Verkaufspreis;
		}
	}
	
    
	public void print() {
		
		System.out.println("Artikel hat die Nummer: " + Artikelnummer + " und hat die Bezeichnung: " + Artikelbezeichnung + " und kostet: " + Verkaufspreis + "€");
	}
	

	public String toString() {
	
		return "\n" + "Artikel hat die Nummer: " + Artikelnummer + " und hat die Bezeichnung: " + Artikelbezeichnung + " und kostet: " + Verkaufspreis + "€";
	}
	
	public int getArtikelnummer() {
		
		return this.Artikelnummer;
	}
	
	public String getArtikelbezeichnung() {
		
		return this.Artikelbezeichnung;
	}
	
	public double getVerkaufspreis() {
		
		return this.Verkaufspreis;
	}
	
	public void setArtikelnummer(int neueArtikelnummer) {
		
		this.Artikelnummer = neueArtikelnummer;
	}
	
	public void setArtikelbezeichnung(String neueArtikelbezeichnung) {
		
		this.Artikelbezeichnung = neueArtikelbezeichnung;
	}
	
	public void setVerkaufspreis(double neuerVerkaufspreis) {
		
		this.Verkaufspreis = neuerVerkaufspreis;
	}




	public static Comparator<Artikel> COMPARE_BY_NAME = new Comparator<Artikel>() {
        public int compare(Artikel one, Artikel other) {
			return one.getArtikelbezeichnung().compareTo(other.getArtikelbezeichnung());

        }
    };

	public static Comparator<Artikel> COMPARE_BY_PRICE = new Comparator<Artikel>() {
        public int compare(Artikel one, Artikel other) {
			return Double.compare(one.getVerkaufspreis(), other.getVerkaufspreis());

        }
    };

	public static Comparator<Artikel> COMPARE_BY_NR = new Comparator<Artikel>() {
        public int compare(Artikel one, Artikel other) {
			return Integer.compare(one.getArtikelnummer(), other.getArtikelnummer());

        }
    };

}
