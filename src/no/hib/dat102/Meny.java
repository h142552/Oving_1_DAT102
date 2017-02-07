package no.hib.dat102;

import java.util.Scanner;

import no.hib.dat102.adt.CDarkivADT;

public class Meny {
	private final String FILNAVN = "CDA.txt";
	private Tekstgrensesnitt tekstgr;
	private CDarkivADT cda;

	public Meny(CDarkivADT cda) {
		this.tekstgr = new Tekstgrensesnitt();
		this.cda = cda;
	}
	
	public void start() {
		Scanner sc = new Scanner(System.in);
		boolean fortsett = true;
		this.tekstgr.velkommen();
		
		while(fortsett) {
			this.tekstgr.meny();
			String valg = sc.nextLine(); // catch null-input && char/streng
			
			switch(valg) {
			case "1": // Legg til ny CD
				this.cda.leggTilCd(this.tekstgr.lesCD(sc));
				break;
			case "2": // Skriv ut CDer i arkiv
				this.tekstgr.visCDer(this.cda);
				break;
			case "3": // Skriv ut CDer med en gitt delstreng
				System.out.println("Skriv inn tittel: ");
				String tittel = sc.nextLine();
				this.tekstgr.skrivUtCdDelstrengITittel(this.cda, tittel);
				break;
			case "4": // Skriv ut CDer av en gitt artist
				System.out.println("Skriv inn artistnavn/gruppe: ");
				String artist = sc.nextLine();
				this.tekstgr.skrivUtCdArtist(this.cda, artist);
				break;
			case "5": // Skriv ut statistikk/oversikt
				this.tekstgr.skrivUtStatistikk(this.cda);
				break;
			case "6": // Slett CD fra arkiv
				System.out.println("Skriv in CD-Nummer til CD som skal slettes: ");
				int nummer = Integer.parseInt(sc.nextLine());
				this.cda.slettCd(nummer);
				break;
			case "7": // Hent antall CDer i arkiv
				System.out.println("Antall CDer i arkiv: " + this.cda.hentAntall());
				break;
			case "8": // Hent antall CDer i en gitt sjanger
				System.out.println("Skriv sjanger(ROCK, POP, CLASSIC, OPERA): ");
				Sjanger sjanger = Sjanger.finnSjanger(sc.nextLine());
				System.out.println("Antall CDer i sjangeren " + sjanger.toString() 
					+ ": " + this.cda.hentAntall(sjanger));
				break;
			case "9": // Lagre til fil
				if(Fil.skrivTilFil(this.cda, this.FILNAVN))
					System.out.println("Arkivet ble lagret til fil.");
				else
					System.out.println("OBS! Noe gitt galt under lagring til fil");
				break;
			case "10": // Hent fra fil
				this.cda = Fil.lesFraFil(this.FILNAVN);
				System.out.println("Arkiv hentet fra fil.");
				break;
			default:
				fortsett = false;
				System.out.println("Program terminert");
				break;
			}
		}
		sc.close();
	}
}
