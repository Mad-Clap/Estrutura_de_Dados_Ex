package Ex01;

public class Main {

    public static void main(String[] args) {
        //Implemente um método com a melhor complexidade possível para conseguir a
        //quantidade de inteiros pares de uma pilha.
        Pilha pilha = new Pilha(5);

        while (!pilha.pilhaCheia()){
            int i=1+(int)(Math.random()*30);
            pilha.push(i);
        }

        System.out.printf("Quantidade de inteiros pares na pilha = %d\n", pilha.getQtdInteirosPar());

        while (!pilha.pilhaVazia()){
            System.out.printf("%d ",pilha.pop());
        }
        System.out.println("\nFim do método pop");

        System.out.printf("Quantidade de inteiros pares na pilha = %d\n", pilha.getQtdInteirosPar());
    }
}
