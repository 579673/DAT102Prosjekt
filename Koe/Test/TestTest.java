import static org.junit.Assert.*;

import org.junit.Test;

import no.hvl.dat102.exception.EmptyCollectionException;
import no.hvl.dat102.sirkulaer.SirkulaerKoe;

public class TestTest {
	SirkulaerKoe<Integer> koe = new SirkulaerKoe<>(5);
	
	int t0 = 0;
	int t1 = 1;
	@Test
	public void newStackIsEmpty() {
		assertTrue(koe.erTom());
	}
	@Test(expected = EmptyCollectionException.class)
	public void popFromEmptyThrowsException() throws EmptyCollectionException {
		koe.utKoe();
	}
	@Test
	public void addRemoveShouldWorkAndBeInOrder() {
		//Checks that elements come out in the correct 
		//order, and that it works in general
		koe.innKoe(t0);
		koe.innKoe(t1);
		assertEquals(t0, (int)koe.utKoe());
		assertEquals(t1, (int)koe.utKoe());
	}
	@Test
	public void overflowShouldExpandAndMaintainOrder() {
		koe = new SirkulaerKoe<>(5);
		int[] arr = {0, 1, 2, 3, 4, 5, 6, 7};
		
		for (int i : arr)
			koe.innKoe(i);
		assertTrue("antall() works", koe.antall() == 8);
		assertEquals(0, (int)koe.foerste());
		koe.utKoe();
		assertEquals("Elements are in order", 1, (int)koe.utKoe());
	}
	@Test
	public void circlingWorksAndMaintainsOrder() {
		koe = new SirkulaerKoe<>(5);
		for (int i = 0; i < 7; i++) {
			koe.innKoe(i);
			assertEquals("Desync", i, (int)koe.utKoe());
		}
		for (int i = 0; i < 7; i++)
			koe.innKoe(i);
		for (int i = 0; i < 7; i++)
			assertEquals("Queue works after circling", i, (int)koe.utKoe());
	}
}
