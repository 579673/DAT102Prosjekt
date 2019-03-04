package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import no.hvl.dat102.mengde.adt.MengdeADT;

public abstract class MengdeTestBase<T extends MengdeADT<Integer>> {
	
	protected abstract MengdeADT<Integer> createInstance();
	
	private MengdeADT<Integer> m1;
	private MengdeADT<Integer> m2;
	private MengdeADT<Integer> union;
	private MengdeADT<Integer> snitt;
	private MengdeADT<Integer> differens;
	
	@BeforeEach
	void setUp() throws Exception {
		m1 = createInstance();
		m2 = createInstance();
		union = createInstance();
		snitt = createInstance();
		differens = createInstance();
		
		for (int i = 1; i < 6; i++) {
			m1.leggTil(i);		// {1, 2, 3, 4, 5}
			m2.leggTil(i+4); 	// {5, 6, 7, 8, 9}
			union.leggTil(i);
			union.leggTil(i+4);	// {1, 2, 3, 4, 5, 6, 7, 8, 9}
		}
		snitt.leggTil(5);  		// {5}
		differens.leggTilAlle(union);
		differens.fjern(5);		// {1, 2, 3, 4, 6, 7, 8, 9}
	}
	
	@Test
	void nyMengdeErTom() {
		m1 = createInstance();
		assertTrue(m1.antall() == 0);
		assertTrue(m1.erTom());
	}

	@Test
	void leggTilFungerer() {
		m1.leggTil(6);
		assertTrue(m1.inneholder(6));
	}
	
	@Test
	void fjernFungerer() {
		m1.fjern(1);
		assertTrue(!m1.inneholder(1));
	}
	
	@Test
	void leggTilAlleFungerer() {
		m1.leggTilAlle(m2);
		assertTrue(m1.equals(union));
	}
	
	@Test
	void unionFungerer() {
		assertTrue(m1.union(m2).equals(union));
	}
	
	@Test
	void snittFungerer() {
		assertTrue(m1.snitt(m2).equals(snitt));
	}
	
	@Test
	void differensFungerer() {
		assertTrue(m1.differens(m2).equals(differens));
	}
}
