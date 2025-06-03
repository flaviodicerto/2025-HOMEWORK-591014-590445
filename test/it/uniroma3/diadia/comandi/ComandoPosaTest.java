package it.uniroma3.diadia.comandi;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class ComandoPosaTest {
	
	private Partita partita;
	private IOConsole console;
	
	@Before
	public void setUp() {
		this.partita = new Partita();
		this.console = new IOConsole();
		
		this.partita.setConsole(console);
		this.partita.setLabirinto();
	}

	@Test
	public void eseguiTestAttrezzoNonPresenteNellaBorsaCheNonSiTroviNellaStanza() {
		AbstractComando comando = new ComandoPosa("attrezzo_inesistente");
		comando.esegui(this.partita);
		
		assertEquals(null,this.partita.getLabirinto().getStanzaCorrente().getAttrezzo("attrezzo_inesistente"));
	}
	
	@Test
	public void eseguiTestAttrezzoNonPresenteNellaBorsaCheNonSiTroviNellaBorsa() {
		AbstractComando comando=new ComandoPosa("attrezzo_inesistente");
		comando.esegui(this.partita);
		
		assertEquals(null,this.partita.getGiocatore().getBorsa().getAttrezzo("attrezzo_inesistente"));
	}
	
	@Test
	public void eseguiTestAttrezzoPresenteNellaBorsaCheSiTroviNellaStanza() {
		Attrezzo attrezzo=new Attrezzo("attrezzo",1);
		this.partita.getGiocatore().getBorsa().addAttrezzo(attrezzo);
		AbstractComando comando=new ComandoPosa("attrezzo");
		comando.esegui(this.partita);
		
		assertEquals(attrezzo,this.partita.getLabirinto().getStanzaCorrente().getAttrezzo("attrezzo"));
	}
	
	@Test
	public void eseguiTestAttrezzoPresenteNellaBorsaCheNonSiTroviNellaBorsa() {
		Attrezzo attrezzo=new Attrezzo("attrezzo",1);
		this.partita.getGiocatore().getBorsa().addAttrezzo(attrezzo);
		AbstractComando comando=new ComandoPosa("attrezzo");
		comando.esegui(this.partita);
		
		assertEquals(null,this.partita.getGiocatore().getBorsa().getAttrezzo("attrezzo"));
	}

}

