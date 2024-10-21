import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

/**
 * Jogo de Adivinhação de Números.
 * 
 * O jogador define um intervalo numérico, e o programa gera um número
 * aleatório dentro desse intervalo. O jogador deve adivinhar o número, e o
 * programa fornece dicas se o número é maior ou menor que a tentativa. O jogo
 * continua até o jogador acertar ou escolher sair.
 */
public class JogoAdivinhacao {

  public static void main(String[] args) {
    // Inicializa o scanner para capturar entradas do usuário
    Scanner scanner = new Scanner(System.in);
    // Inicializa a classe Random para gerar números aleatórios
    Random random = new Random();
    // Variável de controle para o loop principal
    boolean jogarNovamente = true;

    System.out.println("Bem-vindo ao Jogo de Adivinhação de Números!");

    // Loop principal que permite ao jogador jogar várias vezes
    while (jogarNovamente) {
      // Variáveis do jogo
      int intervaloMin, intervaloMax, numeroSecreto, tentativa, tentativas = 0;
      boolean acertou = false;

      // Recebe o intervalo mínimo do jogador
      System.out.println("Digite o valor mínimo do intervalo:");
      intervaloMin = scanner.nextInt();

      // Recebe o intervalo máximo do jogador
      System.out.println("Digite o valor máximo do intervalo:");
      intervaloMax = scanner.nextInt();

      // Gera um número aleatório dentro do intervalo especificado
      numeroSecreto = random.nextInt(intervaloMax - intervaloMin + 1) + intervaloMin;

      System.out.println("Tente adivinhar o número entre " + intervaloMin + " e " + intervaloMax);

      // Loop que mantém o jogo ativo até o jogador acertar ou escolher sair
      while (!acertou) {
        System.out.print("Digite sua tentativa (ou 0 para sair): ");

        try {
          // Captura a tentativa do jogador
          tentativa = scanner.nextInt();

          // Se o jogador digitar 0, encerra o jogo
          if (tentativa == 0) {
            System.out.println("Você encerrou o jogo. O número secreto era " + numeroSecreto);
            break;
          }

          // Verifica se a tentativa está dentro do intervalo
          if (tentativa < intervaloMin || tentativa > intervaloMax) {
            System.out.println("Sua tentativa está fora do intervalo! Por favor, tente um número entre "
                + intervaloMin + " e " + intervaloMax);
            continue; // Reinicia o loop e pede uma nova tentativa
          }

          // Incrementa o contador de tentativas
          tentativas++;

          // Verifica se o jogador acertou o número secreto
          if (tentativa == numeroSecreto) {
            acertou = true; // Sai do loop ao acertar
            System.out.println("Parabéns! Você acertou o número em " + tentativas + " tentativas.");
          } else if (tentativa < numeroSecreto) {
            // Fornece dica se o número secreto for maior
            System.out.println("O número é maior. Tente novamente.");
          } else {
            // Fornece dica se o número secreto for menor
            System.out.println("O número é menor. Tente novamente.");
          }

        } catch (InputMismatchException e) {
          // Trata entradas inválidas (não numéricas)
          System.out.println("Entrada inválida! Por favor, insira um número.");
          scanner.next(); // Limpa a entrada inválida para evitar loop infinito
        }
      }

      // Após o fim do jogo, pergunta ao jogador se deseja jogar novamente
      System.out.println("Deseja jogar novamente? Digite 1 para jogar novamente ou 0 para sair.");
      int resposta = scanner.nextInt();

      // Verifica a resposta do jogador: 1 para reiniciar, 0 para sair
      if (resposta == 0) {
        jogarNovamente = false; // Encerra o loop principal
        System.out.println("Obrigado por jogar! Até a próxima.");
      }
    }

    // Fecha o scanner para liberar recursos
    scanner.close();
  }
}