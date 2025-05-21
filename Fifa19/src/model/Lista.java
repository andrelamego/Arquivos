package model;

import model.structure.NoLista;

public class Lista {
	private NoLista<String> inicio = null;
	
	public NoLista<String> getInicio(){
		return inicio;
	}
	
	// INSERT
	
	public void insert(String elemento) {
		NoLista<String> novo = new NoLista<>(elemento);
		
		if(inicio == null)
			this.inicio = novo;
		else
			insert(novo, inicio);
	}
	
	private void insert(NoLista<String> novo, NoLista<String> atual) {
		if(atual.getProximo() == null)
			atual.setProximo(novo);
		else
			insert(novo, atual.getProximo());
	}
}
