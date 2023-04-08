package arquivos;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class LerArquivo {

	public static void main(String[] args) {
		
		Path arquivo = Paths.get("C:\\Users\\acdcr\\OneDrive\\Documentos\\cursos\\udemy-java\\texto_teste.txt");
	
		try {
			List<String> linhas = Files.readAllLines(arquivo);
			
			linhas.forEach(linha -> System.out.println(linha));
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
