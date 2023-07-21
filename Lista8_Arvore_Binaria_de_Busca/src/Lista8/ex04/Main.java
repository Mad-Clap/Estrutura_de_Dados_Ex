package Lista8.ex04;

public class Main {

    public static void main(String[] args) {
        //Implemente um método que, dados parâmetros Chave chaveMin e Chave chaveMax,
        //remova de uma árvore binária de busca todos os nós cujas chaves não estão contidas no
        //intervalo [chaveMin, chaveMax]. O método deve retornar true caso tenha sido
        //possível remover ao menos um nó; e false, caso contrário.

        ArvBinBusca<Integer,Integer> ex04 = new ArvBinBusca<>();
        ex04.put(1,2);
        ex04.put(2,3);
        ex04.put(3,3);
        ex04.put(4,4);
        ex04.mostra();
        System.out.print('\n');
        System.out.println(ex04.removeForaIntervalo(2,3));
        ex04.mostra();

    }
}
