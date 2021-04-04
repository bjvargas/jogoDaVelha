package jogoDaVelha;

import javax.management.RuntimeErrorException;

public class JogoDaVelha {

	private String[][] tabuleiro;

	public JogoDaVelha(int tamanho) {
		this.setTabuleiro(new String[tamanho][tamanho]);
	}

	public boolean realizaJogada(int linha, int coluna, String letra) {

		if (linha < 1 || linha > tabuleiro.length) {
			throw new RuntimeErrorException(null, "Linha Inexistente.");
		} else if (coluna < 1 || coluna > tabuleiro[linha - 1].length) {
			throw new RuntimeErrorException(null, "Coluna Inexistente.");
		}

		if (letra == null || letra.trim().isEmpty()) {
			throw new RuntimeErrorException(null, "Jogue em uma casa!");
		} else if (!(letra.toUpperCase().equals("X") || letra.toUpperCase().equals("O"))) {
			throw new RuntimeErrorException(null, "Informe X ou O!!.");
		}

		String jogadaAnterior = tabuleiro[linha - 1][coluna - 1];

		if (jogadaAnterior == null || jogadaAnterior.trim().isEmpty()) {
			tabuleiro[linha - 1][coluna - 1] = letra;

			return true;
		}

		return false;

	}

	public boolean verificaGanhador() {

		if (verificaLinhas() || verificaColunas() || verificaDiagonal() || verificaDiagonalInversa()) {
			return true;
		}

		return false;
	}

	private boolean verificaLinhas() {
		for (int i = 0; i < tabuleiro.length; i++) {
			String jogadaP = new String();
			int jogadasIguais = 0;

			for (int j = 0; j < tabuleiro[i].length; j++) {
				String jogadaDaCasa = tabuleiro[i][j];

				if (jogadaDaCasa == null || jogadaDaCasa.trim().isEmpty()) {
					break;
				} else {
					if (jogadaP == null || jogadaP.trim().isEmpty()) {
						jogadaP = jogadaDaCasa;
					}

					if (!jogadaDaCasa.equals(jogadaP)) {
						break;
					} else {
						jogadasIguais++;
					}
				}
			}

			if (jogadasIguais == tabuleiro[i].length) {
				return true;
			}
		}

		return false;
	}

	private boolean verificaColunas() {
		for (int i = 0; i < tabuleiro.length; i++) {
			String jogadaP = new String();
			int jogadasIguais = 0;

			for (int j = 0; j < tabuleiro[i].length; j++) {
				String jogadaDaCasa = tabuleiro[j][i];

				if (jogadaDaCasa == null || jogadaDaCasa.trim().isEmpty()) {
					break;
				} else {
					if (jogadaP == null || jogadaP.trim().isEmpty()) {
						jogadaP = jogadaDaCasa;
					}

					if (!jogadaDaCasa.equals(jogadaP)) {
						break;
					} else {
						jogadasIguais++;
					}
				}
			}

			if (jogadasIguais == tabuleiro.length) {
				return true;
			}
		}

		return false;
	}

	private boolean verificaDiagonal() {
		String jogadaP = new String();
		int jogadasIguais = 0;

		for (int i = 0; i < tabuleiro.length; i++) {
			String jogadaDaCasa = tabuleiro[i][i];

			if (jogadaDaCasa == null || jogadaDaCasa.trim().isEmpty()) {
				break;
			} else {
				if (jogadaP == null || jogadaP.trim().isEmpty()) {
					jogadaP = jogadaDaCasa;
				}

				if (!jogadaDaCasa.equals(jogadaP)) {
					break;
				} else {
					jogadasIguais++;
				}
			}
		}

		if (jogadasIguais == tabuleiro.length) {
			return true;
		}

		return false;
	}

	private boolean verificaDiagonalInversa() {
		String jogadaP = new String();
		int jogadasIguais = 0;

		for (int i = 0; i < tabuleiro.length; i++) {
			String jogadaDaCasa = tabuleiro[i][tabuleiro.length - 1 - i];

			if (jogadaDaCasa == null || jogadaDaCasa.trim().isEmpty()) {
				break;
			} else {
				if (jogadaP == null || jogadaP.trim().isEmpty()) {
					jogadaP = jogadaDaCasa;
				}

				if (!jogadaDaCasa.equals(jogadaP)) {
					break;
				} else {
					jogadasIguais++;
				}
			}
		}

		if (jogadasIguais == tabuleiro.length) {
			return true;
		}

		return false;
	}

	public void printBoard() {
		System.out.println("--");

		for (int i = 0; i < tabuleiro.length; i++) {
			for (int j = 0; j < tabuleiro[i].length; j++) {
				String jogadaAnterior = tabuleiro[i][j];

				System.out.print(
						((jogadaAnterior != null && !jogadaAnterior.trim().isEmpty()) ? jogadaAnterior : "-") + "\t");
			}

			System.out.println("");
		}

		System.out.println("--");
	}

	public String toString() {
		return verificaGanhador() ? "Fechado" : "Segue jogo";
	}

	public String[][] getTabuleiro() {
		return tabuleiro;
	}

	public void setTabuleiro(String[][] strings) {
		this.tabuleiro = strings;
	}

}
