package teste.heranca;

import infra.DAO;
import modelo.heranca.PessoaFisica;

public class InserePessoa {
	
	public static void main(String[] args) {
		
		DAO<PessoaFisica> dao = new DAO<>();
		PessoaFisica pessoaFis = new PessoaFisica();
		
		pessoaFis.setNome("Ramon");
		pessoaFis.setCpf(12345678912l);
		
		dao.abrirT()
		   .incluir(pessoaFis)
		   .fecharT()
		   .fechar();
	}

}
