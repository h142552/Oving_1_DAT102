package hib.no.data102;

public enum Sjanger {
	ROCK(0), POP(1), OPERA(2), CLASSIC(3), IKKEOPPGITT(4);
	private int nr;

	private Sjanger(int n) { //Konstruktør
		nr = n;
	}

	public int getNr() {
		return nr;
	}

	public static Sjanger finnSjanger(int n) {
		Sjanger sjang = Sjanger.IKKEOPPGITT;
		for (Sjanger sj : Sjanger.values()) {
			if (sj.nr == n) {
				sjang = sj;
				break;
			}
		}
		return sjang;
	}

	public static Sjanger finnSjanger(String navn){
		Sjanger sjang = Sjanger.IKKEOPPGITT;
		for (Sjanger sj : Sjanger.values()){
			if(sj.toString().equals(navn.toUpperCase())){
				sjang = sj;
				break;
			}
		}
		
		return sjang;
	}
}
