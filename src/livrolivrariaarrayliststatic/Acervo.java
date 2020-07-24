package livrolivrariaarrayliststatic;

import java.util.ArrayList;

public class Acervo {
	//atributo
	private static ArrayList<LivroLivraria> listaLivros = new ArrayList<>();
	
	//m�todo GET
	public static ArrayList<LivroLivraria> getListaLivros(){
		return listaLivros;
	}

	//adiciona um objeto na lista
	public static void adicionar(LivroLivraria l) {
		listaLivros.add(l);
	}
	
	//lista os dados de todos os objetos da lista
	public static String listar() {
		String saida =  "";
		int i = 1;
		for (LivroLivraria l: listaLivros) {
			saida = saida + "\n========== LIVRO N� " + (i++) + "========\n"; 
			saida = saida + l.imprirmir() + "\n";
		}
		
		return saida;
	}
	

	//quantos livros tem desse g�nero no acervo
	public static int pesquisar(String genero) {
		int qtd = 0;
		
		for (LivroLivraria l: listaLivros) {
			//compara��o de Strings usa-se o m�todo equals. 
			//Mas pra n�o se importar com CAPS usa-se equalsIgnoreCase(genero)
			if (l.getGenero().equalsIgnoreCase(genero)) {
				qtd++;
			}
		}
		
		return qtd;
	}
	
	//Sobrecarga de m�todos, pq h� 2 m�todos pesquisar.
	//Pesquisar por faixa de pre�o.  
	public static int pesquisar(double faixaInicial, double faixaFinal) {
		int qtdeLivrosNaFaixaDePreco = 0;
		
		for (LivroLivraria l: listaLivros) {			
			if (l.getPreco() >= faixaInicial && l.getPreco() <= faixaFinal) {
				qtdeLivrosNaFaixaDePreco++;
			}
		}
		return qtdeLivrosNaFaixaDePreco;
	}
	
	//Remove um objeto livro pelo t�tulo
	public static boolean remover(String titulo) {		
		for (LivroLivraria l: listaLivros) {
			if (l.getTitulo().equalsIgnoreCase(titulo)) {
				listaLivros.remove(l);
				return true;
			}
		}
		return false;
	}
	
	//total do acervo
	public static double calcularTotalAcervo() {
		double valorTotalAcervo = 0;
		for (LivroLivraria l: listaLivros) {
			valorTotalAcervo += l.getPreco();
		}
		return valorTotalAcervo;
	}
	
}
