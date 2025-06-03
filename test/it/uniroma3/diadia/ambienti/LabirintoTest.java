package it.uniroma3.diadia.ambienti;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class LabirintoTest {
	
	Labirinto l=new Labirinto();
	
	@Test
	public void testGetStanzaVincente() {
		Stanza A=this.l.getStanzaVincente();
		assertEquals(A,this.l.getStanzaVincente());
	}
	
	@Test
	public void testGetStanzaCorrenteImpostata() {
		Stanza B=this.l.getStanzaCorrente();
		assertEquals(B,this.l.getStanzaCorrente());
	}
	
	@Test
	public void testGetStanzaCorrenteDaImpostare() {
		Stanza C=new Stanza("cucina");
		this.l.setStanzaCorrente(C);
		assertEquals(C,this.l.getStanzaCorrente());
	}
	
	@Test
	public void testSetStanzaVincente() {
		Stanza D=new Stanza("salotto");
		this.l.setStanzaVincente(D);
		assertEquals(D,this.l.getStanzaVincente());
	}
	
	@Test
	public void testSetStanzaCorrente() {
		Stanza E=new Stanza("camerino");
		this.l.setStanzaCorrente(E);
		assertEquals(E,this.l.getStanzaCorrente());
	}
}
