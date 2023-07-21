package Lista02.ex04;

public class Main {

    public static void main(String[] args) {
        //Implemente um método estático na classe Fila, a qual implementa uma fila circular. Eses
        //método deve receber uma fila circular e retornar uma fila circular dupla.

        // O método pedido está na classe FilaEx04
        FilaEx04 fila = new FilaEx04(5);
        fila.insere(1); fila.insere(2); fila.insere(3); fila.insere(4);
        fila.insere(5);

        FilaDupla resposta = FilaEx04.retornaFilaDupla(fila);

        //Print usando remove e removeFim, método exclusivo da classe 'FilaDupla',
        // na fila dupla criada 'resposta'
        while (!resposta.vazia()){
            System.out.println(resposta.remove());

            if(!resposta.vazia()) System.out.println(resposta.removeFim());
        }

    }

}
