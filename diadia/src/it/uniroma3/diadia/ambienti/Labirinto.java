package it.uniroma3.diadia.ambienti;

public class Labirinto {
	private Stanza stanzaIniziale;
	private Stanza stanzaFinale;
	
	
	public void Labirinto (Stanza Iniziale,Stanza Finale)
	{
		stanzaIniziale=Iniziale;
		stanzaFinale=Finale;
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
}
