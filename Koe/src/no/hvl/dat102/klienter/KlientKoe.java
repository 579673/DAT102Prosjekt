package no.hvl.dat102.klienter;

import no.hvl.dat102.tabell.TabellKoe;

public class KlientKoe {
	public static void main(String[] args) {
		
		TabellKoe<Character> tegnKoe = new TabellKoe<Character>();

		String streng = " Denne koen er en FIFO datastruktur.";
		int lengde = streng.length();

		for (int i = 0; i < lengde; i++) {
			tegnKoe.innKoe(new Character(streng.charAt(i)));
		}
		while (!tegnKoe.erTom()) {
			Character tegn_obj =  tegnKoe.utKoe();
			System.out.print(tegn_obj);
		}

	}

}// class
