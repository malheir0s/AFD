import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

class Main {

	public static void main(String[] args) {
		String estados, simbolos, triplas[], estadoInicial, estadosFinais, palavrasTeste;
		int numTransicoes;
		Scanner scan = new Scanner(System.in);
	
		HashMap <String,String> dicionario = new HashMap <String,String>();
	
		
		estados = scan.nextLine();
		simbolos = scan.nextLine();
		numTransicoes = scan.nextInt(); scan.nextLine();
		triplas = new String[numTransicoes];

		for (int i = 0; i < numTransicoes; i++) {
			triplas[i] = scan.nextLine();
		}
		
		estadoInicial = scan.nextLine();
		estadosFinais = scan.nextLine();
		
		HashSet <String> estadoF = new HashSet<String>();
		for(String ef:estadosFinais.split(" ")) {
			estadoF.add(ef);
		}
		
		palavrasTeste = scan.nextLine();
		String[] palavras = palavrasTeste.split(" ");
		criarDicionario (triplas, dicionario);
		
		for(String percorrer: palavras ) {
			String estadoAtual = new String (estadoInicial);
			for(String caracteres:percorrer.split("")) {

				if(dicionario.containsKey(estadoAtual.concat(caracteres))){
					estadoAtual = new String(dicionario.get(estadoAtual.concat(caracteres)));
				}
				else {
					estadoAtual = new String("#erro##!!");
					break;
				}
			}
			if(estadoF.contains(estadoAtual))
				System.out.println("S");
			else
				System.out.println("N");
		}
		
	}

	public static void criarDicionario(String triple[], HashMap <String,String> dictionary) {
		for(String a:triple) {
			String separar[] = a.split(" ");
			dictionary.put(separar[0].concat(separar[1]), separar[2]);
		}
	}
}
