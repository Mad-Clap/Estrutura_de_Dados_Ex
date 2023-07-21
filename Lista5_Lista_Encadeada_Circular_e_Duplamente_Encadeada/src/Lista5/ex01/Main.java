package Lista5.ex01;

public class Main {

    public static void main(String[] args) {
        //Dadas duas listas duplamente encadeadas L1 e L2, sem elementos repetidos,
        //implemente um método estático que realize a interseção das duas listas, criando uma
        //terceira lista L3 contendo a interseção entre as duas listas

        ListaDuplamente l1 = new ListaDuplamente();
        ListaDuplamente l2 = new ListaDuplamente();

        l1.insere(1);
        l1.insere(2);
        l1.insere(3);
        l1.insere(4);
        l1.insere(5);
        l1.insere(6);
        l1.insere(7);
        l1.insere(8);
        l1.insere(9);

        l2.insere(2);
        l2.insere(4);
        l2.insere(6);
        l2.insere(8);

        ListaDuplamente l3 = ListaDuplamente.intersecao(l1,l2);
        l3.imprime();

    }
}
