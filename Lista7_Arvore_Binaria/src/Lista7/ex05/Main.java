package Lista7.ex05;
public class Main {

    public static void main(String[] args) {
        //Desenvolva um método que, dado um parâmetro T valor, torne o nó que contém esse
        //valor a nova raiz da árvore.

        Arvbin<Integer> a7 = new Arvbin<Integer>(7),
                a6 = new Arvbin<Integer>(6),
                a5 = new Arvbin<Integer>(5,a6,a7),
                a4 = new Arvbin<Integer>(4),
                a3 = new Arvbin<Integer>(3),
                a2 = new Arvbin<Integer>(2,a3,a4),
                a1 = new Arvbin<Integer>(1, a2, a5);

        System.out.println("Árvore antes de mudar seu nó raíz:");
        a1.mostra();
        a1.tornaRaiz(5);
        System.out.print('\n');
        System.out.println("Árvore após mudar seu nó raíz:");
        a1.mostra();
    }
}
