package no.hib.dat102.kjedet;

import no.hib.dat102.adt.StabelADT;
import no.hib.dat102.adt.StabelADTTest;

public class KjedetStabelTest extends StabelADTTest {
	   @Override
		protected StabelADT<Integer> reset() {
			return new KjedetStabel<Integer>();
		}		
}
