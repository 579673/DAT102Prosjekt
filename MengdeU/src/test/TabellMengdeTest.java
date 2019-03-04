package test;

import no.hvl.dat102.mengde.tabell.TabellMengde;

class TabellMengdeTest extends MengdeTestBase<TabellMengde<Integer>> {
	
	@Override
	protected TabellMengde<Integer> createInstance() {
		return new TabellMengde<Integer>();
	}
	
}
