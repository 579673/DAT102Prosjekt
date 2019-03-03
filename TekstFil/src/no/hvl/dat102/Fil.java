/**
 * 
 
package no.hvl.dat102;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import no.hvl.dat102.adt;

/**
 * @author Ole Olsen
 * 
 */
/* Ref: Mughal: Java som f�rste programmeringsspr�k
 * 
 * Koble bytestr�m til tegnstr�m
 * 
 * Skriving til tekstfil
verdier ->  PrintWriter ->  FileWriter ->  tekstfil
                        tegn          bytes 

Lesing fra tekstfil
tekstfil ->  FileReader ->  BufferReader -> readLine       
        bytes           tegn             tekstlinje        


 * En tekstfil best�r av tekstlinjer og  videre best�r en tekstlinje av en sekvens av 
 * tegn som er avsluttet med en linejavslutt-streng. Linjeavslutt-strengen er plattformavhengig.
 * 
 * Vi bruker en tegnstr�m som er koblet til en bytest�m. Bytes vil bli lest fra byte-innstr�mmen
 * og oversatt til Unicode-tegn av tegn-str�mmen ved lesing av tekstfil. Motsatt har vi at ved 
 * skriving til tekstfil vil Unicode-tegn blir konvertert til bytes av tegn-utstr�mmen og blir skrevet 
 * ut av bytest�mmen. 
 * 
 * 
 * Anbefalt � bruke BufferedReader i stedet for Scanner n�r vi bare skal lese tekstfilen linje for linje.
 * BufferReader er mer effektiv.
 * https://www.geeksforgeeks.org/difference-between-scanner-and-bufferreader-class-in-java/
 *   
 */

/* Du m� tilpasse dine variable 
public class Fil {

	private static final String SKILLE = "#";

	/**
	 * @param filnavn
	 * @param cda2 
	 * @return Referansen til CD-arkivet
	 
	
	 
	public static CDarkivADT lesFraFil(String filnavn)  {
		CDarkivADT cda = null;
			try {
			/*  1 - FileReader
			 *      Klassen FileReader gj�r at byte-innstr�mmen blir opprettet,
			 *      s�rger videre for at bytes fra filen blir tolket riktig som tegn 
			 *      for plattformen.
			  
			 FileReader ansFil = new FileReader(filnavn);
			 			 
            
			/*  2 - BufferedReader
			 *      Definerer et BufferReader-objekt som kobles til FileReader-objektet.
			 *      Buffret innlesing. Da kan vi bruke metoden readLine() som leser en linje.		  
			 * 			 
			 
			BufferedReader innfil = new BufferedReader(ansFil);

			// 3 - Leser den f�rste posten som kun inneholder et heltall som er antall info-poster
			       
			String linje = innfil.readLine();
			int n = Integer.parseInt(linje);
			cda = new CDarkiv(n);

			// 4 - Les postene, en hel post om gangen
			for (int i = 0; i < n; i++) {
				String post = innfil.readLine();
				String[] felt = post.split(SKILLE);
				int nr = Integer.parseInt(felt[0]);
				String artist = felt[1];
				String tittel = felt[2];
				int aar = Integer.parseInt(felt[3]);
				String sjStr = felt[4];
				Sjanger sj = Sjanger.finnSjanger(sjStr);
				String plselskap = felt[5];

				CD cd = new CD(nr, artist, tittel, aar, sj, plselskap);

				cda.leggTil(cd);
				
				// 4 - Lukk filen
			    innfil.close();
			}

			

		} catch (FileNotFoundException unntak) {// arver fra IOE.. m� st� f�rst
			                                    // hvis ikke vil unntaket for IOException skygge
			System.out.println("Finner ikke filen " + filnavn);
			System.exit(1); //avbryte utf�ringen
		} catch (IOException e) {
			System.out.println("Feil ved lesing av fil: " + e);
			System.exit(2); //avbryte utf�ringen
		}
      
	return cda;
       
	}// metode
	
	
	
	public static void skrivTilFil(CDarkivADT cdarkiv, String filnavn)  {
		try {
			/* 1 - FileWriter
			 *     Definerer et FileWriter-objekt som �pner filen.
			 *     Byte-str�m blir opprettet for skriving av bytes til filen.
			 *     Tegn blir lagret i standard tegnkodingsformat for plattformen.
			 *     Hvis utvid er true, vil filen kunne utvides ved skriving p� slutten
			 *     av filen. Hvis utvid er false, vil skrivingen starte i begynnnelsen 
			 *     av filen.			     
			 *     Dersom filen ikke eksisterer, vil den bli opprettet. 
			 *     Dersom filen ikke kan �pnes, vil metoden kaste et unntak av typen IOException.
			 * 
			 
			FileWriter ansFil = new FileWriter(filnavn, false);

			/* 2 - PrintWriter
			 *     Definerer et PrintWriter-objekt som kobles til FileWriter-objektet.
			 *     PrintWriter-objektet leverer tegn til FileWriter-objektet.
			 *     FileWriter vil gi riktig koding av tegn i bytes og lagring p� fil.
			 *      
			 
			PrintWriter utfil = new PrintWriter(ansFil);
			int antall = cdarkiv.antall();
			// 3 - Skriver f�rst ut antall cd-info-er p� f�rste linje
			utfil.println(antall);
			CD[] tabell = cdarkiv.hentCdTabell();
			for (int i = 0; i < antall; i++) {
				// 3 - Skriver postene, felt for felt
				utfil.print(tabell[i].getCdnr());
				utfil.print(SKILLE);
				utfil.print(tabell[i].getArtist());
				utfil.print(SKILLE);
				utfil.print(tabell[i].getTittel());
				utfil.print(SKILLE);
				utfil.print(tabell[i].getAar());
				utfil.print(SKILLE);
				utfil.print(tabell[i].getSjanger());
				utfil.print(SKILLE);
				utfil.println(tabell[i].getPlateselskap());
			} // for
				// 4 - Lukk filen
			utfil.close();
		} // try
		
				
		catch(FileNotFoundException e) {
			System.out.print("feil ved �pning av fil: " + filnavn);
			System.exit(1); // avbryte utf�ringen
		}
		catch (IOException e) {
			System.out.println("Feil p� skriving til fil: " + e);
			System.exit(2);// avbryte utf�ringen
		}

	}// metode
	
	/*Disse to unntakene er s�kalte kontrollerte, dvs kompilatoren sjekker de:
	 * 
	 * Vi m� enten fange de med try-catch i metoden slik som her vist over eller s� m� vi 
	 * tillate at unntakene sendes "oppover" (propagering), men da m� vi
	 * ha throws-klausul i metodespesifikasjonen (som vi ikke har her).
	 

}// class
*/
