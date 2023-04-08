package arquivos;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class IdentificandoDirArq {
	
	public static void main(String[] args) {
		
		Path diretorio = Paths.get("C:\\Users\\acdcr\\OneDrive\\Documentos\\Curriculos");
		Path arquivo = Paths.get("C:\\Users\\acdcr\\OneDrive\\Documentos\\Curriculos\\CV - Willi Ramon Sabino.pdf");
		
		if(Files.isDirectory(diretorio)) {
			System.out.println("O diret�rio existe");
		}else {
			System.out.println("O diret�rio N�O existe");
		}
		
		if(Files.exists(arquivo)) {
			System.out.println("Arquivo existe");
		}else {
			System.out.println("Arquivo N�O existe");
		}
	}

}
