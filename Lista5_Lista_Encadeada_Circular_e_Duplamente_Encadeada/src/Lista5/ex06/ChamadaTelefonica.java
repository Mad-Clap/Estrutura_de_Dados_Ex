package Lista5.ex06;

public class ChamadaTelefonica {

    // O custo será representado por um inteiro
    private int custo;
    private int numero;

    public ChamadaTelefonica(int custo, int numero) {
        this.custo = custo;
        this.numero = numero;
    }

    public int getNumero() {
        return numero;
    }

    public int getCusto() {
        return custo;
    }
}
