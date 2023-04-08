package arquivos;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class PassarConteudoDeUmArParaOutro {
	
	public static void main(String[] args) {
		
		Path arquivoNovo = Paths.get("C:\\Users\\acdcr\\OneDrive\\Documentos\\cursos\\udemy-java\\texto_teste.txt");
		Path arquivoAntigo = Paths.get("C:\\Users\\acdcr\\OneDrive\\Documentos\\cursos\\udemy-java\\texto_novo.txt");
	
		try {
			
			byte[] bytesArquivoNovo = Files.readAllBytes(arquivoNovo);
			Files.write(arquivoAntigo, bytesArquivoNovo);
			
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("Erro");
		}
	}

}
