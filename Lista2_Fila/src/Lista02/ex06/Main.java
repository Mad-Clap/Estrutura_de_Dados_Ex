package Lista02.ex06;
import java.util.Scanner;

public class Main {

    public static void imprimeBinarios(int n) {
        //Dado um número inteiro N, faça um algoritmo eficiente que use fila para gerar todas as
        //representações binárias dos números inteiros entre 1 e N.

        FilaEx06 filaBinarios = new FilaEx06(n);

        filaBinarios.insere("1"); // Primeiro elemento da sequência de binários

        for (int i = 1; i <= n; i++) { // Loop para imprimir os binários
            // Remove o próximo número binário que deve ser imprimido e o imprime
            String numeroBinario = filaBinarios.remove();
            System.out.print(numeroBinario + " ");

            //Constrói os dois próximos números binários a serem imprimidos na ordem (um com mais um '0' e o outro com mais um '1'),
            // quando a fila estiver cheia o loop só irá imprimir os números que faltam remover da fila

            filaBinarios.insere(numeroBinario + "0");
            filaBinarios.insere(numeroBinario + "1");
        }
        System.out.print('\n');
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Informe um número N para ser realizada uma contagem " +
                "em binário de 1 até N:");
        int n = 1;
        if(sc.hasNextInt()) n = sc.nextInt();

        if (n > 1)
            imprimeBinarios(n);
        else
            System.out.println("N deve ser um número maior que 1.");
    }
}
