package Lista5.ex03;

public class Main {

    public static void main(String[] args) {
        //Implemente um método que inverta a ordem de uma lista circular e retorne a lista
        //invertida.

        ListaCircular l1 = new ListaCircular();

        l1.insere(1);
        l1.insere(3);
        l1.insere(5);
        l1.insere(7);
        l1.insere(9);

        ListaCircular l2 = l1.inverteLista();
        l2.imprime();
    }
}
