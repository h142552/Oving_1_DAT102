package hib.no.data102;

import java.util.Scanner;

import hib.no.data102.adt.CDarkivADT;

public class Tekstgrensesnitt {
	// Skriver ut en velkomstmelding
	public void velkommen() {
		System.out.println("Velkommen");
	}
	
	// Skriver ut menyen
	public void meny() {
		System.out.println("------------------------------------");
		System.out.println("(1)  - Legg til ny CD");
		System.out.println("(2)  - Skriv ut alle CDer i arkiv");
		System.out.println("(3)  - Skriv ut alle CDer fra med gitt tittel");
		System.out.println("(4)  - Skriv ut alle CDer fra en artist");
		System.out.println("(5)  - Skriv ut en oversikt over arkivet");
		System.out.println("(6)  - Slett en CD fra arkiv");
		System.out.println("(7)  - Hent antall CDer i arkiv");
		System.out.println("(8)  - Hent antall CDer innenfor en gitt sjanger");
		System.out.println("(9)  - Lagre arkiv til fil");
		System.out.println("(10) - Hent arkiv fra fil");
	}

	// Leser opplysningene om en CD fra tastatur
	public CD lesCD(Scanner sc) { 
		//Scanner sc = new Scanner(System.in);
		System.out.println("------------------------------------");
		System.out.println("Legge til ny CD:");
		System.out.println("Vennligst oppgi tittel: ");
		String tittel = sc.nextLine();

		System.out.println("Vennligst oppgi artistnavn: ");
		String artist = sc.nextLine();

		System.out.println("Vennligst oppgi utgivelsesår: ");
		int aar = Integer.parseInt(sc.nextLine()); // sc.nextInt() skaper trøbbel

		System.out.println("Vennligst oppgi sjanger[ROCK, POP, OPERA, CLASSIC]: ");
		String sjanger_str = sc.nextLine();
		Sjanger sjanger = Sjanger.finnSjanger(sjanger_str.toUpperCase());

		System.out.println("Vennligst oppgi plateselskap: ");
		String plateselskap = sc.nextLine();
		
		//sc.close();
		return new CD(artist, tittel, aar, plateselskap, sjanger);
	}

	// Viser en CD med alle opplysninger på skjerm 
	public void visCD(CD cd) {
		System.out.println("------------------------------------");
		System.out.println("Tittel:\t\t" + cd.getTittel());
		System.out.println("Artist:\t\t" + cd.getArtistnavn());
		System.out.println("Utgivelsesår:\t" + cd.getAar());
		System.out.println("Sjanger:\t" + cd.getSjanger());
		System.out.println("Plateselskap:\t" + cd.getPlateselskap());
		System.out.println("CD-Nummer:\t" + cd.getCdNummer());
	}

	public void visCDer(CDarkivADT cda) {
		for(int i = 0; i < cda.hentAntall(); i++)
			visCD(cda.hentCdTabell()[i]);
	}

	// Skriver ut alle CD-er med en spesiell delstreng i tittelen
	public void skrivUtCdDelstrengITittel(CDarkivADT cda, String delstreng) {
		for(int i = 0; i < cda.hentAntall(); i++)
			if(cda.hentCdTabell()[i].getTittel().toLowerCase()
					.contains(delstreng.toLowerCase()))
				visCD(cda.hentCdTabell()[i]);
	}

	// Skriver ut alle CD-er av en artist / en gruppe
	public void skrivUtCdArtist(CDarkivADT cda, String artist) {
		for(int i = 0; i < cda.hentAntall(); i++)
			if(cda.hentCdTabell()[i].getArtistnavn().toLowerCase()
					.contains(artist.toLowerCase()))
				visCD(cda.hentCdTabell()[i]);
	}

	// Skriver ut en enkel statistikk som inneholder antall CD-er totalt
	// og hvor mange det er i hver sjanger
	public void skrivUtStatistikk(CDarkivADT cda) {
		System.out.println("------------------------------------");
		System.out.println("Antall CD-er i arkiv: " + cda.hentAntall());
		for(Sjanger sjanger : Sjanger.values())
			System.out.println("Antall CD-er i sjanger " 
				+ sjanger.toString() + ": " + cda.hentAntall(sjanger));
	}
}
