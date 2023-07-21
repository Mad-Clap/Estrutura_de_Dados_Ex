package Lista4.ex02;

public class Main {

    public static void main(String[] args) {
        //Elabore um algoritmo que, dadas duas listas encadeadas ordenadas, intercale as duas
        //listas de forma que a lista resultante seja também ordenada.

        ListaOrdenada l1 = new ListaOrdenada();
        ListaOrdenada l2 = new ListaOrdenada();

        l1.insere(1);
        l1.insere(3);
        l1.insere(5);
        l1.insere(5);
        l1.insere(7);


        l2.insere(2);
        l2.insere(4);
        l2.insere(6);
        l2.insere(8);




        ListaOrdenada listaIntercalada = l1.listaIntercalada(l2);
        listaIntercalada.imprime();
        System.out.println(listaIntercalada.tamanho());
        listaIntercalada.remove(1);
        System.out.println(listaIntercalada.tamanho());

    }
}
