package controller;

import java.io.IOException;

import model.Lista;
import model.Pilha;

public interface IFifaController {
	public Pilha empilhaBrasileiros(String path, String name) throws IOException;
	public void desempilhaBonsBrasileiros(Pilha pilha) throws IOException;
	public Lista listaRevelacoes(String path, String name) throws IOException;
	public void buscaListaBonsJovens(Lista lista) throws IOException;
}
