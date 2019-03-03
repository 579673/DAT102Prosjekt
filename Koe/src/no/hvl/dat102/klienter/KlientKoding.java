package no.hvl.dat102.klienter;

import no.hvl.dat102.tabell.TabellKoe;

public class KlientKoding {
	//eks listing 5.1 i boken, 
	public static void main(String[] a) {
		int[] noekkel = { 5, 12, -3, 8, -9, 4, 10 };
		String dekodet = "", kodet = "";
		String melding = "Dette er en proeve på en tekst";
		TabellKoe koe1 = new TabellKoe();
		TabellKoe koe2 = new TabellKoe();
		int kodeVerdi;

		// Legger kodeverdiene inn i to køer
		// Tenker oss at sender som koder har en kø og mottaker som
		// dekoder har en kø
		// Køene blir operert "synkront" ,
		// tar ut og legger inn tilsvarende element i de to køene
		// og vi er garantert riktig resultat
		// Vi går ikke rundt alfabetet i denne kodingen.
		
		for (int i = 0; i < noekkel.length; i++) {
			koe1.innKoe(new Integer(noekkel[i]));
			koe2.innKoe(new Integer(noekkel[i]));
		}

		// Koding av meldinga
		for (int i = 0; i < melding.length(); i++) {
			Integer intObjekt = (Integer) koe1.utKoe();
			kodeVerdi = intObjekt.intValue();
			kodet = kodet + (char) (melding.charAt(i) + kodeVerdi);
			koe1.innKoe(new Integer(kodeVerdi));
		}

		System.out.println("\nKodet melding blir:\n" + kodet + "\n");
		// Vi kan tenke oss at den kodete meldingen blir sendt over nettverket

		// Dekoding av meldingen
		for (int i = 0; i < kodet.length(); i++) {
			Integer intObjekt = (Integer) koe2.utKoe();
			kodeVerdi = intObjekt.intValue();
			dekodet = dekodet + (char) (kodet.charAt(i) - kodeVerdi);
			koe2.innKoe(new Integer(kodeVerdi));
		}

		System.out.println("Dekodet melding blir:\n" + dekodet + "\n");
	}
}
