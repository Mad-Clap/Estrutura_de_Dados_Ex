package Lista4.ex01;

import Lista4.ex02.ListaOrdenada;

public class Main {

    public static void main(String[] args) {
        //Implemente um método tamanho() que retorne o tamanho de uma lista
        // com a menor complexidade possível

        Lista l1 = new Lista();

        l1.insere(1);
        l1.insere(3);
        System.out.println(l1.tamanho());
        l1.remove(1);
        System.out.println(l1.tamanho());

    }
}
