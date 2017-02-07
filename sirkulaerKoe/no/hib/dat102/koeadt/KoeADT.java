package no.hib.dat102.koeadt;

//**************************************************************************
//  K�ADT.java      
//  Definerer interface til en samling k�. Sist oppdatert 25.01
//***************************************************************************


public interface KoeADT<T>{
	
 	/**
	 *  
	 * @param element som skal legges til bak i k�en
	 */
   public void innKoe (T element);
   

   /**
    * 
    * @return element T som returneres og fjernes fra k�en
    */
   public T utKoe();
   

   /**  
    * 
    * @return element T som returneres 
    */      
   public T foerste();
   
      
   /**
    * 
    * @return sann hvis k�en er tom ellers returneres usann
    */   
   public boolean erTom();
   

  /**
   * 
   * @return antall elementer i k�en
   */
   public int antall();
  
}//