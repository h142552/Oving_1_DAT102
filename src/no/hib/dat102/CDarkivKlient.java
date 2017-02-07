package no.hib.dat102;

import no.hib.dat102.adt.CDarkivADT;

public class CDarkivKlient {

	public static void main(String[] args) {
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
