package utilidades;

public class Conversor {
	
	public static int convertaCharToInt (char arg) {
		char entrada = Character.toLowerCase(arg);
		
		switch (entrada) {
			case 'a':
				return (int) 0;
			case 'b':
				return (int) 1;
			case 'c':
				return (int) 2;
			default:
				System.err.println("Argumento \"" + arg + "\" inválido! Corrija isso aí...");
				System.exit(0);
		}
		
		return -1; //eu coloquei isso aqui pq o eclipse tava reclamando, tá ok????
	}
	
	public static char convertaIntToChar (int arg) {
		switch (arg) {
		case 0:
			return (char) 'a';
		case 1:
			return (char) 'b';
		case 2:
			return (char) 'c';
		default:
			System.err.println("Argumento \"" + arg + "\" inválido! Corrija isso aí...");
			System.exit(0);
		}
	
		return 'E'; //de Erro...
	}

}
