package capitulos.capitulo2;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class Item9 {
	
	/*
	 * Nesse item, o auto sugere que seja usando o c ao invés do try-finally.
	 * Além de deixar o código compacto, códigos com finally são apagados da pilha de erro. Assim,
	 * sendo mais dificil de rastrear o erro.
	 * 
	 * try-with-resources
	 * Permite também é indicado para situações em que é necessário 'fechar' métodos. Como conexões
	 * com banco ou objetos de manipulação de arquivos.
	 */
	
	static Integer BUFFER_SIZE = 100;
	
	//try-finally
	static String firtLineOfFile(String path) throws IOException{
		BufferedReader br = new BufferedReader(new FileReader(path));
		try {
			return br.readLine();
		}finally {
			br.close();
		}
	}
	
	//try-finally
	static void copy(String src, String dst) throws IOException{
		InputStream in = new FileInputStream(src);
		try {
			OutputStream out = new FileOutputStream(dst);
			try {
				byte[] buf = new byte[BUFFER_SIZE];
				int n;
				while((n = in.read(buf)) >= 0)
					out.write(buf, 0, n);
			}finally {
				out.close();				
			}
		} finally {
			in.close();
		}
	}
	
	//try-with-resources
	static String firtLineOfFile2(String path) throws IOException{
		try(BufferedReader br = new BufferedReader(new FileReader(path))){
			return br.readLine();
		}
	}
	
	//try-with-resources
	static void copy2(String src, String dst) throws IOException{
		try(InputStream   in = new FileInputStream(src);
			OutputStream out = new FileOutputStream(dst)){
			byte[] buf = new byte[BUFFER_SIZE];
			int n;
			while((n = in.read(buf)) >= 0)
				out.write(buf, 0, n);			
		}
	}
}
