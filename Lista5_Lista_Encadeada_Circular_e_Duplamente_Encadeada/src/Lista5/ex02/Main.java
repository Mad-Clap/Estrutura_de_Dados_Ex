package Lista5.ex02;

public class Main {

    public static void main(String[] args) {
        //Crie um método para concatenar alternadamente
        //elementos de uma lista circular, para a qual o método é chamado, com a lista lista2 recebida
        //como parâmetro. O resultado da operação deve ser colocado em uma terceira lista que será
        //retornada.

	ListaCircular l1 = new ListaCircular();
	ListaCircular l2 = new ListaCircular();

        l1.insere(1);
        l1.insere(3);
        l1.insere(5);
        l1.insere(7);
        l1.insere(9);

        l2.insere(2);
       l2.insere(4);
       l2.insere(6);
       l2.insere(8);


        ListaCircular l3 = l1.merge(l2);
        l3.imprime();

    }
}
