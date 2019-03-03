package no.hib.dat102.tabell;
import no.hib.dat102.adt.StabelADT;
import no.hib.dat102.adt.StabelADTTest;

public class TabellStabelTest extends StabelADTTest{	

		@Override
		protected StabelADT<Integer> reset() {
			return new TabellStabel<Integer>();
		}
		// Her kan en vel legge til test på at stabelen
		// utvider seg
	}


