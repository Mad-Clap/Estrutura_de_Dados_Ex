package Lista4.ex06;

public class Main {
    public static void main(String[] args) {
        //Um diretório é uma lista de arquivos e outros diretórios. Assim sendo, crie um programa
        //que receba o nome de um diretório e imprima o nome de todos os arquivos e outros
        //diretórios contidos naquele, de modo que o conteúdo de cada diretório seja recursivamente
        //listado (de forma indentada) sob o nome do diretório pai.

        Diretorio systemDrive = new Diretorio("SystemDrive");

        Diretorio jogos = new Diretorio("Jogos");
        jogos.insere(new Arquivo("World Of Warcraft"));
        jogos.insere(new Arquivo("Paciência"));
        jogos.insere(new Arquivo("Campo Minado"));

        Diretorio faculdade = new Diretorio("Faculdade");
        faculdade.insere(new Arquivo("TPD"));
        Diretorio aces = new Diretorio("ACEs");
        aces.insere(new Arquivo("ACE3"));
        aces.insere(new Arquivo("ACE2"));
        aces.insere(new Arquivo("ACE1"));
        faculdade.insere(aces);
        faculdade.insere(new Arquivo("AA"));
        faculdade.insere(new Arquivo("EDD2"));
        faculdade.insere(new Arquivo("EDD1"));

        Diretorio filmes = new Diretorio("Filmes");

        Diretorio superheroi = new Diretorio("Super-heróicos");
        Diretorio marvel = new Diretorio("Marvel");
        marvel.insere(new Arquivo("Homem-Aranha"));
        marvel.insere(new Arquivo("Vingadores"));
        Diretorio dc = new Diretorio("DC");
        dc.insere(new Arquivo("Superman"));
        superheroi.insere(dc);
        superheroi.insere(marvel);

        Diretorio drama = new Diretorio("Drama");
        drama.insere(new Arquivo("Brilho Eterno de Uma Mente Sem Lembranças"));

        Diretorio comediaRomantica = new Diretorio("Comédias Românticas");

        filmes.insere(comediaRomantica);
        filmes.insere(drama);
        filmes.insere(superheroi);

       systemDrive.insere(filmes);
       systemDrive.insere(faculdade);
       systemDrive.insere(jogos);

        // Basta chamar o método imprimeArquivos que todos os arquivos e diretórios a partir do objeto
        // diretório chamado são impressos de forma recursiva
        System.out.println("Impressão do diretório 'Jogos':");
        jogos.imprimeArquivos();
        System.out.print('\n');
        System.out.println("Impressão do diretório 'Filmes':");
        filmes.imprimeArquivos();
        System.out.print('\n');
        System.out.println("Impressão do diretório 'SystemDrive':");
        systemDrive.imprimeArquivos();

    }

}
