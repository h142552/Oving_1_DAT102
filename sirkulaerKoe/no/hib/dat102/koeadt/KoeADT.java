package no.hib.dat102.koeadt;

//**************************************************************************
//  KøADT.java      
//  Definerer interface til en samling kø. Sist oppdatert 25.01
//***************************************************************************


public interface KoeADT<T>{
	
 	/**
	 *  
	 * @param element som skal legges til bak i køen
	 */
   public void innKoe (T element);
   

   /**
    * 
    * @return element T som returneres og fjernes fra køen
    */
   public T utKoe();
   

   /**  
    * 
    * @return element T som returneres 
    */      
   public T foerste();
   
      
   /**
    * 
    * @return sann hvis køen er tom ellers returneres usann
    */   
   public boolean erTom();
   

  /**
   * 
   * @return antall elementer i køen
   */
   public int antall();
  
}//