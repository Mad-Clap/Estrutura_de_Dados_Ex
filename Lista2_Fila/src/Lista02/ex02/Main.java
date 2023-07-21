package Lista02.ex02;

public class Main {

    public static void main(String[] args) {
        //implemente um método de Fila que receba outras duas filas f1 e f2 e transfira alternadamente os
        //elementos de f1 e f2 para a fila corrente (cujo método foi chamado). A seguir está ilustrado
        //um exemplo:
        //f1 = 1,2,3
        //f2 = 4,5,6
        //filaMista = 1,4,2,5,3,6
        //Note que, ao final desse método, as filas f1 e f2 deverão estar vazias e a fila para o qual o
        //método foi chamado deve conter todos os valores originalmente em f1 e f2 (inicialmente a
        //fila para a qual o método foi chamado pode ou não estar vazia). O método transfere, no
        //máximo, quantos elementos couberem na fila. Tal método deve obedecer ao seguinte
        //protótipo:

        FilaEx02 f1 = new FilaEx02(4);
        FilaEx02 f2 = new FilaEx02(4);

        // Preenchendo as filas f1 e f2
        f1.insere(1); f1.insere(3); f1.insere(5); f1.insere(7);

        f2.insere(2); f2.insere(4); f2.insere(6);f2.insere(8);

        // Fila Mista
        FilaEx02 filaMista = new FilaEx02(8);

        //Possíveis elementos para não executar o método combinaFilas com a fila mista vazia. Nesse caso
        // fila mista irá ter apenas os números que puderam ser inseridos até ela ter ficado cheia

        //filaMista.insere(2); filaMista.insere(9); filaMista.insere(98);
        //filaMista.insere(56); filaMista.insere(69);

        // Método combinaFilas
        filaMista.combinaFilas(f1,f2);

        // Impressão da fila
        System.out.println("-- IMPRESSÃO DA FILA --");
        while (!filaMista.vazia()) {
            System.out.println("          "+filaMista.remove());
        }
    }

}
