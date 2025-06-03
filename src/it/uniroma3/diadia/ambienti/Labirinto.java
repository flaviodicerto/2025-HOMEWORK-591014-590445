package it.uniroma3.diadia.ambienti;

import java.util.HashMap;
import java.util.Map;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.personaggi.Cane;
import it.uniroma3.diadia.personaggi.Mago;
import it.uniroma3.diadia.personaggi.Strega;


/**
 * CLASSE CHE MODELLA E COSTRUISCE IL LABIRINTO DELLA PARTITA
 * 
 * @author 591014 - 590445 
 * @see Stanza
 * @version 1.0
 *
 */
public class Labirinto {
	
	private Stanza stanzaCorrente;
	private Stanza stanzaVincente;
	private Stanza ultimaStanzaAggiunta;
	private Map<String, Stanza> stanze;
	
	public Labirinto() {
		this.stanze = new HashMap<String, Stanza>();
	}
	
	/**
     * CREA TUTTE LE STANZE E LE PORTE DI COLLEGAMENTO
     */
    public void creaStanze() {

		/* CREA GLI ATTREZZI */
    	Attrezzo lanterna = new Attrezzo("lanterna",3);
		Attrezzo osso = new Attrezzo("osso",1);
		Attrezzo vaso = new Attrezzo("vaso",4);
		Attrezzo chiave = new Attrezzo("chiave",1);
		Attrezzo sedia = new Attrezzo("sedia",3);
		Attrezzo bastone = new Attrezzo("bastone",3);
		Attrezzo bacchetta = new Attrezzo("bacchetta",1);
		
		/*CREA I VARI PERSONAGGI */
		Mago mago = new Mago("Merlino",bacchetta);
		Strega strega = new Strega("Matilda");
		Cane cane = new Cane("Pluto");
    	
		/* CREA LE STANZE DEL LABIRINTO */
		Stanza atrio = new Stanza("Atrio");
		Stanza aulaN11 = new Stanza("Aula N11");
		Stanza aulaN10 = new Stanza("Aula N10");
		Stanza laboratorio = new Stanza("Laboratorio Campus");
		Stanza biblioteca = new Stanza("Biblioteca");
		StanzaMagica aulaN12 = new StanzaMagica("Aula N12");
		StanzaBuia aulaN13 = new StanzaBuia("Aula N13");
		StanzaBloccata aulaN14 = new StanzaBloccata("Aula N14","nord");
		
		/*AGGIUNGE LE STANZE ALLA MAPPA CONTENENTE TUTTE LE STANZE*/
		this.stanze.put("Atrio",atrio);
		this.stanze.put("Aula N11", aulaN11);
		this.stanze.put("Aula N10", aulaN10);
		this.stanze.put("Laboratorio Campus", laboratorio);
		this.stanze.put("Biblioteca", biblioteca);
		this.stanze.put("Aula N12", aulaN12);
		this.stanze.put("Aula N13", aulaN13);
		this.stanze.put("Aula N14", aulaN14);
		
		/* COLLEGA LE STANZE */
		atrio.impostaStanzaAdiacente("nord", biblioteca);
		atrio.impostaStanzaAdiacente("est", aulaN11);
		atrio.impostaStanzaAdiacente("sud", aulaN10);
		atrio.impostaStanzaAdiacente("ovest", laboratorio);
		aulaN11.impostaStanzaAdiacente("est", laboratorio);
		aulaN11.impostaStanzaAdiacente("ovest", atrio);
		aulaN11.impostaStanzaAdiacente("sud", aulaN13);
		aulaN10.impostaStanzaAdiacente("nord", atrio);
		aulaN10.impostaStanzaAdiacente("est", aulaN11);
		aulaN10.impostaStanzaAdiacente("ovest", laboratorio);
		aulaN10.impostaStanzaAdiacente("sud", aulaN12);
		laboratorio.impostaStanzaAdiacente("est", atrio);
		laboratorio.impostaStanzaAdiacente("ovest", aulaN11);
		biblioteca.impostaStanzaAdiacente("sud", atrio);
		aulaN12.impostaStanzaAdiacente("nord", aulaN10);
		aulaN12.impostaStanzaAdiacente("est", aulaN13);
		aulaN12.impostaStanzaAdiacente("ovest", aulaN14);
		aulaN13.impostaStanzaAdiacente("ovest", aulaN12);
		aulaN13.impostaStanzaAdiacente("nord", aulaN11);
		aulaN14.impostaStanzaAdiacente("est", aulaN12);
		aulaN14.impostaStanzaAdiacente("nord", laboratorio);

        /* INSERISCE GLI ATTREZZI NELLE STANZE */
		aulaN10.addAttrezzo(lanterna);
		aulaN11.addAttrezzo(bastone);
		atrio.addAttrezzo(osso);
		aulaN12.addAttrezzo(vaso);
		aulaN13.addAttrezzo(chiave);
		aulaN14.addAttrezzo(sedia);
		
		/* INSERISCO I PERSONAGGI NELLE RISPETTIVE STANZE */
		aulaN10.setPersonaggio(mago);
		laboratorio.setPersonaggio(cane);
		aulaN11.setPersonaggio(strega);

		// NOTARE CHE IL GIOCO LO FACCIAMO COMINCIARE DALL'ATRIO 
        this.stanzaCorrente = atrio;  
		this.stanzaVincente = biblioteca;
    }
    
    
    /**
     * RESTITUISCE LA STANZA VINCENTE DEL GIOCO
     * @return stanzaVincente;
     */
    public Stanza getStanzaVincente() {
		return stanzaVincente;
	}
    
    /**
     * MEMORIZZA LA STANZA VINCENTE. SE IL GIOCATORE ARRIVA
     * IN QUESTA STANZA, VINCE IL GIOCO
     * @param stanzaVincente
     */
    public void setStanzaVincente(Stanza stanzaVincente) {
    	this.stanzaVincente=stanzaVincente;
    }

    /**
     * MEMORIZZA LA STANZA IN CUI SI TROVA IL GIOCATORE
     * @param stanzaCorrente
     */
	public void setStanzaCorrente(Stanza stanzaCorrente) {
		this.stanzaCorrente = stanzaCorrente;
	}

	/**
	 * RESTITUISCE LA STANZA IN CUI SI TROVA IL GIOCATORE
	 * @return stanzaCorrente
	 */
	public Stanza getStanzaCorrente() {
		return this.stanzaCorrente;
	}
	
	public Labirinto getLabirinto() {
		return this;
	}
	
	public void setUltimaStanzaAggiunta(Stanza ultimaAggiunta) {
		this.ultimaStanzaAggiunta = ultimaAggiunta;
	}
	
	public Stanza getUltimaStanzaAggiunta() {
		return this.ultimaStanzaAggiunta;
	}
	
	public void setStanze(Map<String, Stanza> stanze) {
		this.stanze = stanze;
	}
	
	public Map<String, Stanza> getStanze(){
		return this.stanze;
	}
	
	
	
	
	/** CLASSE NIDIFICATA LabirintoBuilder **/
	
	public class LabirintoBuilder {
		private Labirinto labirinto;
		
		public LabirintoBuilder() {
			this.labirinto = new Labirinto();
		}
		
		public LabirintoBuilder addStanzaIniziale(String nomeStanzaIniziale) {
			Stanza stanzaIniziale = new Stanza(nomeStanzaIniziale);
			this.labirinto.setStanzaCorrente(stanzaIniziale);
			this.labirinto.setUltimaStanzaAggiunta(this.labirinto.getStanzaCorrente());
			this.labirinto.getStanze().put(nomeStanzaIniziale, this.labirinto.getStanzaCorrente());
			return this;
		}
		
		public LabirintoBuilder addStanzaVincente(String nomeStanzaVincente) {
			Stanza stanzaVincente = new Stanza(nomeStanzaVincente);
			this.labirinto.setStanzaVincente(stanzaVincente);
			this.labirinto.setUltimaStanzaAggiunta(this.labirinto.getStanzaVincente());
			this.labirinto.getStanze().put(nomeStanzaVincente, this.labirinto.getStanzaVincente());
			return this;
		}
		
		public LabirintoBuilder addAttrezzo(String nomeAttrezzo, int pesoAttrezzo) {
			Attrezzo a = new Attrezzo(nomeAttrezzo,pesoAttrezzo);
			this.labirinto.getUltimaStanzaAggiunta().addAttrezzo(a);
			return this;
		}
		
		public LabirintoBuilder addAdiacenza(String nomeStanza,String nomeStanzaAdiacente,String direzioneAdiacenza) {
			if(this.labirinto.getStanze().get(nomeStanza).getStanzaAdiacente(direzioneAdiacenza)==null) {
				this.labirinto.getStanze().get(nomeStanza).impostaStanzaAdiacente(direzioneAdiacenza, this.labirinto.getStanze().get(nomeStanzaAdiacente));
				return this;
			}
			return this;
		}
		
		public LabirintoBuilder addStanza(String nomeStanza) {
			Stanza stanza = new Stanza(nomeStanza);
			this.labirinto.getStanze().put(nomeStanza, stanza);
			this.labirinto.setUltimaStanzaAggiunta(stanza);
			return this;
		}
		
		public LabirintoBuilder addStanzaMagica(String nomeStanza) {
			Stanza stanza = new StanzaMagica(nomeStanza);
			this.labirinto.getStanze().put(nomeStanza, stanza);
			this.labirinto.setUltimaStanzaAggiunta(stanza);
			return this;
		}
		
		public LabirintoBuilder addStanzaBloccata(String nomeStanza, String direzioneBloccata, String nomeAttrezzo) {
			Stanza s = new StanzaBloccata(nomeStanza,direzioneBloccata);
			this.labirinto.getStanze().put(nomeStanza, s);
			this.labirinto.setUltimaStanzaAggiunta(s);
			return this;
		}
		
		public LabirintoBuilder addStanzaBuia(String nomeStanza, String nomeAttrezzo) {
			Stanza s = new StanzaBuia(nomeStanza);
			this.labirinto.getStanze().put(nomeStanza, s);
			this.labirinto.setUltimaStanzaAggiunta(s);
			return this;
		}
		
		public Labirinto getLabirinto() {
			return this.labirinto;
		}

		public void addPersonaggio(String nome, String presentazione, String nomeAttrezzo, int pesoAttrezzo,
				String nomeStanza) {
			
		}
	}
	
	

}
