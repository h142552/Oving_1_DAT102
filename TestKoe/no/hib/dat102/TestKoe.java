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
	

	// Referanse til kø
	private KoeADT<Integer> koe;

	// Testdata
	private Integer e0 = 1;
	private Integer e1 = 2;
	private Integer e2 = 3;
	private Integer e3 = 4;
	private Integer e4 = 5;

	/**
	 * Hent en ny kø for hver test.
	 */
	@Before
	public final void setup() {
		koe = new SirkulaerKoe<Integer>();
	}

	/**
	 * Test på at en ny kø er tom.
	 */
	@Test
	public final void nyKoeErTom() {
		assertTrue(koe.erTom());
	}

	/**
	 * Test på innKoe and utKoe.
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
	 * Test på innKoe og utKoe med duplikate verdier.
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
	 * Testing på foerste.
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
	 * Test på at en koe med noen elementer ikke er tom.
	 */
	@Test
	public final void erIkkeTom() {
		koe.innKoe(e0);
		koe.innKoe(e1);
		assertFalse(koe.erTom());
	}

	/**
	 * Test på at en koe med null elementer er tom.
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
	 * Test på størrelsen
	 */
	@Test
	public final void stor() {
		koe.innKoe(e0);
		koe.innKoe(e1);
		koe.innKoe(e2);
		assertEquals(3, koe.antall());
	}

	/**
	 * Forsøk på utKoe av en tom koe skal gi "underflow excepton" *
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