package Lista4.ex07;

public class Main {

    static void efetuarDano(Lista listaInimigos, Inimigo inimigo, double dano){
        /*
         No desenvolvimento de um jogo, é necessário armazenar os inimigos que seu
        personagem está enfrentando na fase. Um inimigo é definido como uma instância da classe
        “Inimigo”, que possui a seguinte estrutura:
            public class Inimigo{
                private int vida;
                private double danoPorSegundo;
                public void setVida(int vida);
                public int getVida();
                public void setDanoPorSegundo(double danoPorSegundo);
                public double getDanoPorSegundo();
            }

        Por sua vez, os inimigos são armazenados em uma lista encadeada que possui os
        seguintes métodos:
        public void inserir(Inimigo inimigo);
        public Inimigo localizar(Inimigo inimigo);
        public int efetuarDano(Inimigo inimigo, double dano);
        Considere que o método efetuarDano(Inimigo inimigo, double dano)
        remove o inimigo da estrutura caso o dano sofrido reduza a vida do objeto inimigo a zero.
        Dessa maneira, implemente essa estrutura de dados para o jogo em questão.
         */

        //efetua o dano no inimigo e retorna a condição dele
        int danoCausado = listaInimigos.efetuarDano(inimigo, dano);

        //Se o dano retornado for -1, o inimigo não está na lista encadeada
        if(danoCausado == -1) {
            System.out.println("Este inimigo já foi derrotado (não está na lista encadeada).");
            return;
        }
        System.out.println("O inimigo sofreu "+dano+" ponto(s) de dano!");
        if(danoCausado == 0) System.out.println("O inimigo foi derrotado!");
        if (danoCausado > 0) System.out.println("O inimigo ainda está de pé!");
    }
    public static void main(String[] args) {
        Lista listaInimigos = new Lista();

        Inimigo i1 = new Inimigo(50, 20);
        Inimigo i2 = new Inimigo(100, 20);
        Inimigo i3 = new Inimigo(150, 30);
        Inimigo i4 = new Inimigo(200, 20);
        Inimigo i5 = new Inimigo(250, 40);

        listaInimigos.inserir(i1);
        listaInimigos.inserir(i2);
        listaInimigos.inserir(i3);
        listaInimigos.inserir(i4);
        listaInimigos.inserir(i5);

        efetuarDano(listaInimigos,i2,50);
        efetuarDano(listaInimigos,i2,51);
        efetuarDano(listaInimigos,i2,50);
    }
}
