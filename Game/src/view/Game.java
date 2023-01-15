package view;

import java.util.Scanner;

import model.Calcular;

public class Game {

	static Scanner teclado = new Scanner(System.in);
	static int pontos = 0;
	static Calcular calc;

	public static void main(String[] args) {

		Game.jogar();
	}

	private static void jogar() {
		System.out.println("Informe o nivel de dificuldade desejado [1],[2],[3] ou [4]");
		int dificuldade = Game.teclado.nextInt();

		Game.calc = new Calcular(dificuldade);

		System.out.println("informe o resultado para a seguinte operação: ");

		// somar
		if (calc.getOperacao() == 0) {
			System.out.println(calc.getValor1() + " + " + calc.getValor2());
			int resposta = Game.teclado.nextInt();

			if (calc.somar(resposta)) {
				Game.pontos += 1;
				System.out.println("você tem " + Game.pontos + " ponto(s).");
			}
		}
		// subtrair
		else if (calc.getOperacao() == 1) {
			System.out.println(calc.getValor1() + " - " + calc.getValor2());
			int resposta = Game.teclado.nextInt();

			if (calc.subtrair(resposta)) {
				Game.pontos += 1;
				System.out.println("você tem " + Game.pontos + " ponto(s).");
			}
		}

		// multiplicar
		else if (calc.getOperacao() == 2) {
			System.out.println(calc.getValor1() + " x " + calc.getValor2());
			int resposta = Game.teclado.nextInt();

			if (calc.multiplicar(resposta)) {
				Game.pontos += 1;
				System.out.println("você tem " + Game.pontos + " ponto(s).");
			}
		}else{
			System.out.println("A operação " + calc.getOperacao() + " não é reconhecida.");
		}

		System.out.println("Deseja jogar novamente? [1 para - sim ] [0 - não]");
		
		int continuar = Game.teclado.nextInt();
		
		if(continuar == 1) {
			Game.jogar();			
		}else {
			System.out.println("Você fez " + Game.pontos + " ponto(s)");
			System.out.println("Até a próxima");
			System.exit(0);
		}
	}

}
