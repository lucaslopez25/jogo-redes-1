package motor;

import java.io.File;
import java.util.ArrayList;
import java.util.Random;

import utilidades.ImportadorDeJson;

public class Motor {
	private ArrayList<Pergunta> todasAsPerguntas = ImportadorDeJson.jsonParaArray(new File(".//src//files//dicionario.json"));
	private Random r = new Random();
	private final int limite = todasAsPerguntas.size();
	
	
	public Motor () {
		
	}
		
	public Partida criarPartida (int numeroDePerguntas) {
		Partida partida = new Partida();
		partida.setInicioPartida(System.currentTimeMillis()/1000);
		ArrayList<Pergunta> perguntasSelecionadas = new ArrayList<Pergunta>();
		for (int i = 0 ; i < numeroDePerguntas ; i++) {
			perguntasSelecionadas.add(todasAsPerguntas.get(r.nextInt(limite + 1)));
			if (i > 0) { //testa se houve pergunta repetida
				if (perguntasSelecionadas.get(i-1).equals(perguntasSelecionadas.get(i))) {
					perguntasSelecionadas.remove(i);
					perguntasSelecionadas.add(todasAsPerguntas.get(r.nextInt(limite + 1)));
				}
			}
		}
		partida.setPerguntas();
		return partida;
		
	}
		
	public void finalizarPartida (Partida p) {
		
			
	}
		
	public String quemGanhou () {
			
	}

}
