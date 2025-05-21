package model;

import model.structure.NoPilha;

public class Pilha {
	NoPilha<String> topo = null;
	
	//	PUSH	Adiciona no topo
	//	POP		Retorna elemento no topo
	
	public void push(String elemento) {
		NoPilha<String> novo = new NoPilha<>(elemento);
		
		if(topo != null) {
			NoPilha<String> anterior = this.topo;
			novo.setAnterior(anterior);	
		}
		this.topo = novo;
	}
	
	public NoPilha<String> pop(){
		if(topo == null)
			return null;
		NoPilha<String> elemento = this.topo;
		this.topo = elemento.getAnterior();
		return elemento;
	}
}
