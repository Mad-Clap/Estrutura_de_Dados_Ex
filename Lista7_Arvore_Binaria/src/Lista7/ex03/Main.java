package Lista7.ex03;
public class Main {

    public static void main(String[] args) {
        //Duas árvores binárias são similares se: as duas são vazias ou as duas não são vazias, e
        //se suas subárvores da esquerda são similares e se suas subárvores da direita são também
        //similares. Implemente um método para determinar se uma árvore
        //passada como parâmetro é similar à árvore corrente:


        Arvbin<Integer> a7 = new Arvbin<Integer>(7),
                a6 = new Arvbin<Integer>(6),
                a5 = new Arvbin<Integer>(5,a6,a7),
                a4 = new Arvbin<Integer>(4),
                a3 = new Arvbin<Integer>(3),
                a2 = new Arvbin<Integer>(2,a3,a4),
                a1 = new Arvbin<Integer>(1, a2, a5);


        Arvbin<Integer> b7 = new Arvbin<Integer>(14),
                b6 = new Arvbin<Integer>(13),
                //b5 = new Arvbin<Integer>(12,b6,b7),
                b4 = new Arvbin<Integer>(11),
                b3 = new Arvbin<Integer>(10),
                b2 = new Arvbin<Integer>(9,b3,b4),
                b1 = new Arvbin<Integer>(8, b2,null);

        System.out.println(a1.eSimilar(b1));
    }
}
