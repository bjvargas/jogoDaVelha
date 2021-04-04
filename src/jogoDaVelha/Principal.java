package jogoDaVelha;

import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {
		Scanner ler = new Scanner(System.in);

		Jogador primeiro = new Jogador();
		primeiro.setLetra("X");
		Jogador segundo = new Jogador();
		segundo.setLetra("O");
		System.out.println("Informe tamanho do tabuleiro");
		int tamanho = Integer.parseInt(ler.nextLine());

		JogoDaVelha board = new JogoDaVelha(tamanho);

		System.out.println("================");
		System.out.println("Informe nome do primeiro jogador");
		primeiro.setNome(ler.nextLine());
		System.out.println("Informe nome do segundo jogador");
		segundo.setNome(ler.nextLine());

		board.printBoard();

		boolean gameOver = false;

		while (!gameOver) {

			if (jogar(board, primeiro, segundo)) {
				System.out.println("FECHAR para finalizar o jogo. Oy enter para continuar Jogando.");
				String comando = ler.nextLine();

				if (comando != null && comando.trim().equalsIgnoreCase("FECHAR")) {
					gameOver = true;
				}

				board = new JogoDaVelha(tamanho);
			}

		}

	}

	private static boolean jogar(JogoDaVelha jogo, Jogador primeiro, Jogador segundo) {
		Jogador jogadorAtual = primeiro;
		boolean isWinner = false;

		do {
			boolean jogadaRealizada = jogada(jogo, jogadorAtual);

			if (jogadaRealizada) {
				jogo.printBoard();

				isWinner = jogo.verificaGanhador();

				if (isWinner) {
					jogadorAtual.setPontos(jogadorAtual.getPontos() + 1);
					System.out.println("O Ganhador é " + jogadorAtual.getNome());
					System.out.println("");
					System.out.println("Pontuação final: ");
					System.out.println(primeiro.getNome() + ": " + primeiro.getPontos());
					System.out.println(segundo.getNome() + ": " + segundo.getPontos());
				} else {
					jogadorAtual = (jogadorAtual == primeiro) ? segundo : primeiro;
				}
			}

		} while (!isWinner);

		return isWinner;
	}

	private static boolean jogada(JogoDaVelha jogo, Jogador jogadorAtual) {
		boolean jogadaRealizada = false;
		Scanner ler = new Scanner(System.in);

		do {
			System.out.println("Vez do jogador " + jogadorAtual.getNome());
			System.out.println("Informe a linha: ");
			int linha = Integer.parseInt(ler.nextLine());
			System.out.println("Informe a Coluna: ");
			int coluna = Integer.parseInt(ler.nextLine());

			try {
				jogadaRealizada = jogo.realizaJogada(linha, coluna, jogadorAtual.getLetra());
			} catch (Exception e) {
				System.out.println("Erro: " + e.getMessage());
			}
		} while (!jogadaRealizada);

		return jogadaRealizada;
	}

}
