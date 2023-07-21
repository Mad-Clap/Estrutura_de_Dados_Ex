package Lista7.ex02;
public class Main {

    public static void main(String[] args) {
        //Implemente um método que busque por um parâmetro Arvbin<Integer> no e, a partir
        //desse no, retorne a soma dos valores armazenados nos nós da subárvore enraizada em
        //no.


        Arvbin<Integer> a7 = new Arvbin<Integer>(7),
                a6 = new Arvbin<Integer>(6),
                a5 = new Arvbin<Integer>(5,a6,a7),
                a4 = new Arvbin<Integer>(4),
                a3 = new Arvbin<Integer>(3),
                a2 = new Arvbin<Integer>(2,a3,a4),
                a1 = new Arvbin<Integer>(1, a2, a5);

        System.out.println("soma dos valores armazenados nos nós da subárvore enraizada em a1: "
                + Arvbin.retornaSomaSubarvore(a1));
        System.out.println("soma dos valores armazenados nos nós da subárvore enraizada em a2: "
                + Arvbin.retornaSomaSubarvore(a2));
        System.out.println("soma dos valores armazenados nos nós da subárvore enraizada em a5: "
                + Arvbin.retornaSomaSubarvore(a5));
        System.out.println("soma dos valores armazenados nos nós da subárvore enraizada em a6: "
                + Arvbin.retornaSomaSubarvore(a6));

    }
}
