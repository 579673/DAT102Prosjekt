package no.hvl.dat102;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import no.hvl.dat102.TabellStabel;
import no.hvl.dat102.adt.StabelADT;
import no.hvl.dat102.exception.EmptyCollectionException;

/**
 * Test for StackADT.
 * 
 * @author Ole Olsen
 */
public class StabelADTTest {

	/**
	 * Size of the tested stabel.
	 */
	protected static final int SIZE = 10;

	// The stabel
	private StabelADT<Integer> stabel;

	// Test data
	private Integer e0 = 1;
	private Integer e1 = 2;
	private Integer e2 = 3;
	private Integer e3 = 4;
	private Integer e4 = 5;
	private Integer e5 = 6;

	/**
	 * Get a new stabel for each test.
	 */
	@Before
	public final void setup() {
		stabel = new TabellStabel<Integer>(SIZE);
	}

	/**
	 * Test that a new stabel is empty.
	 */
	@Test
	public final void newStackIsEmpty() {
		assertTrue(stabel.erTom());
	}

	/**
	 * Test on push and pop.
	 */
	@Test
	public final void pushAndPop() {

		stabel.push(e0);
		stabel.push(e1);
		stabel.push(e2);
		stabel.push(e3);

		try {
			assertEquals(e3, stabel.pop());
			assertEquals(e2, stabel.pop());
			assertEquals(e1, stabel.pop());
			assertEquals(e0, stabel.pop());
		} catch (EmptyCollectionException e) {
			fail("pop failed unexpectedly " + e.getMessage());
		}
	}

	/**
	 * Test on push and pop with duplicated values.
	 */
	@Test
	public final void pushAndPopWithDuplicates() {

		stabel.push(e0);
		stabel.push(e1);
		stabel.push(e1);
		stabel.push(e2);

		try {
			assertEquals(e2, stabel.pop());
			assertEquals(e1, stabel.pop());
			assertEquals(e1, stabel.pop());
			assertEquals(e0, stabel.pop());
		} catch (EmptyCollectionException e) {
			fail("pop failed unexpectedly " + e.getMessage());
		}
	}

	/**
	 * Testing top.
	 */
	@Test
	public final void pushPopPushPushPopPeek() {
		try {
			stabel.push(e2);
			stabel.pop();
			stabel.push(e3);
			stabel.push(e4);
			stabel.pop();
			assertEquals(e3, stabel.peek());

		} catch (EmptyCollectionException e) {
			fail("pop or top failed unexpectedly " + e.getMessage());
		}
	}

	/**
	 * Test that a stabel with element(s) is not empty.
	 */
	@Test
	public final void isNotEmpty() {
		stabel.push(e0);
		assertFalse(stabel.erTom());
	}

	/**
	 * Test that a push - pop operation on an empty stabel gives an empty
	 * stabel.
	 */
	@Test
	public final void pushPopIsEmpty() {
		try {
			stabel.push(e0);
			stabel.pop();
			assertTrue(stabel.erTom());
		} catch (EmptyCollectionException e) {
			fail("pop failed unexpectedly " + e.getMessage());
		}
	}
	
	
	/**
	 * Trying to pop an element from an empty stabel, should give an underflow
	 * exception.
	 * 
	 * 	 */
	@Test(expected = EmptyCollectionException.class)
	public final void popFromEmptyIsUnderflowed() {
		stabel.pop();
	}
	
	/**
     * Tester om stabelen utvider seg riktig. Stabler på to flere elementer 
     * enn stabeltabellen har plass til, sjekker om antallet er riktig,
     * tar ut og sjekker første element, tar ut de i "midten",
     * tar ut og sjekker det siste elementet og sjekker til slutt
     * at stabel er tom slik det forventes.
     */
	
    @Test
    public final void utviderKoeSeg() {
        stabel.push(e1);
        for (int i = 0; i < SIZE; i++) {
            stabel.push(e0);
        }
        stabel.push(e2);
        assertEquals(SIZE + 2, stabel.antall());
        assertEquals(e2, stabel.pop());
        for (int i = 0; i < SIZE; i++) {
            stabel.pop();
        }
        assertEquals(e1, stabel.pop());
        assertTrue(stabel.erTom());
    }

}
