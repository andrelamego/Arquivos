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

public class FifaController implements IFifaController{

	@Override
	public Pilha empilhaBrasileiros(String path, String name) throws IOException {
		File file = new File(path, name);
		Pilha pilha = new Pilha();
		
		if(file.exists() && file.isFile()) {
			FileInputStream inputStream = new FileInputStream(file);
			InputStreamReader streamReader = new InputStreamReader(inputStream);
			BufferedReader reader = new BufferedReader(streamReader);
			
			String line = reader.readLine(); line = reader.readLine();
			
			while(line != null) {
				fetchBrazilianPlayer(pilha, line);
				line = reader.readLine();
			}
			
			reader.close();
			streamReader.close();
			inputStream.close();
		}
		else
			throw new IOException("Arquivo inválido");
		
		return null;
	}

	private void fetchBrazilianPlayer(Pilha pilha, String line) {
		String[] playerInfo = line.split(",");
		int nationality = 5;
		
		if(playerInfo[nationality].equals("Brazil")) {
			pilha.push(line);
			System.out.println(line);
		}		
	}

	@Override
	public void desempilhaBonsBrasileiros(Pilha pilha) throws IOException {
		NoPilha<String> no = pilha.pop();
		String[] player = no.getValor().split(",");
		int name = 1;
		int overall = 7;
		
		if(no == null) return;
		else if(Integer.parseInt(player[overall]) >= 80)
			System.out.println(player[name] + " | " + player[overall]);
		else
			desempilhaBonsBrasileiros(pilha);
	}

	@Override
	public Lista listaRevelacoes(String path, String name) throws IOException {
		Lista lista = new Lista();
		File file = new File(path, name);
		
		if(file.exists() && file.isFile()) {
			FileInputStream inputStream = new FileInputStream(file);
			InputStreamReader streamReader = new InputStreamReader(inputStream);
			BufferedReader reader = new BufferedReader(streamReader);
			
			String line = reader.readLine(); line = reader.readLine();
			
			while(line != null) {
				fetchYoungPlayer(lista, line);
				line = reader.readLine();
			}
			
			reader.close();
			streamReader.close();
			inputStream.close();
		}
		
		return lista;
	}

	private void fetchYoungPlayer(Lista lista, String line) {
		String[] player = line.split(",");
		int age = 8;
		
		if(Integer.parseInt(player[age]) <= 20)
			lista.insert(line);
	}

	@Override
	public void buscaListaBonsJovens(Lista lista) throws IOException {
		NoLista<String> no = lista.getInicio();
		
		while(no != null) {
			String[] player = no.getValor().split(",");
			int name = 1, age = 4, overall = 7;
			
			if(Integer.parseInt(player[overall]) >= 80)
				System.out.println(player[name] + "," + player[age] + " | " + player[overall]);
			
			no = no.getProximo();
		}		
	}
}
