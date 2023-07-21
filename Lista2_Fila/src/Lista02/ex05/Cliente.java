package Lista02.ex05;

public class Cliente {
    //Classe dos clientes que entram na fila do caixa da loja. Eles tem um atributo "numeroCliente" que
    // indica a ordem em que os clientes entraram na fila, e não suas posições nela
    int numeroCliente;

    public Cliente(int numeroCliente) {
        this.numeroCliente = numeroCliente;
    }

    public int getNumeroCliente() {
        return numeroCliente;
    }

}
