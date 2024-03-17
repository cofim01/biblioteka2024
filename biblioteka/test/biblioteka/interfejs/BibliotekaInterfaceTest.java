package biblioteka.interfejs;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import biblioteka.Knjiga;

public abstract class BibliotekaInterfaceTest {
	BibliotekaInterface b;
	
	Knjiga k,k2;
	
	public abstract BibliotekaInterface getInstance();

	@BeforeEach
	void setUp() throws Exception {
		b=getInstance();
		
		k=new Knjiga();
		k.setIsbn(1234567890);
		k.setNaslov("Knjiga 1");
		k.setIzdanje(1);
		k.setIzdavac("Laguna");
		
		k2 = new Knjiga();
		k2.setIsbn(9987654321L);
		k2.setNaslov("Knjiga 2");
		k2.setIzdanje(2);
		k2.setIzdavac("Vulkan");
		
		
	}

	@AfterEach
	void tearDown() throws Exception {
		b=null;
		k=null;
		k2=null;
	}

	@Test
	void testDodajKnjiguNull() {
		Exception e=assertThrows(java.lang.NullPointerException.class, ()->b.dodajKnjigu(null));
		assertEquals("Knjiga ne sme biti null", e.getMessage());
		
	}

	@Test
	void testDodajKnjiguPostoji() {
		b.dodajKnjigu(k);
		Exception e=assertThrows(java.lang.IllegalArgumentException.class, ()->b.dodajKnjigu(k));
		assertEquals("Knjiga već postoji u biblioteci", e.getMessage());
	}
	
	@Test
	void testDodajKnjigu() {
		b.dodajKnjigu(k);
		
		List<Knjiga> sve=b.vratiSveKnjige();
		assertEquals(1, sve.size());
		assertEquals(k, sve.get(0));
	}
	
	@Test
	void testDodajKnjiguViseKomada() {
		b.dodajKnjigu(k);
		b.dodajKnjigu(k2);
		List<Knjiga> sve=b.vratiSveKnjige();
		
		assertEquals(2, sve.size());
		assertEquals(k, sve.get(0));
		assertEquals(k2, sve.get(1));
	}
	
	@Test
	void testObrisiKnjiguNull() {
		Exception e=assertThrows(java.lang.NullPointerException.class, ()->b.obrisiKnjigu(null));
		assertEquals("Knjiga ne sme biti null", e.getMessage());
	}
	
	@Test
	void testObrisiKnjiguNePostoji() {
		Exception e=assertThrows(java.lang.IllegalArgumentException.class, ()->b.obrisiKnjigu(k));
		assertEquals("Knjiga ne postoji u biblioteci", e.getMessage());
	}
	
	@Test
	void testObrisiKnjigu() {
		b.dodajKnjigu(k);
		b.dodajKnjigu(k2);
		b.obrisiKnjigu(k);
		List<Knjiga> sve=b.vratiSveKnjige();
		assertEquals(1, sve.size() );
		assertEquals(k2, sve.get(0));
	}

	
	@Test
	void testPronadjiKnjiguNull() {
		Exception e=assertThrows(java.lang.IllegalArgumentException.class, ()->b.pronadjiKnjigu(null, 0, null, null));
		assertEquals("Morate uneti bar neki kriterijum za pretragu", e.getMessage() );
	}
	
	@Test
	void testPronadjiKnjiguNemaRezultata() {
		b.dodajKnjigu(k);
		b.dodajKnjigu(k2);
		List<Knjiga> rezultat=b.pronadjiKnjigu(null, 0, "Avatar", null);
		assertEquals(0, rezultat.size());
	}
	
	@Test
	void testPronadjiKnjiguJedanRezultat() {
		b.dodajKnjigu(k);
		b.dodajKnjigu(k2);
		List<Knjiga> rezultat=b.pronadjiKnjigu(null, 0, "Knjiga 1", null);
		assertEquals(1, rezultat.size());
		assertEquals(k, rezultat.get(0));
	}
	
	@Test
	void testPronadjiKnjiguViseRezultata() {
		b.dodajKnjigu(k);
		b.dodajKnjigu(k2);
		List<Knjiga> rezultat=b.pronadjiKnjigu(null, 0, "Knjiga", null);
		assertEquals(2, rezultat.size());
		assertTrue(rezultat.contains(k));
		assertTrue(rezultat.contains(k2));
	}
	
	

}
