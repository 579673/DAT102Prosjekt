package no.hvl.dat102;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;

public class LeseFraFil {

	public static void main(String[] args) {

		final String SKILLE = ":"; // kan v�re parametre n�r vi lager metode
		final String ANSATT_FIL = "ansatte.txt";

		FileReader ansFil = null;
		BufferedReader innfil = null;

		try {
			// // 1 - FileReader
			ansFil = new FileReader(ANSATT_FIL);
		}

		catch (FileNotFoundException unntak) {
			System.out.println("Finner ikke filen " + ANSATT_FIL);
			System.exit(1);
			// Vi kan lage script som kj�rer programmet fra kommandolinjen
			// og fanger opp returkoden ved System.exit
			//
		}

		try {
			// 2 - BufferedReader
			innfil = new BufferedReader(ansFil);

			// 3 - Leser den f�rste posten som er antall info-poster
			String linje = innfil.readLine();
			int n = Integer.parseInt(linje);

			// 4 - Les postene, en hel post om gangen
			String post = innfil.readLine();
			for (int i = 0; i < n; i++) {
				String[] felt = post.split(SKILLE);
				// http://docs.oracle.com/javase/8/docs/api/java/lang/String.html#split(java.lang.String,
				// int)

				String fornavn = felt[0];
				String etternavn = felt[1];
				double timeloenn = Double.parseDouble(felt[2]);
				boolean kjoenn = Boolean.parseBoolean(felt[3]);

				Ansatt a = new Ansatt(fornavn, etternavn, timeloenn, kjoenn);
				System.out.println(a);

				post = innfil.readLine();
			}

			// 4 - Lukk filen
			innfil.close();
		} catch (FileNotFoundException unntak) {// arver fra IOE.. m� st� f�rst
			// hvis ikke vil unntaket for IOException skygge
			System.out.println("Finner ikke filen ");
			System.exit(1);

		} catch (IOException e) {
			System.out.println("Feil ved lesing av fil: " + e);
			System.exit(2);
		}
	}
}