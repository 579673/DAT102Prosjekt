package no.hvl.dat102;

import no.hvl.dat102.adt.StabelADT;
import no.hvl.dat102.exception.EmptyCollectionException;

//  Tabellimplementasjon av en stabel.
//********************************************************************

public class TabellStabel<T> implements StabelADT<T> {
	private final static int STDK = 100;
	private int topp; // indikerer neste plass
	private T[] stabel;

	/*******************************************************************
	 * Oppretter en tom stabel.
	 *******************************************************************/
	
	public TabellStabel() {
		this(STDK);		
	}

	/*******************************************************************
	 * Oppretter en tom stabel med en speisfisert kapasitet.
	 *******************************************************************/
	public TabellStabel(int startKapasitet) {
		topp = 0;
		stabel = (T[]) (new Object[startKapasitet]);
	}

	/*******************************************************************
	 * Legger til det spesifiserte elementet på toppen av stabelen, utvider
	 * kapasiteten til stabelen hvis nødvendig.
	 *******************************************************************/
	@Override
	public void push(T element) {
		/*  TODO
		 * 
		 * hvis antall lik tabell-lengden, så utvid
		 * 
		 * sett stabelens topp-referanse til element
		 * 
		 * øk topp med 1
		 * 
		 */
	}

	/*************************************************************************
	 * 
	 * Fjerner toppelementet og returnerer en referanse til den. Hvis stabelen
	 * er tom fra før, så kastes unntak
	 *************************************************************************/
	@Override
	public T pop()  {
		/*
		 * TODO
		 * 
		 * Hvis stabel er tom, så kast unntak
		 * 
		 * mink topp med 1
		 * 
		 * sett ref.variabelen resulat lik referansen til topp-elementet
		 * 
		 * sett stabelens topp-referanse til null
		 * 
		 * returner resultat
		 * 
		 */			

		return null;
	}

	/**********************************************************************
	 * Returnerer toppelementet uten å fjerne det. Hvis stabelen er tom fra
	 * før,så kastes unntak
	 **********************************************************************/
	@Override
	public T peek()  {
		if (erTom())
			throw new EmptyCollectionException("Stabel");

		return stabel[topp-1];
	}

	/*******************************************************************
	 * Returnerer sann hvis stabelen er tom og usann ellers.
	 *******************************************************************/
	@Override
	public boolean erTom() {
		return (topp == 0);
	}

	/*******************************************************************
	 * Returnerer antall elementer.
	 *******************************************************************/
	@Override
	public int antall() {
		return topp;
	}

	
	/*******************************************************************
	 * Oppretter en ny tabell for å lagre innholdet.
	 *******************************************************************/
	private void utvid() {
		T[] hjelpeTabell = (T[]) (new Object[stabel.length * 2]);

		for (int indeks = 0; indeks < stabel.length; indeks++)
			hjelpeTabell[indeks] = stabel[indeks];

		stabel = hjelpeTabell;
	}
}
