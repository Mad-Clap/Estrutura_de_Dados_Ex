package Lista4.ex07;

public class Inimigo
{
    private int vida;
    private double danoPorSegundo;

    public Inimigo(int vida, double danoPorSegundo) {
        this.vida = vida;
        this.danoPorSegundo = danoPorSegundo;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    public int getVida() {
        return vida;
    }

    public void setDanoPorSegundo(double danoPorSegundo) {
        this.danoPorSegundo = danoPorSegundo;
    }

    public double getDanoPorSegundo() {
        return danoPorSegundo;
    }

}