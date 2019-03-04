package test;

import no.hvl.dat102.mengde.kjedet.KjedetMengde;

class KjedetMengdeTest extends MengdeTestBase<KjedetMengde<Integer>> {
	
	@Override
	protected KjedetMengde<Integer> createInstance() {
		return new KjedetMengde<Integer>();
	}
	
}