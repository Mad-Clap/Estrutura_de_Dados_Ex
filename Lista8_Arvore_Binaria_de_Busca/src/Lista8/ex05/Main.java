package Lista8.ex05;

public class Main{

    public static void main(String[] args) {
        //Implemente um método que ache o menor ancestral comum entre dois dados nós da
        //árvore, isto é, o nó de nível mais alto que seja ancestral dos dois nós. Note que tal menor
        //ancestral comum pode não ser o ancestral direto dos dois nós em questão.

	ArvBinBusca<Integer,Integer> ex05 = new ArvBinBusca<>();

        ex05.put(4, 4);
        ex05.put(1, 1);
        ex05.put(2, 2);
        ex05.put(3, 3);
        ex05.put(5, 5);
        ex05.put(6, 6);
        ex05.put(7, 7);

        ex05.mostra();
        System.out.print('\n');

        System.out.print(ex05.teste());
    }
}
