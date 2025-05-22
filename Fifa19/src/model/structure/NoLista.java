package model.structure;

public class NoLista<String> {
	private String valor;
	private NoLista<String> proximo;
	
	public NoLista(String valor) {
		this.setValor(valor);
	}

	public NoLista<String> getProximo() {
		return proximo;
	}
	public void setProximo(NoLista<String> proximo) {
		this.proximo = proximo;
	}

	public String getValor() {
		return valor;
	}
	public void setValor(String valor) {
		this.valor = valor;
	}
	
	
}
