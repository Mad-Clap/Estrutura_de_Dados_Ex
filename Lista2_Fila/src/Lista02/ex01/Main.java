package Lista02.ex01;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        //Sabe-se que existem partes de sistemas operacionais que cuidam da ordem em que os
        //processos devem ser executados. Por exemplo, em um sistema de computação “timeshared”, existe a necessidade de manter um conjunto de processos em uma fila. Realize
        //uma modelagem e crie classes que representam um Processo e o Sistema Operacional.
        //Dessa maneira, escreva métodos para:
        //a. Incluir novos processos em uma fila de processos;
        //b. Retirar da fila o processo com o maior tempo de espera;
        //c. Imprimir o conteúdo da fila de processos em determinado momento. Cada processo
        //possui um número identificador.

	    SistemaOperacional so = new SistemaOperacional(3);
        Scanner sc = new Scanner(System.in);

        boolean termina=false;
        while (!termina) {
            System.out.println("------------- MENU DO SISTEMA OPERACIONAL -------------");
            System.out.println("1. Incluir processo na fila de processos");
            System.out.println("2. Retirar da fila o processo com maior tempo de espera");
            System.out.println("3. Imprimir conteúdo da fila de processos");
            System.out.println("0. Finalizar Sistema Operacional");
            int navegador =-1;
            if(sc.hasNextInt()) navegador = sc.nextInt();

            switch (navegador) {
                case 1: so.insereProcesso();
                    break;

                case 2: so.retiraProcessoMaiorTempoEsp();
                    break;

                case 3: so.imprimeProcessos();
                    break;

                case 0: termina = true;
                        so.timer.cancel();
                    break;
            }
        }
        sc.close();
    }
}
