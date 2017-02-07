package no.hib.dat102;

import no.hib.dat102.adt.CDarkivADT;

public class CDarkivKlient {

	public static void main(String[] args) {
		/**
		 * For å bruke CDarkiv (tabellimplementasjon) endres 
		 * CDarkiv2() til CDarkiv() i denne filen og 
		 * i Fil.java (lesFraFil()). 
		 */
		// init
		CDarkivADT cda = Fil.lesFraFil("CDA.txt");
		if(cda == null) {
			cda = new CDarkiv2();
			Fil.skrivTilFil(cda, "CDA.txt");
		}
		else
			CD.setAntall(cda.hentAntall());


		Meny meny = new Meny(cda);
		meny.start();
	}
}
