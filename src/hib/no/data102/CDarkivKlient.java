package hib.no.data102;

import hib.no.data102.adt.CDarkivADT;

public class CDarkivKlient {

	public static void main(String[] args) {
		// init
		CDarkivADT cda = Fil.lesFraFil("CDA.txt");
		CD.setAntall(cda.hentAntall());

		Meny meny = new Meny(cda);
		meny.start();
		
		/*
		 * Programstart:
		 *   Leser inn CDA fra fil
		 *   CDarkivADT cda = Fil.lesFraFil("CDA.txt");
		 *   starter meny, med valg om legge til, osvosv...
		 *   
		 * Slutt:
		 *   Lagrer CDA til fil
		 */
	
		// TESTING
/*
		Tekstgrensesnitt tekstgr = new Tekstgrensesnitt();

		CD cd1 = new CD("Pearl Jam", "Ten", 1991,
				"Epic Records", Sjanger.ROCK);
		CD cd2 = new CD("Pink Floyd", "The Dark Side of the Moon", 1973,
				"Harvest Records", Sjanger.ROCK);

		cda.leggTilCd(cd1);
		cda.leggTilCd(cd2);
		
		//tekstgr.skrivUtCdDelstrengITittel(cda, "moon");
		//tekstgr.skrivUtCdArtist(cda, "pearl jam");
		
		//Fil.skrivTilFil(cda, "CDA.txt");
		
		CDarkivADT cda2 = Fil.lesFraFil("CDA.txt");
		System.out.println(cda2.hentAntall());
		cda2.slettCd(0);
		System.out.println(cda2.hentAntall());

		cda2.leggTilCd(cd1);
		tekstgr.visCDer(cda2.hentCdTabell());
		tekstgr.visCDer(cda2.sokArtist("p"));
		
		tekstgr.skrivUtStatistikk(cda2);

*/
	}

}
