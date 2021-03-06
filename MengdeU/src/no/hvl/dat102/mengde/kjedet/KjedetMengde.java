package no.hvl.dat102.mengde.kjedet;

//********************************************************************
// Kjedet implementasjon av en mengde. 
//********************************************************************
import java.util.*;

import no.hvl.dat102.mengde.adt.*;

public class KjedetMengde<T> implements MengdeADT<T> {
	private static Random rand = new Random();
	private int antall; // antall elementer i mengden
	private LinearNode<T> start;

	/**
	 * Oppretter en tom mengde.
	 */
	public KjedetMengde() {
		antall = 0;
		start = null;
	}//

	@Override
	public void leggTil(T element) {
		if (!(inneholder(element))) {
			LinearNode<T> node = new LinearNode<T>(element);
			node.setNeste(start);
			start = node;
			antall++;
		}
	}

	@Override
	public void leggTilAlle(MengdeADT<T> m2) {
		Iterator<T> teller = m2.oppramser();
		while (teller.hasNext()) {
			leggTil(teller.next());
		}
	}

	@Override
	public T fjernTilfeldig() {
		LinearNode<T> forgjenger, aktuell;
		T resultat = null;
		if (!erTom()) {
			int valg = rand.nextInt(antall) + 1;
			if (valg == 1) {
				resultat = start.getElement();
				start = start.getNeste();
			} else {
				forgjenger = start;
				for (int nr = 2; nr < valg; nr++) {
					forgjenger = forgjenger.getNeste();
				}
				aktuell = forgjenger.getNeste();
				resultat = aktuell.getElement();
				forgjenger.setNeste(aktuell.getNeste());
			}
			antall--;
		} // if
		return resultat;
	}
	/*
	//TODO: Fjern funker ikke skikkelig, m� fikses
	@Override
	public T fjern(T element) {
		if (antall == 0)
			return null;
		if (!this.inneholder(element))
			return null;
		
		LinearNode<T> forgjenger = null, aktuell = start;
		T resultat = null;
		
		while (resultat == null) {
			if (aktuell.getElement().equals(element)) {
				resultat = element;
				
				if (forgjenger == null) {
					if (aktuell.getNeste() == null) {
						start = null;
					} else if (aktuell.getNeste() != null) {
						start = aktuell.getNeste();
					}
				} else {
					if (aktuell.getNeste() == null)
						forgjenger.setNeste(null);
					else 
						forgjenger.setNeste(aktuell.getNeste());
				} 
			}
			forgjenger = aktuell;
			if (aktuell.getNeste() != null)
				aktuell = aktuell.getNeste();
		}
		return resultat;
	}*/
	
	@Override
    public T fjern(T element) {
        boolean funnet = false;
        LinearNode<T> forgjenger= start, aktuell = start;
       
        if(antall == 0) {
            return null;
        }
        else {
       
            if(start.getElement().equals(element)) {
                start = start.getNeste();
                antall--;
                return element;
            }else if(antall != 1){
                while(aktuell.getNeste() != null && !funnet) {
                    forgjenger = aktuell;
                    aktuell = aktuell.getNeste();
                   
                    if(aktuell.getElement().equals(element)) {
                        funnet = true;
                    }
                }
               
                if(funnet) {
                    forgjenger.setNeste(aktuell.getNeste());
                    antall--;
                    return element;
                } else {
                    return null;
                }
            } else {
                return null;
            }
        }
    }

	@Override
	public MengdeADT<T> union(MengdeADT<T> m2) {
		MengdeADT<T> begge = new KjedetMengde<T>();
		T element = null;

		Iterator<T> itr = m2.oppramser();
		while (itr.hasNext())
			((KjedetMengde<T>)begge).settInn((T)itr.next());
		
		itr = this.oppramser();
		while (itr.hasNext()) {
			element = (T)itr.next();
			if (!begge.inneholder(element))
				((KjedetMengde<T>)begge).settInn(element);
		}
		return begge;
	}

	@Override
	public MengdeADT<T> snitt(MengdeADT<T> m2) {
		MengdeADT<T> snittM = new KjedetMengde<T>();
		T element;
		
		Iterator<T> itr = m2.oppramser();
		while (itr.hasNext()) {
			element = (T)itr.next();
			if(this.inneholder(element))
				((KjedetMengde<T>)snittM).settInn(element);
		}
		return snittM;
	}

	@Override
	public MengdeADT<T> differens(MengdeADT<T> m2) {
		MengdeADT<T> differensM = new KjedetMengde<T>();
		T element;
		
		Iterator<T> itr = this.oppramser();
		while (itr.hasNext()) {
			element = (T)itr.next();
			if (!m2.inneholder(element))
				((KjedetMengde<T>)differensM).settInn(element);
		}
		/*itr = m2.oppramser();
		while (itr.hasNext()) {
			element = (T)itr.next();
			if (!this.inneholder(element))
				((KjedetMengde<T>)differensM).settInn(element);
		}*/
		return differensM;
	}

	@Override
	public boolean inneholder(T element) {
		boolean funnet = false;
		LinearNode<T> aktuell = start;
		for (int soek = 0; soek < antall && !funnet; soek++) {
			if (aktuell.getElement().equals(element)) {
				funnet = true;
			} else {
				aktuell = aktuell.getNeste();
			}
		}
		return funnet;
	}

	@Override
	public boolean equals(MengdeADT<T> m2) {
		T element = null;
		Iterator<T> itr = m2.oppramser();
		while (itr.hasNext()) {
			element = (T)itr.next();
			if (element != null && !this.inneholder(element))
				return false;
		}
		return true;
	}

	@Override
	public boolean erTom() {
		return antall == 0;
	}

	@Override
	public int antall() {
		return antall;
	}

	@Override
	public Iterator<T> oppramser() {
		return new KjedetIterator<T>(start);
	}
	
	@Override
	public boolean undermengde(MengdeADT<T> m2) {
		boolean erUnderMengde = true;
		//Fyll ut
		return erUnderMengde;
	}
	
	private void settInn(T element) {
		LinearNode<T> nyNode = new LinearNode<T>(element);
		nyNode.setNeste(start);
		start = nyNode;
		antall++;
	}
	/*
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
	}
	*/

}// class
