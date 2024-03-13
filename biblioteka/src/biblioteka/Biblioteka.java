package biblioteka;

import java.util.ArrayList;
import java.util.List;

import biblioteka.interfejs.BibliotekaInterface;

public class Biblioteka implements BibliotekaInterface {
	
	private List<Knjiga> knjige;
	
	@Override
	public void dodajKnjigu(Knjiga knjiga) {
		if(knjiga==null) {
			throw new NullPointerException("Knjiga ne sme biti null");
		}
		if(knjige.contains(knjiga)) {
			throw new IllegalArgumentException("Knjiga već postoji u biblioteci");
			
		}
		
		knjige.add(knjiga);
		
	}

	@Override
	public void obrisiKnjigu(Knjiga knjiga) {
		if(knjiga==null) {
			throw new NullPointerException("Knjiga ne sme biti null");
		}
		if(!knjige.contains(knjiga)) {
			throw new IllegalArgumentException("Knjiga ne postoji u biblioteci");
			
		}
		knjige.remove(knjiga);		
	}

	@Override
	public List<Knjiga> vratiSveKnjige() {
		return knjige;
	}

	@Override
	public List<Knjiga> pronadjiKnjigu(Autor autor, long ISBN, String naslov, String izdavac) {
		if(autor==null && ISBN<=0 && naslov==null && izdavac==null)
			throw new IllegalArgumentException("Morati uneti bar neki kriterijum za pretragu");

		
		List<Knjiga> rezultati=new ArrayList<>();
		for (Knjiga k: knjige) {
			if(k.getNaslov().toUpperCase().contains(naslov.toUpperCase())) {
				rezultati.add(k);
			}
			
		}
		return rezultati;
	}
	
}
