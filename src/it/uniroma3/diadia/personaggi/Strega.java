package it.uniroma3.diadia.personaggi;

import java.util.Iterator;

import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.ComparatoreStanzePerNumeroAttrezzi;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.giocatore.Borsa;

public class Strega extends AbstractPersonaggio{
	
	private final static String MESSAGGIO_PRESENTAZIONE = " Sono una nobile strega,se mi rispetti ti tratter� bene. Quindi... ATTENTO A COME TI RIVOLGI NEI MIEI CONFRONTI !! ";
	private final static String MESSAGGIO_PUNIZIONE = " NON MI HAI SALUTATO!! IMPARA A PORTARE RISPETTO!! TI HO SPEDITO NELLA STANZA CON MENO ATTREZZI !!";
	private final static String MESSAGGIO_PREMIO = "Tu si che sai parlare ad una signora! Sei stato premiato!";
	private final static String MESSAGGIO_REGALO = "AHAHAAHAHAHAAHAHAHAAHAHAHAAHAHAAHA!";
	
	private Borsa borsaStrega;
	
	public Strega(String nome) {
		super(nome,MESSAGGIO_PRESENTAZIONE);
		this.setBorsaStrega(new Borsa());
	}

	@Override
	public String agisci(Partita partita) {
		
		// CERCO LA STANZA CON IL MINOR NUMERO DI ATTREZZI E QUELLA CON IL MAGGIOR NUMERO DI ATTREZZI
		String msg;
		Set<String> insiemeDelleChiavi = partita.getLabirinto().getStanze().keySet();
		List<Stanza> listaDelleStanze = new LinkedList<Stanza>();
		Iterator<String> it = insiemeDelleChiavi.iterator();
		while(it.hasNext()) {
			String stringa = it.next();
			listaDelleStanze.add(partita.getLabirinto().getStanze().get(stringa));
		}
		listaDelleStanze.sort(new ComparatoreStanzePerNumeroAttrezzi());
		
		/*ESEGUO IL COMANDO*/
		if(partita.getLabirinto().getStanzaCorrente().getPersonaggio().haSalutato()==true) {
			partita.getLabirinto().setStanzaCorrente(listaDelleStanze.get(listaDelleStanze.size()-1));
			msg = MESSAGGIO_PREMIO;
		}
		else {
			if(listaDelleStanze.get(0).getNome().equals("Biblioteca")) {
				partita.getLabirinto().setStanzaCorrente(listaDelleStanze.get(1));
			}
			else {
				partita.getLabirinto().setStanzaCorrente(listaDelleStanze.get(0));
			}
			msg = MESSAGGIO_PUNIZIONE;
		}
		return msg;
	}

	@Override
	public String riceviRegalo(Attrezzo attrezzo, Partita partita) {
		this.borsaStrega.addAttrezzo(attrezzo);
		return MESSAGGIO_REGALO;
	}

	public Borsa getBorsaStrega() {
		return borsaStrega;
	}

	public void setBorsaStrega(Borsa borsaStrega) {
		this.borsaStrega = borsaStrega;
	}
}
