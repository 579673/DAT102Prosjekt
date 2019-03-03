import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import no.hvl.dat102.mengde.adt.MengdeADT;
import no.hvl.dat102.mengde.kjedet.KjedetMengde;

class KjedetMengdeTest extends MengdeTestBase {
	
	@Override
	protected KjedetMengde<T> createInstance() {
		return new KjedetMengde<Integer>();
	}
	
}