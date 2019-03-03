package no.hvl.dat102.klienter;

public class Kunde {

	private int ankTid, ferdigTid;

	public Kunde(int tid) {
		ankTid = tid;
		ferdigTid = 0;
	}

	public int hentAnkTid() {
		return ankTid;
	}

	public void nyFerdigTid(int nytid) {
		ferdigTid = nytid;
	}

	public int hentFerdigTid() {
		return ferdigTid;
	}

	public int totalTid() {
		return ferdigTid - ankTid;
	}
}