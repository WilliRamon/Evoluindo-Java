package arquivos;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class ManipulandoArqComFile {
	
	public static void main(String[] args) {
	
		//NESSE EXEMPLO, VOU PEGAR OS VALORES DE UM ARQUIVO, 
		//MANIPULAR E GRAVAR/CRIAR OUTRA PASTA E DIRETORIO
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		ArrayList<Product> list = new ArrayList<>();
		
		System.out.println("Enter file path: ");
//		String sourceFileStr = sc.nextLine();
		String sourceFileStr = "C:\\Users\\acdcr\\OneDrive\\Documentos\\cursos\\udemy-java\\aula de manipulacao de arquivos\\input.csv";
		
		
		File sourceFile = new File(sourceFileStr); //Vai permitir que crie um objeto recebendo o caminho
		String sourceFolderStr = sourceFile.getParent(); //Esse método pega o caminho para o diretório desconsiderando o nome do arquivo
		
		boolean success = new File(sourceFolderStr + "\\out").mkdir(); //Com o método .mkdir, estou criando um novo diretório.
		
		String targetFileStr = sourceFolderStr + "\\out\\summary.csv";
		
		try (BufferedReader br = new BufferedReader(new FileReader(sourceFileStr))){
			
			String itemCsv = br.readLine(); //Lendo o conteúdo do arquivo linha a linha
			while(itemCsv != null) {

				String[] fields = itemCsv.split(",");
				String name = fields[0];
				double price = Double.parseDouble(fields[1]);
				int quantity = Integer.parseInt(fields[2]);
				
				list.add(new Product(name, price, quantity));
				
				itemCsv = br.readLine();
			}
			
			try (BufferedWriter bw = new BufferedWriter(new FileWriter(targetFileStr))){ //Gravando o novo conteúdo em outro arquivo
				
				list.forEach(item -> {
					try {
						bw.write(item.getName() + "," + String.format("%.2f", item.total()));
						bw.newLine();
					} catch (IOException e) {
						e.printStackTrace();
					}
				});
				
				System.out.println(targetFileStr + " CREATED");
				
			} catch (IOException e) {
				System.out.println("Error writing file: " + e.getMessage());
			}
			
		} catch(IOException e) {
			System.out.println("Error writing file: " + e.getMessage());
		}
		
		sc.close();
	}

}
