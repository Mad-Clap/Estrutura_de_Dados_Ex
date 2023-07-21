package Lista02.ex05;

import java.util.Scanner;

public class Main {

    public static void adicionaAdulto(FilaDuplaCaixa filaDoCaixa){

    }

    public static void main(String[] args) {
        //Uma loja deseja implementar um sistema diferente em seus caixas. Haverá apenas uma
        //fila e essa fila será ordenada conforme o grau de prioridade dos clientes. Haverá dois tipos
        //de cliente, que possuem diferentes prioridades: o “cliente idoso” e o “cliente adulto”. Esses
        //serão ordenados da seguinte forma:

        //i) Um cliente idoso sempre passará a frente dos clientes adultos;
        //ii) No caso de mais de um cliente idoso na fila, o que tiver entrado primeiro na fila
        //permanece em sua posição e o outro se posiciona após ele;
        //iii) Implemente os métodos e atributos necessários para que esse sistema de fila seja
        //possível. Você pode utilizar e modificar a implementação de fila que julgar mais adequada

        CaixaLoja caixa1 = new CaixaLoja("1",4);
        Scanner sc = new Scanner(System.in);
        int clienteNumero = 1;

        boolean termina=false;
        while (!termina) {
            System.out.println("------------- CAIXA DA LOJA -------------");
            System.out.println("1. Entra um adulto na fila do caixa");
            System.out.println("2. Entra um idoso na fila do caixa");
            System.out.println("3. A pessoa na frente da fila é atendida");
            System.out.println("0. Finalizar");

            int navegador =-1;
            if(sc.hasNextInt()) navegador = sc.nextInt();

            switch (navegador) {
                case 1: caixa1.adicionaAdulto();
                        break;
                case 2: caixa1.adicionaIdoso();
                    break;
                case 3: caixa1.atendeCliente();
                    break;
                case 0: termina = true;
                    break;
            }
        }
        sc.close();
    }
}
