package Lista4.ex05;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
		//Suponha agora uma derivação do exercício 4, em que se deseje reverter uma
		//frase usando listas encadeadas. Além de inverter a ordem da frase em si, também se
		//deseja inverter a ordem das letras de cada palavra individualmente. Implemente então um
		//método para realizar essa tarefa. Note que cada letra de cada palavra deve estar
		//armazenada em um objeto Elo da lista

	    Scanner sc = new Scanner(System.in);
	    System.out.println("Digite uma frase:");
	    String frase = sc.nextLine();

	    Lista lista = new Lista();
        System.out.println(lista.listaString(frase));

    }
}
