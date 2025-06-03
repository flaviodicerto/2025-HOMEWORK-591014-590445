package it.uniroma3.diadia.ambienti;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class StanzaBuiaTest {
	
	StanzaBuia s1;
	StanzaBuia s2;
	StanzaBuia s;
	Attrezzo lanterna;
	Attrezzo sedia;

	@Before
	public void setUp() throws Exception {
		this.s = new StanzaBuia("cucina");
		this.s1 = new StanzaBuia("cucina");
		this.s2 = new StanzaBuia("salotto");
		this.lanterna = new Attrezzo("lanterna",3);
		this.sedia = new Attrezzo("sedia",3);
		
		s.addAttrezzo(sedia);
		s1.addAttrezzo(sedia);
		s1.addAttrezzo(lanterna);
		s2.addAttrezzo(sedia);
	}

	@Test
	public void testGetDescrizioneParticolare() {
		assertEquals(s.getDescrizione(),s2.getDescrizione());
	}
	
	@Test
	public void testGetDescrizioneNormale() {
		s.addAttrezzo(lanterna);
		assertEquals(s.getDescrizione(),s1.getDescrizione());
	}
	

}
