package Lista7.ex01;

public class Main {

    public static void main(String[] args) {
        //Crie métodos que imprimam os nós de uma árvore binária em Pré-ordem,
        //Pós-ordem e em Ordem.

        Arvbin<Integer> a7 = new Arvbin<Integer>(7),
                a6 = new Arvbin<Integer>(6),
                a5 = new Arvbin<Integer>(5,a6,a7),
                a4 = new Arvbin<Integer>(4),
                a3 = new Arvbin<Integer>(3),
                a2 = new Arvbin<Integer>(2,a3,a4),
                a1 = new Arvbin<Integer>(1, a2, a5);

        System.out.print("Impressão em pré-ordem: ");
        a1.imprimePreOrdem();
        System.out.print('\n');

        System.out.print("Impressão em pós-ordem: ");
        a1.imprimePosOrdem();
        System.out.print('\n');

        System.out.print("Impressão em ordem: ");
        a1.imprimeEmOrdem();
        System.out.print('\n');
    }
}
