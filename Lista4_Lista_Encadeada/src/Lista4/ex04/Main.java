package Lista4.ex04;
import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
		//Suponha que uma frase é representada por uma lista encadeada, sendo que cada elo
		//contém uma string representando um token, isto é, um caracter de pontuação ou uma
		//palavra. Escreva um algoritmo para retornar a frase inteira.

	    Scanner sc = new Scanner(System.in);
	    System.out.println("Digite uma frase:");
	    String frase = sc.nextLine();

	    Lista lista = new Lista();
        System.out.println(lista.listaString(frase));

    }
}
