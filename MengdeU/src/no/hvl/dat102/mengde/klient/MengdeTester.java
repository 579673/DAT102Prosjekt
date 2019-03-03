package no.hvl.dat102.mengde.klient;

import java.util.Iterator;

import no.hvl.dat102.mengde.tabell.TabellMengde;

public class MengdeTester {

	public static void main(String[] args) {
		TabellMengde<Integer> t = new TabellMengde<>();
		t.leggTil(1);
		t.leggTil(2);
		t.leggTil(3);
		
		TabellMengde<Integer> t2 = new TabellMengde<>();
		t2.leggTil(1);
		t2.leggTil(2);
		t2.leggTil(3);
		t2.leggTil(4);
		
		System.out.println(t.equals(t2));
		t2.fjern(4);
		System.out.println(t.equals(t2));
		
		t2.fjern(2);
		
		Iterator itr = t2.oppramser();
		while (itr.hasNext())
			System.out.println(itr.next());
	}

}
