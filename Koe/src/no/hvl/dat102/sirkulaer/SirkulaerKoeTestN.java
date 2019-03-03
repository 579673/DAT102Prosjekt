package no.hvl.dat102.sirkulaer;

import static org.junit.Assert.*;

import org.junit.Test;

public class SirkulaerKoeTestN {

	@Test
	public void test() {
		nyStabelErTom();
	}

	
	private int e0 = 0;
	private int e1 = 1;
	private int e2 = 2;
	private int e3 = 3;
	
	private SirkulaerKoe<Integer> koe;
	
	public final void setup() {
		koe = new SirkulaerKoe<>();
	}
	public final void nyStabelErTom() {
		System.out.println(koe.antall());
		assertTrue(koe.erTom());
	}
}
