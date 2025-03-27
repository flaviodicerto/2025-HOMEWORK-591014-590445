package it.uniroma3.diadia.giocatore;
import diadia.*;

public class Giocatore {
	public int CFU=20; //all'inizio sono 20
	public Borsa borsa;
	

	    public Giocatore() { // Costruttore senza parametri
	        this.CFU = 20; // Valore di default
	        this.borsa = new Borsa(); // Assicurati che sia inizializzata
	    }

	    public Giocatore(int CFU) { // Costruttore con parametro
	        this.CFU = CFU;
	        this.borsa = new Borsa();
	    }



	
	public int getCFU() {	return CFU; }
	public void setCFU(int CFU) {	this.CFU = CFU; }
	public Borsa getBorsa() {	return borsa; }
	public void setBorsa(Borsa borsa) {	this.borsa = borsa;	}
	public String toString() {	return  ", CFU=" + CFU + ", borsa=" + borsa + "]";}
	
	
}
