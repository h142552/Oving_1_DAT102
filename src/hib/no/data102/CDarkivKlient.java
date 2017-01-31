package hib.no.data102;

import hib.no.data102.adt.CDarkivADT;

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
