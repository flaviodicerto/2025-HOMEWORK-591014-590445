package it.uniroma3.diadia.comandi;

import java.util.Scanner;

public class FabbricaDiComandiRiflessiva implements FabbricaDiComandi {
	
	@SuppressWarnings("deprecation")
	@Override
	public AbstractComando costruisciComando(String istruzione) {
		@SuppressWarnings("resource")
		Scanner scannerDiParole = new Scanner(istruzione);
		String nomeComando = null;
		String parametro = null;
		AbstractComando comando = null;
		
		if (scannerDiParole.hasNext())
			nomeComando = scannerDiParole.next();  //PRIMA PAROLA: NOME DEL COMANDO
		if (scannerDiParole.hasNext())
			parametro = scannerDiParole.next();  //SECONDA PAROLA: EVENTUALE PARAMETRO
		
		try {
			StringBuilder nomeClasse = new StringBuilder("it.uniroma3.diadia.comandi.Comando");
			nomeClasse.append( Character.toUpperCase(nomeComando.charAt(0)) );
			nomeClasse.append( nomeComando.substring(1) ) ;
			comando = (AbstractComando)Class.forName(nomeClasse.toString()).newInstance();
			comando.setParametro(parametro);
		} 
		catch (Exception e) {
			comando = new ComandoNonValido();
		}
		
		return comando;
	}
}
