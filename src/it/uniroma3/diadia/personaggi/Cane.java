package it.uniroma3.diadia.personaggi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.giocatore.Borsa;

public class Cane extends AbstractPersonaggio{
	
	private final static String MESSAGGIO_PRESENTAZIONE = " BAU! BAU!";
	private final static String MESSAGGIO_MORSO = "RRRGH!"+ " -> nota che il morso ti ha tolto 2 CFU <-";
	private final static String MESSAGGIO_REGALO = "WOUF! WOUF!";

	private Borsa marsupio;
	private Attrezzo attrezzoCane;
	
	public Cane (String nome) {
		super(nome,MESSAGGIO_PRESENTAZIONE);
		this.marsupio = new Borsa();
		this.attrezzoCane = new Attrezzo("libro", 2);
		this.marsupio.addAttrezzo(this.attrezzoCane);
	}

	@Override
	public String agisci(Partita partita) {
		int nuoviCFU = partita.getGiocatore().getCFU()-2;
		partita.getGiocatore().setCFU(nuoviCFU);
		return MESSAGGIO_MORSO;
	}

	@Override
	public String riceviRegalo(Attrezzo attrezzo, Partita partita) {
		if(attrezzo.getNome().equals("osso") || attrezzo.getNome().equals("bastone")) {
			this.marsupio.addAttrezzo(attrezzo);
			partita.getLabirinto().getStanzaCorrente().addAttrezzo(attrezzoCane);
			return MESSAGGIO_REGALO;
		}
		partita.getLabirinto().getStanzaCorrente().addAttrezzo(attrezzo);
		return this.agisci(partita);
	}
}
