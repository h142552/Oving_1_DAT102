package no.hib.dat102;
import no.hib.dat102.*;
import no.hib.dat102.koeadt.*;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/**
 * 
 * @author Eivind
 *
 */
public class TestKoe {
	

	// Referanse til k�
	private KoeADT<Integer> koe;

	// Testdata
	private Integer e0 = 1;
	private Integer e1 = 2;
	private Integer e2 = 3;
	private Integer e3 = 4;
	private Integer e4 = 5;

	/**
	 * Hent en ny k� for hver test.
	 */
	@Before
	public final void setup() {
		koe = new SirkulaerKoe<Integer>();
	}

	/**
	 * Test p� at en ny k� er tom.
	 */
	@Test
	public final void nyKoeErTom() {
		assertTrue(koe.erTom());
	}

	/**
	 * Test p� innKoe and utKoe.
	 */
	@Test
	public final void innKoeOgutKoe() {
		koe.innKoe(e0);
		koe.innKoe(e1);
		koe.innKoe(e2);
		koe.innKoe(e3);
		try {
			 assertEquals(e0, koe.utKoe());
			 assertEquals(e1, koe.utKoe());
			 assertEquals(e2, koe.utKoe());
			 assertEquals(e3, koe.utKoe());
		} catch (EmptyCollectionException e) {
			fail("utKoe feilet uventet " + e.getMessage());
		}
	}

	/**
	 * Test p� innKoe og utKoe med duplikate verdier.
	 */
	@Test
	public final void innKoeOgUtKoeMedDuplikater() {
		koe.innKoe(e0);
		koe.innKoe(e1);
		koe.innKoe(e1);
		koe.innKoe(e2);
		
		try {
			assertEquals(e0, koe.utKoe());
			assertEquals(e1, koe.utKoe());
			assertEquals(e1, koe.utKoe());
			assertEquals(e2, koe.utKoe());
			
		} catch (EmptyCollectionException e) {
			fail("utKoe feilet uventet " + e.getMessage());
		}
	}

	/**
	 * Testing p� foerste.
	 */
	@Test
	public final void innKoeUtKoeInnKoeInnKoeUtKoeFoerste() {
		try {
			koe.innKoe(e0);
			koe.utKoe();
			koe.innKoe(e1);
			koe.innKoe(e2);
			koe.utKoe();
			assertEquals(e2, koe.foerste());

		} catch (EmptyCollectionException e) {
			fail("utKoe eller foerstefeilet uventet " + e.getMessage());
		}
	}

	/**
	 * Test p� at en koe med noen elementer ikke er tom.
	 */
	@Test
	public final void erIkkeTom() {
		koe.innKoe(e0);
		koe.innKoe(e1);
		assertFalse(koe.erTom());
	}

	/**
	 * Test p� at en koe med null elementer er tom.
	 */
	@Test
	public final void innKoeUtKoeErTom() {
		try {
			koe.innKoe(e0);
			koe.utKoe();
			assertTrue(koe.erTom());

		} catch (EmptyCollectionException e) {
			fail("innKoe eller utKoe feilet uventet " + e.getMessage());
		}
	}

	/**
	 * Test p� st�rrelsen
	 */
	@Test
	public final void stor() {
		koe.innKoe(e0);
		koe.innKoe(e1);
		koe.innKoe(e2);
		assertEquals(3, koe.antall());
	}

	/**
	 * Fors�k p� utKoe av en tom koe skal gi "underflow excepton" *
	 * 
	 * @throws EmptyCollectionException
	 *             expected exception
	 */
	@Test(expected = EmptyCollectionException.class)
	public final void utKoeFromEmptyIsUnderflowed()
			throws EmptyCollectionException {
		koe.utKoe();
	}

}