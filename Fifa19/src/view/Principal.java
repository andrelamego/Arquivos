package view;

import java.io.IOException;

import controller.FifaController;
import model.Lista;
import model.Pilha;

public class Principal {
	public static void main(String[] args) {
		FifaController fifaC = new FifaController();
		Pilha pilha = new Pilha();
		Lista lista = new Lista();
		
		String path = "C:\\TEMP";
		String name = "data.csv";
		
		try {
			pilha = fifaC.empilhaBrasileiros(path, name);
			fifaC.desempilhaBonsBrasileiros(pilha);
			lista = fifaC.listaRevelacoes(path, name);
			fifaC.buscaListaBonsJovens(lista);
		} catch (IOException e) {
			e.printStackTrace();
		}		
	}
}
