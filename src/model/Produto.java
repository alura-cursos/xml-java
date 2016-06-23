package model;

public class Produto {
	
	private String nome;
	private double preco;
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	public void setPreco(double preco) {
		this.preco = preco;
	}
	public String getNome() {
		return nome;
	}
	public double getPreco() {
		return preco;
	}
	
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Nome do produto:" + nome + " preco : " + preco;
	}
	
}
