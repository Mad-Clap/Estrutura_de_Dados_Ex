package Lista4.ex03;

public class Main {

    public static void main(String[] args) {
        //Implemente uma lista ordenada genérica que armazene nomes em ordem alfabética.

        ListaOrdenada<String> listaOrdenada = new ListaOrdenada<>();

        listaOrdenada.insere("Zidane");
        listaOrdenada.insere("Augusto");
        listaOrdenada.insere("Xuxa");
        listaOrdenada.insere("Henrique");
        listaOrdenada.insere("Ayrton Senna");
        listaOrdenada.insere("Pelé");

        listaOrdenada.imprime();
    }
}
