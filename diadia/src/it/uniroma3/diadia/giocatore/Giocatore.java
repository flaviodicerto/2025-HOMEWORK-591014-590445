package it.uniroma3.diadia.giocatore;

public class Giocatore {
	public int CFU=20; //all'inizio sono 20
	public Borsa borsa;
	
	public void Giocatore (String nome,int CFU)
	{
		this.nome=nome;
		this.CFU=CFU;
	}

	public String getNome() { return nome; }
	public void setNome(String nome) {	this.nome = nome; }
	public int getCFU() {	return CFU; }
	public void setCFU(int CFU) {	this.CFU = CFU; }
	public Borsa getBorsa() {	return borsa; }
	public void setBorsa(Borsa borsa) {	this.borsa = borsa;	}
	public String toString() {	return "Giocatore [nome=" + nome + ", CFU=" + CFU + ", borsa=" + borsa + "]";}
	
	
}
