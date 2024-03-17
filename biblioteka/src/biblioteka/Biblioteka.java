package biblioteka;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import biblioteka.interfejs.BibliotekaInterface;
import servis.Servis;

public class Biblioteka implements BibliotekaInterface {
	
	private List<Knjiga> knjige=new ArrayList<>();
	private Servis servis;
	
	public Biblioteka(Servis s) {
		servis=s;
	}
	
			
	@Override
	public LocalDateTime dodajKnjigu(Knjiga knjiga) {
		if(knjiga==null) {
			throw new NullPointerException("Knjiga ne sme biti null");
		}
		if(knjige.contains(knjiga)) {
			throw new IllegalArgumentException("Knjiga već postoji u biblioteci");
			
		}
		
		knjige.add(knjiga);
		return servis.vratiVreme("Beograd");
		
	}

	@Override
	public LocalDateTime obrisiKnjigu(Knjiga knjiga) {
		if(knjiga==null) {
			throw new NullPointerException("Knjiga ne sme biti null");
		}
		if(!knjige.contains(knjiga)) {
			throw new IllegalArgumentException("Knjiga ne postoji u biblioteci");
			
		}
		knjige.remove(knjiga);
		return servis.vratiVreme("Beograd");
	}

	@Override
	public List<Knjiga> vratiSveKnjige() {
		return knjige;
	}

	@Override
	public List<Knjiga> pronadjiKnjigu(Autor autor, long ISBN, String naslov, String izdavac) {
		if(autor==null && ISBN<=0 && naslov==null && izdavac==null)
			throw new IllegalArgumentException("Morate uneti bar neki kriterijum za pretragu");

		
		List<Knjiga> rezultati=new ArrayList<>();
		
		for (Knjiga k: knjige) {
			if(k.getNaslov().toUpperCase().contains(naslov.toUpperCase())) {
				rezultati.add(k);
			}
			
		}
		return rezultati;
	}
	
	
	
}
