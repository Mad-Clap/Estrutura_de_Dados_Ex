package Lista8.ex02;

public class Main {

    public static void main(String[] args) {
        //mplemente um método que, dado um int[] vetor passado como parâmetro, construa
        //uma árvore binária de busca com os elementos contidos no vetor

	    ArvBinBusca<Integer,Integer> vetArvore = new ArvBinBusca<>();
	    int[] vet = new int[7];
	    for (int i=0;i<7;i++)
	        vet[i]=7-i;

        vetArvore.constroiArvore(vet);
        vetArvore.mostra();
        System.out.println();

        for(int i =1;i<=7;i++){
            System.out.println("O no com chave "+i+" armazena o inteiro "+ vetArvore.get(i));
        }
    }
}
