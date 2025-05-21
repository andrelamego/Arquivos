package model.structure;

public class NoPilha<String> {
	private String valor;
	private NoPilha<String> anterior;
	
	public NoPilha(String valor) {
		this.setValor(valor);
		this.setAnterior(null);
	}

	
	public String getValor() {
		return valor;
	}
	public void setValor(String valor) {
		this.valor = valor;
	}

	public NoPilha<String> getAnterior() {
		return anterior;
	}
	public void setAnterior(NoPilha<String> anterior) {
		this.anterior = anterior;
	}
	
	
}
