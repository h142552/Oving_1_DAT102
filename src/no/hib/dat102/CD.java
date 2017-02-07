package no.hib.dat102;

public class CD {
	public static int antall = 0;
	private int cdNummer; 
	private int aar;
	private String artistnavn;
	private String tittel;
	private String plateselskap;
	private Sjanger sjanger;

	public CD() {} 
	
	// Konstruktør for nye cder. Oppretter cdNummer selv.
	public CD(String artistnavn, String tittel,
			int aar, String plateselskap, Sjanger sjanger) {
		this.artistnavn = artistnavn;
		this.tittel = tittel;
		this.aar = aar;
		this.plateselskap = plateselskap;
		this.sjanger = sjanger;
		this.cdNummer = antall++; // inkrementerer etter vi har fått verdien
	}

	// Konstruktør for cder som leses inn fra fil. Har cdNummer i parameterlisten
	public CD(String artistnavn, String tittel, 
			int aar, String plateselskap, Sjanger sjanger, int cdNummer) {
		this.artistnavn = artistnavn;
		this.tittel = tittel;
		this.aar = aar;
		this.plateselskap = plateselskap;
		this.sjanger = sjanger;
		this.cdNummer = cdNummer;
	}
	
	// get
	public static int getAntall()	{ return CD.antall; }
	public int getCdNummer()		{ return this.cdNummer; }
	public int getAar()				{ return this.aar; }
	public String getArtistnavn()   { return this.artistnavn; }
	public String getTittel() 	    { return this.tittel; }
	public String getPlateselskap() { return this.plateselskap; }
	public Sjanger getSjanger()     { return this.sjanger; }
	
	// set
	public static void setAntall(int antall) {CD.antall = antall; }
	public void setAar(int aar) { this.aar = aar; }
	public void setArtistnavn(String artistnavn) { this.artistnavn = artistnavn; }
	public void setTittel(String tittel) { this.tittel = tittel; }
	public void setPlateselskap(String plateselskap) { this.plateselskap = plateselskap; }
	public void setSjanger(Sjanger sjanger) { this.sjanger = sjanger; }
}
