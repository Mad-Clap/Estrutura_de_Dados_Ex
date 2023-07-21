package Lista5.ex05;


public class Main {

    public static void main(String[] args) {
        //crie um método que use recursão para verificar se
        //uma lista duplamente encadeada, pelo qual o método é chamado,
        // é igual a uma outra lista duplamente encadeada passada como parâmetro

        ListaDuplamente lista1 = new ListaDuplamente();
        lista1.insere(1);
        lista1.insere(2);
        lista1.insere(3);

        ListaDuplamente lista2 = new ListaDuplamente();
        lista2.insere(1);
        lista2.insere(2);
        lista2.insere(3);
        //lista2.insere(5);

        System.out.print(lista1.verificaIgualdade(lista2));
    }
}
