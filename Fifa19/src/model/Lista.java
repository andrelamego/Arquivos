package model;

import model.structure.NoLista;

public class Lista {
	private NoLista<String> inicio = null;
	
	public NoLista<String> getInicio(){
		return inicio;
	}
	
	// append
	
	public void append(String elemento) {
		NoLista<String> novo = new NoLista<>(elemento);
		
		if(inicio == null)
			this.inicio = novo;
		else
			append(novo, inicio);
	}
	
	private void append(NoLista<String> novo, NoLista<String> atual) {
		if(atual.getProximo() == null)
			atual.setProximo(novo);
		else
			append(novo, atual.getProximo());
	}
}
