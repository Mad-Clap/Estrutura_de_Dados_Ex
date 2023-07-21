package Lista7.ex04;
public class Main {

    public static void main(String[] args) {
        //Implemente um método que recebe um parâmetro T valor e apaga o nó em que esse
        //valor está armazenado. Esse método deve realizar um tratamento para que os demais
        //nós da árvore se mantenham (isto é, não sejam perdidos).


        Arvbin<Integer> a7 = new Arvbin<Integer>(7),
                a6 = new Arvbin<Integer>(6),
                a5 = new Arvbin<Integer>(5,a6,a7),
                a4 = new Arvbin<Integer>(4),
                a3 = new Arvbin<Integer>(3),
                a2 = new Arvbin<Integer>(2,a3,a4),
                a1 = new Arvbin<Integer>(1, a2, a5);

        a1.mostra();
        System.out.print('\n');
        a2.delete(4);
        a5.delete(2);
        a1.mostra();
        a1.delete(5);
        System.out.print('\n');
        a1.mostra();

    }
}
