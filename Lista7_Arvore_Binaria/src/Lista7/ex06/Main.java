package Lista7.ex06;
public class Main {

    public static void main(String[] args) {
        //Implemente um método que verifica se uma árvore binária possui estrutura simétrica ou não,
        // retornando true se a árvore for simétrica e false, caso contrário.
        // Uma árvore é simétrica se suas sub-árvores
        //esquerda e direita corresponderem ao espelho uma da outra em relação tanto à estrutura
        //quanto ao conteúdo dos nós.

        Arvbin<Integer> a7 = new Arvbin<Integer>(4),
                a6 = new Arvbin<Integer>(3),
                a5 = new Arvbin<Integer>(2,a7,a6),
                a4 = new Arvbin<Integer>(4),
                a3 = new Arvbin<Integer>(3),
                a2 = new Arvbin<Integer>(2,a3,a4),
                a1 = new Arvbin<Integer>(1, a2, a5);

        System.out.println(a1.eSimetrica());
        a1.mostra();
    }
}
