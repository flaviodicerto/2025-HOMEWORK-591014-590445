package it.uniroma3.diadia.comandi;
import it.uniroma3.diadia.*;
import it.uniroma3.diadia.comandi.*;

import java.util.Scanner;
/**
 * CLASSE CHE PERMETTE DI CAPIRE A QUALE COMANDO CORRISPONDE L'ISTRUZIONE
 * INSERITA DALL'UTENTE E CON QUALE PARAMETRO VUOLE CHE L'ISTRUZIONE VENGA ESEGUITA
 * 
 * @author 591014 - 590445 
 * @version 1.0
 * @see Comando, DiaDia
 */
public class FabbricaDiComandiFisarmonica implements FabbricaDiComandi{

	@SuppressWarnings("resource")
	public AbstractComando costruisciComando(String istruzione) {
		
		Scanner scannerDiParole = new Scanner(istruzione);
		String nomeComando = null;
		String parametro = null;
		AbstractComando comando = null;
		
		if (scannerDiParole.hasNext())
			nomeComando = scannerDiParole.next(); // PRIMA PAROLA: NOME DEL COMANDO
		if (scannerDiParole.hasNext())
			parametro = scannerDiParole.next(); // SECONDA PAROLA: EVENTUALE PARAMETRO
		

		if (nomeComando == null)
			comando = new ComandoNonValido();
		else if (nomeComando.equals("vai"))
			comando = new ComandoVai(parametro);
		else if (nomeComando.equals("prendi"))
			comando = new ComandoPrendi(parametro);
		else if (nomeComando.equals("posa"))
			comando = new ComandoPosa(parametro);
		else if (nomeComando.equals("aiuto"))
			comando = new ComandoAiuto();
		else if (nomeComando.equals("fine"))
			comando = new ComandoFine();
		else if (nomeComando.equals("guarda"))
			comando = new ComandoGuarda(parametro);
		else comando = new ComandoNonValido();


		comando.setParametro(parametro);
		return comando;
	}
}
