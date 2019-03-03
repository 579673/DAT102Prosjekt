import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import no.hvl.dat102.mengde.adt.MengdeADT;
import no.hvl.dat102.mengde.kjedet.KjedetMengde;

public abstract class MengdeTestBase<T> {
	
	private T klasse;
	
	protected abstract T createInstance();
	
	private	MengdeADT<T> m1;
	private MengdeADT<T> m2;
	private MengdeADT<T> union;
	private MengdeADT<T> snitt;
	private MengdeADT<T> differens;
	
	@BeforeEach
	void setUp() throws Exception {
		m1 = createInstance();
		m2 = createInstance();
		union = createInstance();
		snitt = createInstance();
		differens = createInstance();
		
		m1.leggTilAlle(1, 2, 3, 4, 5);
		m2.leggTilAlle(5, 6, 7, 8, 9);
		union.leggTilAlle(1, 2, 3, 4, 5, 6, 7, 8, 9);
		snitt.leggTil(5);
		differens.leggTilAlle(1, 2, 3, 4, 6, 7, 8, 9);
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
		m1.leggTilAlle(new Integer[2] {6, 7});
		assertTrue(m1.inneholder(6) && m1.inneholder(7));
	}
	
	@Test
	void unionFungerer() {
		assertTrue(m1.union(m2).equals(union));
	}
	
	@Test
	void snittFungerer() {
		assertTrue(m1.snitt(m2).equals(union));
	}
	
	@Test
	void differensFungerer() {
		assertTrue(m1.differens(m2).equals(differens));
	}
}
