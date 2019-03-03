package test;

import no.hvl.dat102.mengde.adt.MengdeADT;
import no.hvl.dat102.mengde.tabell.TabellMengde;

class TabellMengdeTest extends MengdeTestBase<Integer> {
	
	@Override
	protected MengdeADT<Integer> createInstance() {
		return new TabellMengde<Integer>();
	}
	
}
