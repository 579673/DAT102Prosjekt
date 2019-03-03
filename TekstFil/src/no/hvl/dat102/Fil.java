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
/* Ref: Mughal: Java som første programmeringsspråk
 * 
 * Koble bytestrøm til tegnstrøm
 * 
 * Skriving til tekstfil
verdier ->  PrintWriter ->  FileWriter ->  tekstfil
                        tegn          bytes 

Lesing fra tekstfil
tekstfil ->  FileReader ->  BufferReader -> readLine       
        bytes           tegn             tekstlinje        


 * En tekstfil består av tekstlinjer og  videre består en tekstlinje av en sekvens av 
 * tegn som er avsluttet med en linejavslutt-streng. Linjeavslutt-strengen er plattformavhengig.
 * 
 * Vi bruker en tegnstrøm som er koblet til en bytestøm. Bytes vil bli lest fra byte-innstrømmen
 * og oversatt til Unicode-tegn av tegn-strømmen ved lesing av tekstfil. Motsatt har vi at ved 
 * skriving til tekstfil vil Unicode-tegn blir konvertert til bytes av tegn-utstrømmen og blir skrevet 
 * ut av bytestømmen. 
 * 
 * 
 * Anbefalt å bruke BufferedReader i stedet for Scanner når vi bare skal lese tekstfilen linje for linje.
 * BufferReader er mer effektiv.
 * https://www.geeksforgeeks.org/difference-between-scanner-and-bufferreader-class-in-java/
 *   
 */

/* Du må tilpasse dine variable 
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
			 *      Klassen FileReader gjør at byte-innstrømmen blir opprettet,
			 *      sørger videre for at bytes fra filen blir tolket riktig som tegn 
			 *      for plattformen.
			  
			 FileReader ansFil = new FileReader(filnavn);
			 			 
            
			/*  2 - BufferedReader
			 *      Definerer et BufferReader-objekt som kobles til FileReader-objektet.
			 *      Buffret innlesing. Da kan vi bruke metoden readLine() som leser en linje.		  
			 * 			 
			 
			BufferedReader innfil = new BufferedReader(ansFil);

			// 3 - Leser den første posten som kun inneholder et heltall som er antall info-poster
			       
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

			

		} catch (FileNotFoundException unntak) {// arver fra IOE.. må stå først
			                                    // hvis ikke vil unntaket for IOException skygge
			System.out.println("Finner ikke filen " + filnavn);
			System.exit(1); //avbryte utføringen
		} catch (IOException e) {
			System.out.println("Feil ved lesing av fil: " + e);
			System.exit(2); //avbryte utføringen
		}
      
	return cda;
       
	}// metode
	
	
	
	public static void skrivTilFil(CDarkivADT cdarkiv, String filnavn)  {
		try {
			/* 1 - FileWriter
			 *     Definerer et FileWriter-objekt som åpner filen.
			 *     Byte-strøm blir opprettet for skriving av bytes til filen.
			 *     Tegn blir lagret i standard tegnkodingsformat for plattformen.
			 *     Hvis utvid er true, vil filen kunne utvides ved skriving på slutten
			 *     av filen. Hvis utvid er false, vil skrivingen starte i begynnnelsen 
			 *     av filen.			     
			 *     Dersom filen ikke eksisterer, vil den bli opprettet. 
			 *     Dersom filen ikke kan åpnes, vil metoden kaste et unntak av typen IOException.
			 * 
			 
			FileWriter ansFil = new FileWriter(filnavn, false);

			/* 2 - PrintWriter
			 *     Definerer et PrintWriter-objekt som kobles til FileWriter-objektet.
			 *     PrintWriter-objektet leverer tegn til FileWriter-objektet.
			 *     FileWriter vil gi riktig koding av tegn i bytes og lagring på fil.
			 *      
			 
			PrintWriter utfil = new PrintWriter(ansFil);
			int antall = cdarkiv.antall();
			// 3 - Skriver først ut antall cd-info-er på første linje
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
			System.out.print("feil ved åpning av fil: " + filnavn);
			System.exit(1); // avbryte utføringen
		}
		catch (IOException e) {
			System.out.println("Feil på skriving til fil: " + e);
			System.exit(2);// avbryte utføringen
		}

	}// metode
	
	/*Disse to unntakene er såkalte kontrollerte, dvs kompilatoren sjekker de:
	 * 
	 * Vi må enten fange de med try-catch i metoden slik som her vist over eller så må vi 
	 * tillate at unntakene sendes "oppover" (propagering), men da må vi
	 * ha throws-klausul i metodespesifikasjonen (som vi ikke har her).
	 

}// class
*/
