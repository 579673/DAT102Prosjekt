package no.hvl.dat102.kjedet;

import no.hvl.dat102.adt.KoeADT;
import no.hvl.dat102.exception.EmptyCollectionException;
import no.hvl.dat102.node.LinearNode;

public class KjedetKoe<T> implements KoeADT<T> {
	private LinearNode<T> start;
	private LinearNode<T> slutt;
	private int antall;
	
	public KjedetKoe() {
		this(null);
	}
	public KjedetKoe(T el) {
		this.start = new LinearNode<T>(el);
		this.slutt = start;
	}
	@Override
	public void innKoe(T element) {
		if (antall == 0) {
			start.setElement(element);
			slutt = start;
		}
		else {
			LinearNode<T> temp = new LinearNode<T>(element);
			start.setNeste(temp);
			start = temp;
		}
		antall++;
	}
	@Override
	public T utKoe() {
		LinearNode<T> temp = slutt;
		if (antall == 0)
			throw new EmptyCollectionException("Køen er tom");
		else if (antall == 1) {
			slutt = new LinearNode<T>(null);
			start = slutt;
		}
		slutt = slutt.getNeste();
		antall--;
		return temp.getElement();
	}
	@Override
	public T foerste() {
		if (erTom())
			return slutt.getElement();
		else 
			throw new EmptyCollectionException("Køen er tom");
	}
	@Override
	public boolean erTom() {
		return antall == 0;
	}
	@Override
	public int antall() {
		return antall;
	}
}
