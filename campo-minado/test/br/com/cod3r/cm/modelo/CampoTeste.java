package br.com.cod3r.cm.modelo;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.cod3er.cm.excecao.ExplosaoException;
import br.com.cod3er.cm.modelo.Campo;

public class CampoTeste {

	private Campo campo = new Campo(3,3);
	
	@BeforeEach
	public void iniciarCampo() {
		campo = new Campo(3,3);
	}
	
	@Test
	void testeVizinhoDistancia1Esquerda() {
		Campo vizinho = new Campo(3, 2);
		boolean resultado = campo.adicionarVizinho(vizinho);
		assertTrue(resultado);
	}
	
	@Test
	void testeVizinhoDistancia1Direita() {
		Campo vizinho = new Campo(3, 4);
		boolean resultado = campo.adicionarVizinho(vizinho);
		assertTrue(resultado);
	}

	@Test
	void testeVizinhoDistancia1EmCima() {
		Campo vizinho = new Campo(2, 3);
		boolean resultado = campo.adicionarVizinho(vizinho);
		assertTrue(resultado);
	}

	@Test
	void testeVizinhoDistancia1EmBaixo() {
		Campo vizinho = new Campo(4, 3);
		boolean resultado = campo.adicionarVizinho(vizinho);
		assertTrue(resultado);
	}

	@Test
	void testeVizinhoDiagonalSuperiorEsquerda() {
		Campo vizinho = new Campo(2, 2);
		boolean resultado = campo.adicionarVizinho(vizinho);
		assertTrue(resultado);
	}

	@Test
	void testeVizinhoDiagonalInferiorEsquerda() {
		Campo vizinho = new Campo(4, 2);
		boolean resultado = campo.adicionarVizinho(vizinho);
		assertTrue(resultado);
	}

	@Test
	void testeNaoVizinho1() {
		Campo vizinho = new Campo(3, 5);
		boolean resultado = campo.adicionarVizinho(vizinho);
		assertFalse(resultado);
	}

	@Test
	void testeNaoVizinho2() {
		Campo vizinho = new Campo(1, 1);
		boolean resultado = campo.adicionarVizinho(vizinho);
		assertFalse(resultado);
	}
	
	@Test
	void testeValorPadraoAtributoMarcado() {
		assertFalse(campo.isMarcado());
	}
	
	@Test
	void testeAlternarMarcacao() {
		campo.alternarMarcacao();
		assertTrue(campo.isMarcado());
	}
	
	@Test
	void testeAlternarMarcacaoDuasVezes() {
		campo.alternarMarcacao();
		campo.alternarMarcacao();
		assertFalse(campo.isMarcado());
	}
	
	@Test
	void testeAbrirNaoMinadoNaoMarcado() {
		assertTrue(campo.abrir());
	}
	
	@Test
	void testeAbrirNaoMinadoMarcado() {
		campo.alternarMarcacao();
		assertFalse(campo.abrir());
	}
	
	@Test
	void testeAbrirMinadoMarcado() {
		campo.minar();
		campo.alternarMarcacao();
		assertFalse(campo.abrir());
	}
	
	@Test
	void testeAbrirMinadoNaoMarcado() {
		campo.minar();
		assertThrows(ExplosaoException.class, () -> {
			campo.abrir();
		});
	}

	@Test
	void testeAbrirComVizinhos1() {
		
		Campo campo11 = new Campo(1, 1);
		Campo campo22 = new Campo(2, 2);
		
		campo22.adicionarVizinho(campo11);
		campo.adicionarVizinho(campo22);
		
		campo.abrir();

		assertTrue(campo22.isAberto() && campo11.isAberto());
	}

	@Test
	void testeAbrirComVizinhos2() {
		
		Campo campo11 = new Campo(1, 1);
		Campo campo12 = new Campo(1, 1);
		campo12.minar();
		
		Campo campo22 = new Campo(2, 2);
		campo22.adicionarVizinho(campo11);
		campo22.adicionarVizinho(campo12);

		campo.adicionarVizinho(campo22);
		campo.abrir();
		
		assertTrue(campo22.isAberto() && !campo11.isAberto());
	}
	
	@Test
	void objetivoAlcancadoNaoMinadoAberto() {
		campo.abrir();
		assertTrue(campo.objetivoAlcancado());
	}
	
	@Test
	void objetivoAlcancadoMinadoAberto(){
		campo.abrir();
		campo.minar();
		assertFalse(campo.objetivoAlcancado());
	}
	
	@Test
	void objetivoAlcancadoMinadoMarcado() {
		campo.minar();
		campo.alternarMarcacao();
		assertTrue(campo.objetivoAlcancado());
	}
	
	@Test
	void minasVizinhancaUmaMina() {
		Campo campo22 = new Campo(2, 2);
		Campo campo32 = new Campo(3, 2);
		
		campo32.minar();
		campo.adicionarVizinho(campo22);
		campo.adicionarVizinho(campo32);

		assertEquals(1l, campo.minasNaVizinhanca());
	}
	
	
	@Test
	void minasVizinhancaDuasMina() {
		Campo campo22 = new Campo(2, 2);
		Campo campo32 = new Campo(3, 2);
		
		campo22.minar();
		campo32.minar();
		campo.adicionarVizinho(campo22);
		campo.adicionarVizinho(campo32);
		
		assertEquals(2l, campo.minasNaVizinhanca());
	}
	
	@Test
	void testeReiniciarCamposAberto() {
		campo.abrir();
		campo.minar();
		campo.reiniciar();
		
		assertFalse(campo.isAberto());
	}
	
	@Test
	void testeReiniciarCamposMinado() {
		campo.abrir();
		campo.minar();
		campo.reiniciar();
		
		assertFalse(campo.isMinado());
	}

	@Test
	void testeReiniciarCamposMarcado() {
		campo.minar();
		campo.alternarMarcacao();
		campo.reiniciar();
		
		assertFalse(campo.isMarcado());
	}
	
	@Test
	void testeToStringMarcado() {
		campo.alternarMarcacao();
		assertEquals("x", campo.toString());
	}
	
	@Test
	void testeToStringAbertoEMinado() {
		campo.abrir();
		campo.minar();
		assertEquals("*", campo.toString());
	}
	
	@Test
	void testeToStringAbertoEMinasNaVizinhancaverdadeiro() {
		
		Campo campo22 = new Campo(2, 2);
		Campo campo32 = new Campo(3, 2);
		
		campo22.minar();
		campo32.minar();
		campo.adicionarVizinho(campo22);
		campo.adicionarVizinho(campo32);
		
		campo.abrir();
		assertEquals("2", campo.toString());
	}
	
	@Test
	void testeToStringAbertoEMinasNaVizinhancaFalso() {
		
		Campo campo22 = new Campo(2, 2);
		Campo campo32 = new Campo(3, 2);
		
		campo22.minar();
		campo32.minar();
		campo.adicionarVizinho(campo22);
		campo.adicionarVizinho(campo32);
		
		campo.abrir();
		assertNotEquals("1", campo.toString());
	}
	
	@Test
	void testeToStringAberto() {
		campo.abrir();
		assertEquals(" ", campo.toString());
	}
	
	@Test
	void testeToStringNenhumaAcao() {
		assertEquals("?", campo.toString());
	}
	 
}