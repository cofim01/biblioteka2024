package biblioteka;

import java.util.ArrayList;

public class Knjiga {
	private long isbn;
	private String naslov;
	private ArrayList<Autor> autor;
	private String izdavac;
	private int izdanje;
	public long getIsbn() {
		return isbn;
	}
	public void setIsbn(long isbn) {
		this.isbn = isbn;
	}
	public String getNaslov() {
		return naslov;
	}
	public void setNaslov(String naslov) {
		this.naslov = naslov;
	}
	public ArrayList<Autor> getAutor() {
		return autor;
	}
	public void setAutor(ArrayList<Autor> autor) {
		this.autor = autor;
	}
	public String getIzdavac() {
		return izdavac;
	}
	public void setIzdavac(String izdavac) {
		this.izdavac = izdavac;
	}
	public int getIzdanje() {
		return izdanje;
	}
	public void setIzdanje(int izdanje) {
		this.izdanje = izdanje;
	}
	
	
	
	
	
	
}
