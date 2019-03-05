package no.hvl.dat102.mengde.klient;

import java.util.Iterator;

import no.hvl.dat102.mengde.kjedet.KjedetMengde;

public class MengdeTester {

	public static void main(String[] args) {
		KjedetMengde<Integer> t = new KjedetMengde<>();
		t.leggTil(1);
		t.leggTil(2);
		t.leggTil(3);
		
		KjedetMengde<Integer> t2 = new KjedetMengde<>();
		t2.leggTil(1);
		t2.leggTil(2);
		t2.leggTil(3);
		t2.leggTil(4);
		
		KjedetMengde<Integer> snitt = (KjedetMengde<Integer>)(t.snitt(t2));
		Iterator<Integer> itr1 = snitt.oppramser();
		while (itr1.hasNext())
			System.out.println(itr1.next());
		
		System.out.println(t.equals(t2));
		t2.fjern(4);
		System.out.println(t.equals(t2));
		
		t2.fjern(2);
		
		Iterator<Integer> itr = t2.oppramser();
		while (itr.hasNext())
			System.out.println(itr.next());
	}

}
