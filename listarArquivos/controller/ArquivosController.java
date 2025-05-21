package controller;

import java.io.File;
import java.io.IOException;

public class ArquivosController {
	public void listFiles(String path) throws IOException {
		File dir = new File(path);
		
		if(dir.exists() && dir.isDirectory()) {
			File[] files = dir.listFiles();
			
			files = sortFiles(files);
			
			for(File f : files) {
				if(f.isFile()) {
					double tamanho = (f.length() / 1024) / 1024;
					
					System.out.println(tamanho + " MB	\t" + f.getName());
				}
			}
		}
		else
			throw new IOException("Diretório não encontrado");
	}

	private File[] sortFiles(File[] files) {
		for (int i = 0; i < files.length; i++) {
			for (int j = i + 1; j < files.length; j++) {
				
				if(files[i].length() > files[j].length()) {
					swap(files, i, j);
				}
			}
		}
		return files;
	}

	private void swap(File[] files, int i, int j) {
		File buffer = files[i];
		files[i] = files[j];
		files[j] = buffer;
	}
}
