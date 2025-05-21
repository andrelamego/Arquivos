package view;

import java.io.IOException;

import controller.ArquivosController;

public class Principal {
	public static void main(String[] args) {
		ArquivosController c = new ArquivosController();
		String path = "C:\\Windows";
		
		try {
			c.listFiles(path);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
