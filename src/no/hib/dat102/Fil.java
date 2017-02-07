package no.hib.dat102;

import java.io.*;

import no.hib.dat102.adt.CDarkivADT;

public class Fil {
	// Kan være static så lenge den er final. Metodene i Fil er også statiske
	final static String SKILLE = "#"; 


	// Lese et CDarkiv fra tekstfil
	public static CDarkivADT lesFraFil(String filnavn) {
		CDarkivADT cda = null; 
		int antall = 0; // antall cder i arkiv
		
		try(BufferedReader reader = new BufferedReader(new FileReader(filnavn))){
			antall = Integer.parseInt(reader.readLine()); // Leser første linje i filen
			cda = new CDarkiv2();
			CD cd;
			String linje = "";
			String[] felt;

			for(int i = 0; i < antall; i++) {
				linje = reader.readLine();
				felt = linje.split(Fil.SKILLE); 
				//[0] = cdnr, [1] = artist, [2] = tittel, [3] = år
				//[4] = sjanger, [5] = plateselskap
				cd = new CD(felt[1], felt[2], Integer.parseInt(felt[3]), 
						felt[5], Sjanger.finnSjanger(felt[4]), Integer.parseInt(felt[0]));
				cda.leggTilCd(cd);
			}
			
			reader.close();
		} catch (FileNotFoundException e) {
			//e.printStackTrace();
			return null;
		} catch (IOException e) {
			e.printStackTrace();
		}

		return cda;
	}

	// Lagre et CDarkiv til tekstfil
	public static boolean skrivTilFil(CDarkivADT cdarkiv, String filnavn) {
		try {
			File file = new File(filnavn);
			if(!file.exists())
				file.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
		}

		try(Writer writer = new BufferedWriter(new OutputStreamWriter(
				new FileOutputStream(filnavn), "utf-8"))) {
			writer.write(Integer.toString(cdarkiv.hentAntall()) + "\n");

			// nr#artist#tittel#år#sjanger#plateselskap 
			CD[] cdTabell = cdarkiv.hentCdTabell();
			for(int i = 0; i < cdarkiv.hentAntall(); i++) {
				writer.write(Integer.toString(cdTabell[i].getCdNummer()));
				writer.write(Fil.SKILLE);
				writer.write(cdTabell[i].getArtistnavn());
				writer.write(Fil.SKILLE);
				writer.write(cdTabell[i].getTittel());
				writer.write(Fil.SKILLE);
				writer.write(Integer.toString(cdTabell[i].getAar()));
				writer.write(Fil.SKILLE);
				writer.write(cdTabell[i].getSjanger().toString());
				writer.write(Fil.SKILLE);
				writer.write(cdTabell[i].getPlateselskap());
				writer.write("\n");
			}
			
			writer.close();
			return true;
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			return false;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return false;
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}
}
