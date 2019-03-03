package no.hvl.dat102.stabel;

//********************************************************************
//  EmptyCollectionException.java   //
//  Representerer situasjonen når samlingen er tom.
//********************************************************************

public class EmptyCollectionException extends Exception{
   /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

/******************************************************************
     Setter opp dette unntaket med passende melding.
   ******************************************************************/
   public EmptyCollectionException (String collection){
      super (" Denne " + collection + " er tom.");
   }
}
