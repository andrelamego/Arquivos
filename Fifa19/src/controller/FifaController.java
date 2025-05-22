package controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import model.Lista;
import model.Pilha;
import model.structure.NoLista;
import model.structure.NoPilha;

public class FifaController implements IFifaController {

	@Override
	public Pilha empilhaBrasileiros(String path, String name) throws IOException {
		File file = new File(path, name);
		Pilha pilha = new Pilha();

		if (file.exists() && file.isFile()) {
			FileInputStream inputStream = new FileInputStream(file);
			InputStreamReader streamReader = new InputStreamReader(inputStream);
			BufferedReader reader = new BufferedReader(streamReader);

			String line = reader.readLine();
			line = reader.readLine();

			while (line != null) {
				fetchBrazilianPlayer(pilha, line);
				line = reader.readLine();
			}

			reader.close();
			streamReader.close();
			inputStream.close();
		} else
			throw new IOException("Arquivo inválido");

		return pilha;
	}

	private void fetchBrazilianPlayer(Pilha pilha, String line) {
		String[] playerInfo = line.split(",");
		int nationality = 5;

		if (playerInfo[nationality].equals("Brazil")) {
			pilha.push(line);
		}
	}
	
	
	
	@Override
	public void desempilhaBonsBrasileiros(Pilha pilha) throws IOException {
		int name = 2;
		int overall = 7;
		
		NoPilha<String> no = pilha.pop();

		if (no != null) {
			String[] player = no.getValor().split(",");
			
			if (Integer.parseInt(player[overall]) >= 80)
				System.out.println(player[name] + " | " + player[overall]);
			
			desempilhaBonsBrasileiros(pilha);
		}
		else return;
			
	}
	
	
	
	@Override
	public Lista listaRevelacoes(String path, String name) throws IOException {
		Lista lista = new Lista();
		File file = new File(path, name);

		if (file.exists() && file.isFile()) {
			FileInputStream inputStream = new FileInputStream(file);
			InputStreamReader streamReader = new InputStreamReader(inputStream);
			BufferedReader reader = new BufferedReader(streamReader);

			String line = reader.readLine();
			line = reader.readLine();

			while (line != null) {
				fetchYoungPlayer(lista, line);
				line = reader.readLine();
			}

			reader.close();
			streamReader.close();
			inputStream.close();
		}
		else
			throw new IOException("Arquivo Invalido");

		return lista;
	}

	private void fetchYoungPlayer(Lista lista, String line) {
		String[] player = line.split(",");
		int age = 3;

		if (Integer.parseInt(player[age]) <= 20)
			lista.append(line);
	}
	
	
	
	@Override
	public void buscaListaBonsJovens(Lista lista) throws IOException {
		NoLista<String> no = lista.getInicio();

		System.out.println("\n\nJovens Promissores:\n");
		System.out.println("NOME		\tOVERALL");
		while (no != null) {
			String[] player = no.getValor().split(",");
			int name = 2, age = 3, overall = 7;

			if (Integer.parseInt(player[overall]) >= 80)
				System.out.println(player[name] + ", " + player[age] + "\t\t" + player[overall]);

			no = no.getProximo();
		}
	}
}
