package it.uniroma3.diadia.personaggi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class Mago extends AbstractPersonaggio{

	private static final String MESSAGGIO_DONO = "Sei un vero simpaticone, " +
												"con una mia magica azione, troverai un nuovo oggetto " +
												"per il tuo borsone!";
	private static final String MESSAGGIO_SCUSE = "Mi spiace, ma non ho piu' nulla...";
	private static final String MESSAGGIO_PRESENTAZIONE = " Sono un simpatico mago e amo far comparire oggetti";
	private static final String MESSAGGIO_REGALO = " Grazie per il regalo. NE DIMEZZERO' IL PESO!";
	
	private Attrezzo attrezzo;
	
	public Mago(String nome, Attrezzo attrezzo) {
		super(nome, MESSAGGIO_PRESENTAZIONE);
		this.attrezzo = attrezzo;
	}
	
	@Override
	public String agisci(Partita partita) {
		String msg;
		if (this.attrezzo!=null) {
			partita.getLabirinto().getStanzaCorrente().addAttrezzo(this.attrezzo);
			this.attrezzo = null;
			msg = MESSAGGIO_DONO;
		}
		else {
			msg = MESSAGGIO_SCUSE;
		}
		return msg;
	}

	@Override
	public String riceviRegalo(Attrezzo attrezzo, Partita partita) {
		int pesoAttrezzo = attrezzo.getPeso();
		pesoAttrezzo = pesoAttrezzo/2;
		attrezzo.setPeso(pesoAttrezzo);
		partita.getLabirinto().getStanzaCorrente().addAttrezzo(attrezzo);
		return MESSAGGIO_REGALO;
	}

}
