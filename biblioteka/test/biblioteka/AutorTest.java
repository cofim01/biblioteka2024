package biblioteka;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class AutorTest {
	Autor a;
	
	@BeforeEach
	void setUp() throws Exception {
		a=new Autor();
	}

	@AfterEach
	void tearDown() throws Exception {
		a=null;
	}

	@Test
	void testAutor() {
		assertNotNull(a);
		assertNull(a.getIme());
		assertNull(a.getPrezime());
	}

	@Test
	void testAutorStringString() {
		a=new Autor("Pera", "Peric");
		assertNotNull(a);
		assertEquals("Pera", a.getIme());
		assertEquals("Peric", a.getPrezime());
	}

	

	@Test
	void testSetIme() {
		a.setIme("Zika");
		assertEquals("Zika", a.getIme());
	}
	@Test
	void testSetImeNull() {
		Exception e=assertThrows(java.lang.NullPointerException.class, ()->a.setIme(null));
		assertEquals("Ime ne sme biti null", e.getMessage());
	}
	
	@Test
	void testSetImePrazanString() {
		Exception e=assertThrows(java.lang.IllegalArgumentException.class, ()->a.setIme(""));
		assertEquals("Ime ne sme biti prazan string", e.getMessage());
	}
	

	@Test
	void testSetPrezime() {
		a.setPrezime("Zikic");
		assertEquals("Zikic", a.getPrezime());
	}
	
	@Test
	void testSetPrezimeNull() {
		Exception e=assertThrows(java.lang.NullPointerException.class, ()->a.setPrezime(null));
		assertEquals("Prezime ne sme biti null", e.getMessage());
	}

	@Test
	void testToString() {
		a.setIme("Mira");
		a.setPrezime("Miric");
		String s=a.toString();
		assertTrue(s.contains("Mira"));
		assertTrue(s.contains("Miric"));
	}

	@Test
	void testEqualsObject() {
		Autor b=a;
		assertTrue(a.equals(b));
	}
	
	@Test
	void testEqualsObjectNull() {
		Autor b=null;
		assertFalse(a.equals(b));
	}
	
	@Test
	void testEqualsObjectDrugaKlasa() {
		Knjiga k=new Knjiga();
		assertFalse(a.equals(k));
	}
	
	@ParameterizedTest
	@CsvSource({
		"Pera,Peric,Pera,Peric,true",
		"Mika, Mikic, Mika1,Mikic,false",
		"Sara,Saric, Sara, Saric, true",
		"Petar,Petrovic, Petar,Petrovic1,false"
	})
	void testEqualsObjectSveOk(String ime1,String prezime1,String ime2,String prezime2,Boolean vrednost) {
		a.setIme(ime1);
		a.setPrezime(prezime1);
		
		Autor a1=new Autor(ime2, prezime2);
		
		assertEquals(vrednost, a.equals(a1));
	}

}
