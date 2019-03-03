package no.hvl.dat102;

import no.hvl.dat102.adt.StabelADT;

/**
 * Tabellimplementasjon av en stabel.
 * 
 * @param <T> elementtypen
 */
public class TabellStabel<T> implements StabelADT<T> {
    private final static int STDK = 100;
    private int topp; // indikerer neste plass
    private T[] stabel;

    /*
     * Oppretter en tom stabel.
     */
    public TabellStabel() {
        this(STDK);
    }

    /**
     * Oppretter en tom stabel med en spesifisert kapasitet.
     * 
     * @param initiell kapasitet
     */
    public TabellStabel(int startKapasitet) {
        topp = 0;
        stabel = (T[]) (new Object[startKapasitet]);
    }

    /**
     * Legger til det spesifiserte elementet på toppen av stabelen, utvider kapasitetet til stabelen hvis nødvendig.
     * 
     * @param element
     */
    @Override
    public void push(T element) {
        /*TODO
         * hvis antall er lik tabell-lengden, så utvid
         * 
         * sett stabelens topp-referanse lik element
         * 
         * øk topp med 1
         * 
         */
    }

    /**
     * Fjerner toppelementet og returnerer en referanse til den. Hvis stabelen er tom fra før, så returneres null
     * 
     * @return elementet som tas av 
     */
    @Override
    public T pop() {
    	/*TODO
    	 * 
    	 * initier ref.variabel resultat til null
    	 * 
    	 * hvis stabel ikke er tom så
    	 *    sett resultat til stabelens topp-referanse
    	 *    mink topp med 1
    	 *    sett stabelens topp-referanse til null
    	 * slutthvis
    	 * 
    	 * returner resultat
    	 * 
    	 */
        
        return null;
    }

    /**
     * Returnerer toppelementet uten å fjerne det.. Hvis stabelen er tom fra før, så returneres null
     * 
     * @return toppelementet
     */
    @Override
    public T peek() {
        T resultat = null;
        if (!erTom()) {
            resultat = stabel[topp-1];
        }

        return resultat;
    }

    /**
     * Returnerer sann hvis stabelen er tom og usann ellers.
     * 
     * @return sann hvis tom stabel
     */
    @Override
    public boolean erTom() {
        return topp == 0;
    }

    /**
     * Returnerer antall elementer.
     * 
     * @return antall elementer på stabelen
     */
    @Override
    public int antall() {
        return topp;
    }

    /**
     * Returns en strengrepresentasjon av stabelen..
     * 
     * @return strengrepresentasjon
     */
    @Override
    public String toString() {
        String resultat = "";

        for (int sok = 0; sok < topp; sok++) {
            resultat = resultat + stabel[sok].toString() + "\n";
        }

        return resultat;
    }

    /**
     * Oppretter en ny tabell for å lagre innholdet.
     */
    private void utvid() {
        T[] hjelpeTabell = (T[]) (new Object[stabel.length*2]);

        for (int indeks = 0; indeks < stabel.length; indeks++) {
            hjelpeTabell[indeks] = stabel[indeks];
        }

        stabel = hjelpeTabell;
    }
}
