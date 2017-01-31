package hib.no.data102;

import hib.no.data102.adt.CDarkivADT;

public class CDarkiv2 implements CDarkivADT {
	
	private int antall;
	private LinearNode<CD> start;

	public CDarkiv2(){
		this.antall = 0;
	}
	
	@Override
	public CD[] hentCdTabell() {
		CD[] tabell = new CD[antall];
		LinearNode<CD> p = start;
		
		for(int i = 0; i < antall; i++) {
			tabell[i] = p.getElement();
			p = p.getNeste();
		}
		return tabell;
	}

	@Override
	public void leggTilCd(CD nyCd) {
		LinearNode<CD> nyNode = new LinearNode<CD>(nyCd);
		if(antall > 0){
			nyNode.setNeste(start);
			start = nyNode;
		}
		else{
			start = nyNode;
		}
		antall++;
	}

	@Override
	public boolean slettCd(int cdNr) {
		LinearNode<CD> p = this.start;
		LinearNode<CD> q = this.start;
		boolean funnet = false;

		for(int i = 0; i < this.antall && !funnet; i++) {
			if(p.getElement().getCdNummer() == cdNr) {
				if(p.equals(this.start))
					this.start = this.start.getNeste();
				else
					q.setNeste(p.getNeste());
				
				funnet = true;
			}
			q = p;
			p = p.getNeste();
		}
		return funnet;
	}

	@Override
	public CD[] sokTittel(String delstreng) {
		CD[] tabell = new CD[antall];
		LinearNode<CD> p = start;
		int i = 0;
		
		while(p != null) {
			if(p.getElement().getTittel().toLowerCase().contains(delstreng.toLowerCase())) {
				tabell[i] = p.getElement();
				i++;
			}
			p = p.getNeste();
		}
		
		CD[] tab = new CD[i];
		for(int j = 0; j < i; j++) {
			tab[j] = tabell[j];
		}
		
		return tab;
	}

	@Override
	public CD[] sokArtist(String delstreng) {
		CD[] tabell = new CD[antall];
		LinearNode<CD> p = start;
		int i = 0;
		
		while(p != null) {
			if(p.getElement().getArtistnavn().toLowerCase().contains(delstreng.toLowerCase())) {
				tabell[i] = p.getElement();
				i++;
			}
			p = p.getNeste();
		}
		
		CD[] tab = new CD[i];
		for(int j = 0; j < i; j++) {
			tab[j] = tabell[j];
		}
		
		return tab;
	}

	@Override
	public int hentAntall() {
		return antall;
	}

	@Override
	public int hentAntall(Sjanger sjanger) {
		LinearNode<CD> p = start;
		int i = 0;
		
		while(p != null) {
			if(p.getElement().getSjanger().equals(sjanger)) {
				i++;
			}
			p = p.getNeste();
		}
		
		return i;
	}

}
