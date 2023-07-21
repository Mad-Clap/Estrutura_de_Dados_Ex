package Lista5.ex06;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        //Uma central de atendimento a clientes tem vários atendentes, mas um número muito
        //maior de linhas telefônicas recebendo chamadas. Tais chamadas são colocadas em uma
        //fila de espera segundo a ordem de chegada e são atendidas quando possível. Ocorre que
        //algumas destas chamadas vêm de longe e, neste caso, se elas ficam esperando na linha,
        //elas causam uma despesa muito maior do que as chamadas que vêm de perto. Dessa
        //maneira, deseja-se implementar uma solução alternativa que coloque as chamadas em uma
        //fila obedecendo à prioridade definida pelo custo (de modo que as mais caras sejam
        //atendidas primeiro) e, em caso de empate no custo, deve ser respeitada a ordem de
        //chegada. Efetue então uma modelagem Orientada a Objetos desta realidade e implemente
        //a fila de prioridade usando Lista Duplamente Encadeada.

        FilaEspera filaEspera = new FilaEspera();
        Scanner sc = new Scanner(System.in);
        int numero = 0;
        int opcao = -1;
        while (opcao != 0) {
            opcao = -1;
            System.out.println("-- MENU DA FILA DE ESPERA --");
            System.out.println("(1) Adicionar chamada na fila de espera");
            System.out.println("(2) Atender chamada com prioridade");
            System.out.println("(0) Finalizar simulação");

            if (sc.hasNextInt()) opcao = sc.nextInt();
            else sc.next();
            switch (opcao) {

                case 1:
                    System.out.println("Informe o custo dessa chamada:");
                    int custo;
                    if (sc.hasNextInt()) custo = sc.nextInt();

                    else {
                        sc.next();
                        System.out.println("Entrada inválida");
                        break;
                    }
                    if (custo > 0) {
                        filaEspera.insereChamada(new ChamadaTelefonica(custo,++numero));
                        System.out.println("A chamada de custo " + custo + " foi adicionada à fila de espera");
                    } else {
                        System.out.println("O custo da chamada deve ser maior que 0.");
                    }
                    break;

                case 2:
                    ChamadaTelefonica chamada = filaEspera.removeChamada();
                    if (chamada != null)
                        System.out.println("A "+chamada.getNumero()+"° chamada telefônica a entrar na lista" +
                                " prioritária de custo " + chamada.getCusto() + " foi atendida");
                    else
                        System.out.println("Não há chamadas para atender.");
                    break;
            }
        }
    }
}
