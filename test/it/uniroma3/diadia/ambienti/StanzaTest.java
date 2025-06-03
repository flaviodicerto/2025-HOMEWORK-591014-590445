package it.uniroma3.diadia.ambienti;
import static org.junit.Assert.*;
import org.junit.Test;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import org.junit.Before;

public class StanzaTest {
	
	Stanza s = new Stanza("salotto");
	Stanza c = new Stanza("cucina");
	Stanza b = new Stanza("camera da letto");
	Attrezzo lampada = new Attrezzo("lampada", 2);
	Attrezzo vaso = new Attrezzo("vaso",2);
	
	@Before
	public void SetUp() {
		s.impostaStanzaAdiacente("nord", c);
		s.addAttrezzo(lampada);
		s.addAttrezzo(vaso);
	}

	//TEST SU GetStanzaAdiacente
	@Test
	public void PositivetestGetStanzaAdiacente() {
		assertEquals(this.c,s.getStanzaAdiacente("nord"));
	}
	@Test
	public void NegativetestGetStanzaAdiacente() {
		assertEquals(null,s.getStanzaAdiacente("sud"));
	}
	@Test
	public void NegativetestGetStanzaAdiacente1() {
		assertNotEquals(this.b,s.getStanzaAdiacente("nord"));
	}
	
	
	//TEST SU GetNome
	@Test
	public void PositivetestGetNome(){
		assertEquals("salotto",s.getNome());
	}
	@Test
	public void NegativetestGetNome(){
		assertNotEquals("salotto",c.getNome());
	}
	
	
	//TEST SU HasAttrezzo
	@Test
	public void PositiveHasAttrezzo() {
		Attrezzo penna = new Attrezzo("penna",1);
		s.addAttrezzo(penna);
		assertTrue(s.hasAttrezzo("penna"));
		assertTrue(this.s.hasAttrezzo("lampada"));
		assertTrue(this.s.hasAttrezzo("vaso"));
	}
	@Test
	public void NegativeHasAttrezzo() {
		assertFalse(s.hasAttrezzo("penna"));
	}
	
	
	//TEST SU AddAttrezzo 
	@Test
	public void PositiveAddAttrezzo() {
		assertEquals(2,s.getNumeroAttrezzi());	
	}
	
	
	//TEST SU removeAttrezzo
	@Test
	public void testRemoveAttrezzo1() {
		s.removeAttrezzo(lampada);
		assertFalse(s.hasAttrezzo("lampada"));
	}
	@Test
	public void testRemoveAttrezzo2() {
		Attrezzo piatto = new Attrezzo("piatto",1);
		Attrezzo pentola = new Attrezzo("pentola",2);
		s.addAttrezzo(piatto);
		s.addAttrezzo(pentola);
		s.removeAttrezzo(piatto);
		assertTrue(s.hasAttrezzo("lampada"));
		assertTrue(s.hasAttrezzo("vaso"));
		assertTrue(s.hasAttrezzo("pentola"));
		assertFalse(s.hasAttrezzo("piatto"));
	}
	
	@Test
	public void testStanzaConStessoAttrezzo() {
		Attrezzo piatto = new Attrezzo("piatto",1);
		this.s.addAttrezzo(piatto);
		this.s.addAttrezzo(piatto);
		assertEquals(this.s.getAttrezzi(),this.s.getAttrezzi());
	}

}
