package it.uniroma3.diadia.ambienti;
import diadia.*;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class Labirinto {
	private Stanza stanzaIniziale;
	private Stanza stanzaFinale;
	private Stanza stanzaCorrente;
	private Stanza stanzaVincente;
	
	public void Labirinto (Stanza Iniziale,Stanza Finale)
	{
		stanzaIniziale=Iniziale;
		stanzaFinale=Finale;
	}
		
	public Labirinto() {
        this.creaStanze();
    }

	public Stanza getStanzaVincente() {
		return stanzaVincente;
	}
	
	public void setStanzaVincente(Stanza stanzaVincente) {
		this.stanzaVincente = stanzaVincente;
	}
	
	public void setStanzaCorrente(Stanza stanzaCorrente) {
		this.stanzaCorrente = stanzaCorrente;
	}

	public Stanza getStanzaCorrente() {
		return this.stanzaCorrente;
	}
	
	public Stanza getUscita() {
		return stanzaFinale;
	}
	
	public Stanza getEntrata() {
		return stanzaIniziale;
	}

	public void setUscita(Stanza a) {
		stanzaFinale=a;
	}
	
	public void setEntrata(Stanza a) {
		stanzaIniziale=a;
	}
	
	 /**
     * Crea tutte le stanze e le porte di collegamento
     */
    public void creaStanze() {
		/* crea gli attrezzi */
    	Attrezzo lanterna = new Attrezzo("lanterna",3);
		Attrezzo osso = new Attrezzo("osso",1);
		Attrezzo passpartout = new Attrezzo("passpartout",1);
    	
		/* crea stanze del labirinto */
		Stanza atrio = new Stanza("Atrio");
		Stanza aulaN11 = new Stanza("Aula N11");
		Stanza aulaN10 = new Stanza("Aula N10");
		Stanza laboratorio = new Stanza("Laboratorio Campus");
		Stanza biblioteca = new Stanza("Biblioteca");
		StanzaMagica aulaN12 = new StanzaMagica("Aula N12");
		StanzaBuia aulaN13 = new StanzaBuia("Aula N13");
		StanzaBloccata aulaN14 = new StanzaBloccata("Aula N14", "nord");
		
		/* collega le stanze */
		atrio.impostaStanzaAdiacente("nord", biblioteca);
		atrio.impostaStanzaAdiacente("est", aulaN11);
		atrio.impostaStanzaAdiacente("sud", aulaN10);
		atrio.impostaStanzaAdiacente("ovest", laboratorio);
		aulaN11.impostaStanzaAdiacente("est", laboratorio);
		aulaN11.impostaStanzaAdiacente("ovest", atrio);
		aulaN10.impostaStanzaAdiacente("nord", atrio);
		aulaN10.impostaStanzaAdiacente("est", aulaN11);
		aulaN10.impostaStanzaAdiacente("ovest", laboratorio);
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
        aulaN10.impostaStanzaAdiacente("sud", aulaN12);
        aulaN11.impostaStanzaAdiacente("sud", aulaN13);

        /* pone gli attrezzi nelle stanze */
		aulaN10.addAttrezzo(lanterna);
		atrio.addAttrezzo(osso);
		atrio.addAttrezzo(lanterna);
		atrio.addAttrezzo(passpartout);

		// il gioco comincia nell'atrio
        stanzaCorrente = atrio;  
		stanzaVincente = biblioteca;
    }
	
}
