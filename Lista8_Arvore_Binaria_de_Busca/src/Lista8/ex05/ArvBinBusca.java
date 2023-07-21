package Lista8.ex05;

import java.util.NoSuchElementException;

public class ArvBinBusca<Chave extends Comparable<Chave>, Valor> 
{
	private No raiz; /* Raiz da �rvore. */

	private class No
	{
		private Chave chave; /* Chave usada nas compara��es. */
		private Valor valor; /* Informa��o armazenada. */
		private No esq, dir; /* Refer�ncias para sub�rvores esquerda e direita. */

		/* Cria um n� com chave e valor fornecidos e esq = dir = null. */
		public No(Chave chave, Valor valor)
		{
			this.chave = chave;
			this.valor = valor;
			this.esq = null;
			this.dir = null;
		}
		
		/* Cria um n� com chave e valor fornecidos. As sub�rvores esq e dir s�o
		 * passadas por par�metro. */
		public No(Chave chave, Valor valor, No esq, No dir)
		{
			this.chave = chave;
			this.valor = valor;
			this.esq = esq;
			this.dir = dir;
		}
	}
	
	/**
	 *  Cria��o de uma �rvore vazia. 
	 */
	public ArvBinBusca()
	{
		raiz = null;
	}
	
	/** 
	 * Verifica se a �rvore est� vazia.
	 * 
	 * @return se a �rvore est� vazia ou possui algum elemento
	 */
	public boolean vazia()
	{
		return (raiz == null);
	}
	
	/**
	 * Apresenta o conte�do da �rvore em ordem sim�trica.
	 */
	public void mostra()
	{
		mostra(raiz);
	}
	
	private void mostra(No x)
	{
		/* Caso base (crit�rio de parada). */
		if(x == null)
			return;
		
		System.out.print("[");
		
		/* Chamada recursiva para a esquerda. */
		mostra(x.esq);
		
		/* Imprime a chave do n� corrente. */
		System.out.print("<" + x.chave + ">");
		
		/* Chamada recursiva para a direita. */
		mostra(x.dir);
		
		System.out.print("]");
	}
	
    /**
     * Retorna a menor chave da �rvore.
     *
     * @return a menor chave da �rvore
     * @throws NoSuchElementException se a �rvore est� vazia
     */
    public Chave min()
    {
        if(vazia()) 
        	throw new NoSuchElementException("�rvore est� vazia!");
        
        return min(raiz).chave;
    } 

    private No min(No x) { 
        if (x.esq == null) 
        	return x; 
        else
        	return min(x.esq); 
    }
    
    /**
     * Retorna o maior elemento da �rvore.
     *
     * @return o maior elemento da �rvore
     * @throws NoSuchElementException se a �rvore est� vazia
     */
    public Chave max() {
        if(vazia()) 
        	throw new NoSuchElementException("A �rvore est� vazia!");
        
        return max(raiz).chave;
    } 

    private No max(No x) {
        if (x.dir == null)
        	return x; 
        else
        	return max(x.dir); 
    }
    
    /**
     * Retorna o n�mero de n�s, isto �, pares (chave, valor), contidos na �rvore 
     * bin�ria de busca.
     * 
     * @return o n�mero de n�s da �rvore
     */
    public int tamanho()
    {
    	return tamanho(raiz);
    }
    
    private int tamanho(No x)
    {
    	/* Caso base (crit�rio de parada). */
    	if(x == null)
    		return 0;
    	
    	/* Chamada recursiva para sub�rvores esquerda e direita. */
    	return 1 + tamanho(x.esq) + tamanho(x.dir);
    }
    
    
    /**
     * Retorna a altura da �rvore bin�ria de busca.
     *
     * @return a altura da �rvore (uma �rvore de um �nico n� possui altura 0)
     */
    public int altura()
    {
    	return altura(raiz);
    }
    
    private int altura(No x)
    {
    	if(x == null)
    		return -1;
    	
    	int maxAltura = Math.max(altura(x.esq), altura(x.dir));
    	
    	return 1 + maxAltura;
    }
    
    
    /**
     * Essa �rvore bin�ria de busca cont�m a chave fornecida?
     *
     * @param  chave a chave fornecida
     * @return {@code true} se a �rvore cont�m a chave {@code chave} e
     *         {@code false} caso contr�rio
     * @throws IllegalArgumentException se {@code key} � {@code null}
     */
    public boolean contem(Chave chave) {
        if (chave == null) 
        	throw new IllegalArgumentException("A chave fornecida � null!");
        
        return get(chave) != null;
    }
	
    /**
     * Retorna o valor associado � chave fornecida.
     *
     * @param  chave a chave a ser buscada
     * @return o valor associado � chave fornecida se tal chave se encontra na �rvore
     *         e {@code null} se a chave n�o est� na �rvore
     * @throws IllegalArgumentException if {@code chave} is {@code null}
     */
    public Valor get(Chave chave) 
    {
        return get(raiz, chave);
    }

    private Valor get(No x, Chave chave) 
    {
        if(chave == null) 
        	throw new IllegalArgumentException("A chave fornecida � null!");
        
        /* A chave n�o se encontra na �rvore. */
        if(x == null)
        	return null;
        
        int cmp = chave.compareTo(x.chave);
        
        if(cmp < 0) /* Deve-se ir para a esquerda. */
        	return get(x.esq, chave);
        else if(cmp > 0) /* Deve-se ir para a direita. */
        	return get(x.dir, chave);
        else /* Chave encontrada. */
        	return x.valor;
    }
    
    /**
     * Insere na �rvore bin�ria de busca o par (chave, valor) fornecido. Caso a �rvore
     * j� possua a chave especificada, o valor antigo � sobrescrito com o novo valor 
     * fornecido. Remove o n� de chave igual � chave fornecida caso o valor especificado
     * seja {@code null}.
     *
     * @param  chave a chave fornecida
     * @param  valor o valor fornecido
     * @throws IllegalArgumentException se {@code chave} � {@code null}
     */
    public void put(Chave chave, Valor valor)
    {
        if(chave == null) 
        	throw new IllegalArgumentException("A chave fornecida � null!");
        
        if(valor == null) {
            delete(chave);
            return;
        }
        
        raiz = put(raiz, chave, valor);
    }

    private No put(No x, Chave chave, Valor valor)
    {
    	/* Caso base: encontrou a posi��o de inser��o. */
        if (x == null)
        	return new No(chave, valor);
        
        int cmp = chave.compareTo(x.chave);
        
        if(cmp < 0) /* Deve-se ir para a esquerda. */
        	x.esq = put(x.esq, chave, valor);
        else if(cmp > 0) /* Deve-se ir para a direita. */
        	x.dir = put(x.dir, chave, valor);
        else /* Caso tenha encontrado n� de mesma chave. */
        	x.valor = valor;
        
        return x;
    }
	
    /**
     * Remove o n� de menor chave da �rvore.
     *
     * @throws NoSuchElementException se a �rvore est� vazia
     */
    public void deleteMin() 
    {
        if(vazia())
        	throw new NoSuchElementException("A �rvore est� vazia!");
        
        raiz = deleteMin(raiz);
    }

    /* M�todo recursivo que anda sempre para a esquerda, procurando o n�
     * de menor chave a ser removido. */
    private No deleteMin(No x) 
    {
    	/* Caso n�o haja filho � esquerda, o n� corrente possui a menor chave. */
        if(x.esq == null) 
        	return x.dir;
        
        x.esq = deleteMin(x.esq);
        
        return x;
    }

    /**
     * Remove o n� de maior chave da �rvore.
     *
     * @throws NoSuchElementException se a �rvore est� vazia
     */
    public void deleteMax()
    {
        if(vazia())
        	throw new NoSuchElementException("A �rvore est� vazia!");
        
        raiz = deleteMax(raiz);
    }

    /* M�todo recursivo que anda sempre para a direita, procurando o n�
     * de maior chave a ser removido. */
    private No deleteMax(No x) 
    {
        if(x.dir == null)
        	return x.esq;
        
        x.dir = deleteMax(x.dir);
        
        return x;
    }
    
    /**
     * Remove o n� cuja chave seja igual � {@code chave} fornecida.
     * 
     * @param chave a chave fornecida
     * @return {@code true} se foi poss�vel remover o n� de chave {@code chave} e
     *         {@code false} caso contr�rio
     */
    public void delete(Chave chave)
    {    	
    	raiz = delete(raiz, chave);    	
    }
    
    /* Remove o n� com o valor "val" da "�rvore" a partir do n� para o qual est� sendo chamada a fun��o.
    Obs: "ref_no" � o ponteiro que referencia o n� para o qual est� sendo chamada a fun��o,
    o qual pode ter que ser modificado. Retorna false se o valor n�o pertencer � "�rvore".
    */
    private No delete(No x, Chave chave)
    {
    	if (x == null)
    		return null;

    	int cmp = chave.compareTo(x.chave);
    	
    	if(cmp < 0)
    		x.esq = delete(x.esq, chave);
    	else if(cmp > 0)
    		x.dir = delete(x.dir, chave);
    	else
    	{ 
    		if(x.dir == null)
    			return x.esq;
    		if(x.esq  == null)
    			return x.dir;
    		
    		No t = x;

    		/* Pega o menor da sub�rvore direita (mais � esquerda). */
    		x = min(t.dir);

    		/* Remove o menor. */
    		x.dir = deleteMin(t.dir);

    		/* A sub�rvore esquerda se mant�m a mesma. */
    		x.esq = t.esq;
    	}

    	return x;
    }
    
    
    /**
     * Retorna a maior chave na �rvore que � menor ou igual � {@code chave} fornecida.
     *
     * @param  chave a chave fornecida
     * @return a maior chave na �rvore menor ou igual � {@code chave}
     * @throws NoSuchElementException se a �rvore est� vazia
     * @throws IllegalArgumentException se a {@code chave} � {@code null}
     */
    public Chave piso(Chave chave)
    {
        if (chave == null)
        	throw new IllegalArgumentException("A chave fornecida � null!");
        
        if (vazia()) 
        	throw new NoSuchElementException("A �rvore est� vazia!");
        
        No x = piso(raiz, chave);
        
        if (x == null)
        	return null;
        else
        	return x.chave;
    } 

    private No piso(No x, Chave chave)
    {
        if (x == null)
        	return null;
        
        int cmp = chave.compareTo(x.chave);
        
        if (cmp == 0)
        	return x;
        
        if (cmp <  0)
        	return piso(x.esq, chave);
        
        No t = piso(x.dir, chave);

        if (t != null) 
        	return t;
        else
        	return x; 
    }

    
    /**
     * Retorna a menor chave na �rvore que � maior ou igual � {@code chave} fornecida.
     *
     * @param  chave a chave fornecida
     * @return a menor chave na �rvore maior ou igual � {@code chave}
     * @throws NoSuchElementException se a �rvore est� vazia
     * @throws IllegalArgumentException se a {@code chave} � {@code null}
     */
    public Chave topo(Chave chave)
    {
        if (chave == null) 
        	throw new IllegalArgumentException("A chave fornecida � null!");

        if (vazia())
        	throw new NoSuchElementException("A �rvore est� vazia!");
        
        No x = topo(raiz, chave);
        
        if (x == null)
        	return null;
        else 
        	return x.chave;
    }

    private No topo(No x, Chave chave)
    {
        if (x == null)
        	return null;
        
        int cmp = chave.compareTo(x.chave);
        
        if (cmp == 0)
        	return x;
        
        if (cmp < 0)
        { 
            No t = topo(x.esq, chave);
            
            if (t != null)
            	return t;
            else
            	return x; 
        } 
        
        return topo(x.dir, chave); 
    }


    //O m�todo cria internamente uma �rvore de busca bin�ria "ancestral", cuja raiz ser�
    // o menor ancestral comum dos dois n�s passados por par�metro. Ap�s isso as vari�veis Valor prim e seg
    // recebem o valor das chaves passadas como par�metro pelo m�todo j� existente na classe get().
    // Se um deles receber null, o m�todo obtemAncestralComum retornar� tamb�m null.
    public No obtemAncestralComum(No primeiroNo, No segundoNo){

        ArvBinBusca <Chave,Valor> ancestral = new ArvBinBusca<>();
        Valor prim, seg;
        ancestral.raiz = ancestralComum(raiz,primeiroNo.chave, segundoNo.chave);

        prim = get(ancestral.raiz,primeiroNo.chave);
        seg = get(ancestral.raiz,primeiroNo.chave);

        if(prim==null || seg == null){
            System.out.println("Um ou ambos os n�s n�o existem na �rvore");
            return null;
        }
        //A �rvore passa a ser formada por um �nico n�, a raiz, que � retornada pelo m�todo
        ancestral.raiz.dir=null;
        ancestral.raiz.esq=null;

        return ancestral.raiz;
    }

    //Retorna o primeiro n� que n�o tenha um n� que possua a chave prim e chave seg no mesmo lado de sua sub-�rvore,
    // ou seja, se o n� tiver uma chave maior ou menor tanto da chave prim quanto da chave seg, a busca continua
    // at� achar-se um n� cuja chave seja maior que prim e menor que seg ou maior que seg e menor que prim.
    private No ancestralComum (No x, Chave prim, Chave seg){

        if(x==null) return null;

        if(x.chave.compareTo(prim)<0 && x.chave.compareTo(seg)<0){
            return ancestralComum(x.esq,prim,seg);
        } else if(x.chave.compareTo(prim)>0 && x.chave.compareTo(seg)>0){
            return ancestralComum(x.dir,prim,seg);
        }
         return x;
    }

    //M�todo para testar os m�todos acima
    public Chave teste(){
        No teste = this.obtemAncestralComum(this.max(raiz), this.min(raiz));
        return teste.chave;
    }

}