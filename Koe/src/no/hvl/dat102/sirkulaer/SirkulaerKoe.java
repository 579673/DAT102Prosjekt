package no.hvl.dat102.sirkulaer;

import no.hvl.dat102.adt.KoeADT;
import no.hvl.dat102.exception.EmptyCollectionException;

import org.junit.Before;
import org.junit.Test;

public class SirkulaerKoe<T> implements KoeADT<T> {
	private T[] sirkel;
	private int front;
	private int rear;
	private int count;
	
	private static int STDK = 100;
	
	public SirkulaerKoe() {
		this(STDK);
	}
	
	public SirkulaerKoe(int size) {
		sirkel = (T[]) (new Object[size]);
		front = rear = count = 0;
		
	}
	@Override
	public void innKoe(T element) {
		if(count >= sirkel.length) {
			utvid();
		}
		sirkel[rear] = element; 
		count++;
		rear = (rear+1) % sirkel.length;
	}
	private void utvid() {
		T[] temp = (T[])(new Object[sirkel.length*2]);
		for (int i = front; i < front+count; i++)
			temp[i-front] = sirkel[i%sirkel.length];
		sirkel = temp;
		front = 0;
		rear = count;
	}

	@Override
	public T utKoe() {
		if(erTom()) {
			throw new EmptyCollectionException("sirkel er tom");
		}
		T result = sirkel[front];
		sirkel[front] = null;
		
		front = (front+1) % sirkel.length;
		
		count--;
		
		return result;
	}

	@Override
	public T foerste() {
		return sirkel[front];
	}

	@Override
	public boolean erTom() {
		return count == 0;
	}

	@Override
	public int antall() {
		return count;
	}
}
