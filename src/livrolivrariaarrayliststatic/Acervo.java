package livrolivrariaarrayliststatic;

import java.util.ArrayList;

public class Acervo {
	//atributo
	private static ArrayList<LivroLivraria> listaLivros = new ArrayList<>();
	
	//método GET
	public static ArrayList<LivroLivraria> getListaLivros(){
		return listaLivros;
	}

	//adiciona um objeto na lista
	public static void adicionar(LivroLivraria l) {
		listaLivros.add(l);
	}
	
	//lista os dados de todos os objetos da lsita
	public static String listar() {
		String saida =  "";
		int i = 1;
		for (LivroLivraria l: listaLivros) {
			saida = saida + "\n========== LIVRO Nº " + (i++) + "========\n"; 
			saida = saida + l.imprirmir() + "\n";
		}
		
		return saida;
	}
	

	//quantos livros tem desse gênero no acervo
	public static int pesquisar(String genero) {
		int qtd = 0;
		
		for (LivroLivraria l: listaLivros) {
			//comparação de Strings usa-se o método equals. 
			//Mas pra não se importar com CAPS usa-se equalsIgnoreCase(genero)
			if (l.getGenero().equalsIgnoreCase(genero)) {
				qtd++;
			}
		}
		
		return qtd;
	}
	
	
	//Pesquisar por faixa de preço.  Sobrecarga de métodos, pq há 2 métodos pesquisar.
	
	public static int pesquisar(double faixaInicial, double faixaFinal) {
		int qtdeLivrosNaFaixaDePreco = 0;
		double precoDoLivro = 0;
		
		for (LivroLivraria l: listaLivros) {
			precoDoLivro = l.getPreco();
			if (precoDoLivro >= faixaInicial && precoDoLivro <= faixaFinal) {
				qtdeLivrosNaFaixaDePreco++;
			}
		}
		return qtdeLivrosNaFaixaDePreco;
	}
	
	//Remove um livro pelo título
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
