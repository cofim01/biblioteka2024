package biblioteka.interfejs;

import java.time.LocalDateTime;
import java.util.List;

import biblioteka.Autor;
import biblioteka.Knjiga;

public interface BibliotekaInterface {
	public LocalDateTime dodajKnjigu(Knjiga knjiga);
	public LocalDateTime obrisiKnjigu(Knjiga knjiga);
	public List<Knjiga> vratiSveKnjige();
	public List<Knjiga> pronadjiKnjigu(Autor autor, long ISBN,String naslov, String izdavac);
	
}
