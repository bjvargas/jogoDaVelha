package jogoDaVelha;

public class Jogador {

	private String nome;
	private int pontos;	
	private String letra;
	
	
	public String getLetra() {
		return letra;
	}
	public void setLetra(String letra) {
		this.letra = letra;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getPontos() {
		return pontos;
	}
	public void setPontos(int pontos) {
		this.pontos = pontos;
	}
	
	public String toString() {
		return "Jogador: " + this.getNome() + " -- Pontos: " + this.getPontos();
	}
	
}
