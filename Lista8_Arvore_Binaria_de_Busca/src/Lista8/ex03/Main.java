package Lista8.ex03;

public class Main {

    public static void main(String[] args) {
        //Desenvolva um método que crie uma árvore binária de busca a partir de uma árvore
        //binária passada como parâmetro


        Arvbin<Integer> a7 = new Arvbin<Integer>(7),
                a6 = new Arvbin<Integer>(6),
                a5 = new Arvbin<Integer>(5,a6,a7),
                a4 = new Arvbin<Integer>(4),
                a3 = new Arvbin<Integer>(3),
                a2 = new Arvbin<Integer>(2,a3,a4),
                a1 = new Arvbin<Integer>(1, a2, a5);

        ArvBinBusca<Integer,Integer> ex03 = new ArvBinBusca<>();
        ex03.transformaBST(a1);
        ex03.mostra();
    }
}
