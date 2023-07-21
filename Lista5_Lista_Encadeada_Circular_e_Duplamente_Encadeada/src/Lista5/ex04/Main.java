package Lista5.ex04;

public class Main {

    public static void main(String[] args) {
        //crie um método que troque a posição de dois elos em uma lista duplamente encadeada,
        //cujas posições na lista são passadas como parâmetros.

        ListaDuplamente l1 = new ListaDuplamente();
        l1.insere(2);
        l1.insere(3);
        l1.insere(1);

        l1.imprime();
        l1.trocaElos(1,2);
        l1.imprime();
    }
}
