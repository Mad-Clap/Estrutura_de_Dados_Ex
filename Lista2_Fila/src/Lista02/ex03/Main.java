package Lista02.ex03;

public class Main {

    public static void main(String[] args) {
        //Como você implementaria uma fila de pilhas? E uma pilha de filas? E uma fila de filas?
        //Implemente cada uma dessas estruturas

        //Transformando a classe Fila e Pilha em classes que podem armazenar um tipo objeto, generalizando com um type parameter,
        // ambas podem armazenar/indexar um objeto do tipo Pilha ou Fila também.

        //Criando um objeto Fila que recebe objetos do tipo Pilha
        FilaEx03<Pilha> filaPilha = new FilaEx03<>(3);

        //Criando um objeto Pilha que recebe objetos do tipo Fila
        Pilha<FilaEx03> pilhaFila = new Pilha<>(3);

        //Criando um objeto Fila que recebe outros objetos do tipo Fila
        FilaEx03<FilaEx03> filaFila = new FilaEx03<>(3);

        //Criando objetos Fila e Pilha que podem ser recebidos/ indexados pelos objetos Pilha/Filha
        // criados acima
        FilaEx03<Character> fila = new FilaEx03<>(3);
        fila.insere('a'); fila.insere('b'); fila.insere('c');

        Pilha<Integer> pilha = new Pilha<>(3);
        pilha.push(1); pilha.push(2); pilha.push(3);

        FilaEx03<Boolean> filaInteger = new FilaEx03<>(3);
        filaInteger.insere(true); filaInteger.insere(false); filaInteger.insere(true);

        //Colocando os objetos Pilha/Fila dentros dos outros objetos Pilha/Fila já criados que podem o receber
        filaPilha.insere(pilha);

        pilhaFila.push(fila);

        filaFila.insere(filaInteger);


        //Dando novas variáveis aos objetos por meio dos métodos remove() e pop()
        // (e os removendo das filas e pilhas por conseguência) e os printando

        FilaEx03 filaImprime = pilhaFila.pop();
        while (!filaImprime.vazia()){System.out.println(filaImprime.remove());}
        System.out.print('\n');

        Pilha pilhaImprime = filaPilha.remove();
        while (!pilhaImprime.pilhaVazia()){System.out.println(pilhaImprime.pop());}
        System.out.print('\n');

        filaImprime = filaFila.remove();
        while (!filaImprime.vazia()){System.out.println(filaImprime.remove());}
        System.out.print('\n');


    }
}
