package br.com.cod3er.cm;

 import br.com.cod3er.cm.modelo.Tabuleiro;
import br.com.cod3er.cm.visao.TabuleiroConsole;

public class Aplicacao {
	
	public static void main(String[] args) {
		
		Tabuleiro tabuleiro = new Tabuleiro(6, 6, 6);
		new TabuleiroConsole(tabuleiro);
	}
}
