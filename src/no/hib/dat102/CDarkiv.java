package no.hib.dat102;

import no.hib.dat102.adt.CDarkivADT;

public class CDarkiv implements CDarkivADT {
	private CD[] cdTabell;
	private int antall;

	// Konstruktør
	public CDarkiv(int antallCDer) {
		this.cdTabell = new CD[antallCDer];
		this.antall = 0;
	}

	@Override // Returnerer en tabell av CD-er
	public CD[] hentCdTabell() {
		return this.cdTabell;
	}

	@Override // Legger til en ny CD i tabell
	public void leggTilCd(CD nyCd) {
		if(this.antall == this.cdTabell.length)
			utvidKapasitet();

		this.cdTabell[this.antall] = nyCd;
		this.antall++;
	}
	
	@Override // Sletter en CD dersom den fins
	public boolean slettCd(int cdNr) {
		for(int i = 0; i < this.antall; i++) {
			if(this.cdTabell[i].getCdNummer() == cdNr) {
				cdTabell[i] = cdTabell[antall - 1];
				antall--;
				//cdTabell = this.trimTabell(cdTabell, antall);
				return true;
			}
		}
		return false;
	}

	@Override // Søker og henter CD-er med en gitt delstreng
	public CD[] sokTittel(String delstreng) {
		CD[] cdTittel = new CD[this.antall];
		int antallTreff = 0;

		for(int i = 0; i < this.antall; i++) {
			if(this.cdTabell[i].getTittel().toLowerCase()
					.contains(delstreng.toLowerCase())) {
				cdTittel[antallTreff] = this.cdTabell[i]; // legg til cden i den nye tabellen
				antallTreff++;
			}
		}
		cdTittel = this.trimTabell(cdTittel, antallTreff);
		return cdTittel;
	}

	@Override // Søker og henter artister med en gitt delstreng
	public CD[] sokArtist(String delstreng) {
		CD[] cdArtist = new CD[this.antall];
		int antallTreff = 0;
		
		for(int i = 0; i < this.antall; i++) {
			if(this.cdTabell[i].getArtistnavn().toLowerCase()
					.equals(delstreng.toLowerCase())) {
				cdArtist[antallTreff] = this.cdTabell[i];
				antallTreff++;
			}
		}
		cdArtist = this.trimTabell(cdArtist, antallTreff);
		return cdArtist;
	}

	@Override // Henter antall CD-er
	public int hentAntall() {
		return this.antall;
	}

	@Override // Henter antall CD-er for en gitt sjanger
	public int hentAntall(Sjanger sjanger) {
		int antallCDISjanger = 0;
		for(int i = 0; i < this.antall; i++) {
			if (cdTabell[i].getSjanger() == sjanger)
				antallCDISjanger++;
		}

		return antallCDISjanger;
	}

	//
	// PRIVATE
	//
	// Utvider cdTabellen med 1
	private void utvidKapasitet() {
		double lengde;
		if(this.cdTabell.length == 0)
			lengde = 5.0;
		else
			lengde = Math.ceil((double)this.cdTabell.length * 1.1);

		CD[] hjelpetabell = new CD[(int)(lengde)];
		for(int i = 0; i < this.cdTabell.length; i++)
			hjelpetabell[i] = this.cdTabell[i];


		this.cdTabell = hjelpetabell;
	}

	// Trimmer tabellen til en viss størrelse
	private CD[] trimTabell(CD[] tabell, int n) {
		CD[] cdTabell2 = new CD[n];
		for(int i = 0; i < n; i++)
			cdTabell2[i] = tabell[i];

		return cdTabell2;
	}
}
