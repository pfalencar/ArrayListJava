package livrolivrariaarrayliststatic;

import java.util.Scanner;

public class AppLivroLivraria {

	public static void main(String[] args) {

		Scanner entrada = new Scanner(System.in);
		Scanner entradaString = new Scanner(System.in);
		
		int menu = 0;
		double vInicial, vFinal;
		//refer�ncia para a classe LivroLivraria
		LivroLivraria objetoLivro = null;
		String titulo, autor, genero; 
		float preco;
		int isbn;
		
		do {
			exibirMenu();
			menu = entrada.nextInt();
			
			
			switch(menu) {
				case 1:
					System.out.println("============== ADICIONANDO LIVRO ==============");
					
					System.out.println("Digite o t�tulo do livro: ");
					titulo = entradaString.nextLine();
					System.out.println("Digite o autor do livro: ");
					autor = entradaString.nextLine();
					System.out.println("Digite o g�nero do livro: ");
					genero = entradaString.nextLine();
					System.out.println("Digite o n�mero ISBN do livro: ");
					isbn = entrada.nextInt();
					System.out.println("Digite o pre�o do livro: ");
					preco = entrada.nextFloat();
					
					//criar objeto da classe LivroLivraria
					objetoLivro = new LivroLivraria(titulo, autor, isbn, genero, preco);
					
					//guardar no ArrayList
					Acervo.adicionar(objetoLivro);
					
					break;
					
					
				case 2:
					System.out.println("============== LISTANDO LIVROS ================");				
					System.out.println( Acervo.listar() );				
					break;
					
					
				case 3:
					
					System.out.println("================= REMOVENDO LIVRO ===================");
					System.out.println("Digite o t�tulo do livro a ser removido: ");
					titulo = entradaString.nextLine();
					
					if ( !(Acervo.getListaLivros().isEmpty()) ) { //acervo n�o vazio
						if ( Acervo.remover(titulo) ) {
							System.out.println("Livro removido com sucesso!!!");
						} else {
							System.out.println("T�tulo n�o foi encontrado. ");
						}
					} else {
						System.out.println("N�o existem livros no acervo.");
					}
					
					break;
					
					
				case 4:
					
					System.out.println("=========== PESQUISANDO POR G�NERO ============");
					
					System.out.println("Digite o g�nero do livro a ser pesquisado: ");
					genero = entradaString.nextLine();
					System.out.println("Existem " + Acervo.pesquisar(genero) + " livro(s) do g�nero " + genero );
					
					break;
					
					
				case 5:
					System.out.println("======== PESQUISANDO POR FAIXA DE PRE�O ==========");
					
					System.out.println("Digite a faixa inicial e a final do livro a ser pesquisado: ");
					vInicial = entrada.nextDouble();
					vFinal = entrada.nextDouble();
					
					System.out.println("Existem " + Acervo.pesquisar(vInicial, vFinal) + " livro(s) com pre�o entre " 
							+ String.format("R$ %.2f e R$ %.2f \n", vInicial,  vFinal) );
					break;
					
					
				case 6: 
					System.out.println("========== CALCULANDO TOTAL ACERVO ============");
					System.out.println( "O total � " + 
							String.format("R$ %.2f \n", Acervo.calcularTotalAcervo()) );
					break;
					
					
				case 7:
					System.out.println("================== SAIR ====================");
					System.out.println("Saindo...");
					entrada.close();
					entradaString.close();
					break;
					
					
				default:
					System.out.println("========= OP��O DE MENU INV�LIDA ===========");
					break;
			}//fim switch
			
		} while (menu != 7);		
		
		
		
		
	}//fim main
	
	public static void exibirMenu() {		
			System.out.println("================== MENU ====================");
			System.out.println("1-Cadastrar Livro");
			System.out.println("2-Listar Livro");
			System.out.println("3-Remover");
			System.out.println("4-Pesquisar por g�nero");
			System.out.println("5-Pesquisar por pre�o");
			System.out.println("6-Calcular Total Acervo");
			System.out.println("7-Sair");	
			System.out.println("====> Escolha uma op��o: ");
	}

}
