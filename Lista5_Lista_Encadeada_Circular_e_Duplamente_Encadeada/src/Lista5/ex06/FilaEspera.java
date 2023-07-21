package Lista5.ex06;

public class FilaEspera {
    private ListaDuplamente filaEspera;

    public FilaEspera() {
        filaEspera = new ListaDuplamente();
    }

    public void insereChamada(ChamadaTelefonica chamada) {
        filaEspera.insere(chamada);
    }

    public ChamadaTelefonica removeChamada() {
        return filaEspera.remove();
    }

}
