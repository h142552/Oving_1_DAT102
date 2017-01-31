package hib.no.data102;

import hib.no.data102.adt.CDarkivADT;

public class CDarkiv2 implements CDarkivADT {
	
	private int antall;
	private LinearNode<CD> start;

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
		nyNode.setNeste(start);
		start = nyNode;
		antall++;
	}

	@Override
	public boolean slettCd(int cdNr) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public CD[] sokTittel(String delstreng) {
		CD[] tabell = new CD[antall];
		LinearNode<CD> p = start;
		int i = 0;
		
		while(p.getNeste() != null) {
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
		
		while(p.getNeste() != null) {
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
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int hentAntall(Sjanger sjanger) {
		// TODO Auto-generated method stub
		return 0;
	}

}
