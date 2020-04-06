package test.main;

import java.io.File;
import java.util.ArrayList;
import java.util.Random;

import motor.Pergunta;
import utilidades.ImportadorDeJson;

public class Main {
	public static void main(String[] args) {
		ArrayList<Pergunta> todasAsPerguntas = ImportadorDeJson.jsonParaArray(
				new File(".//src//files//dicionario.json"));
		Random r = new Random();
		int limite = todasAsPerguntas.size();
		
		Pergunta p = todasAsPerguntas.get(r.nextInt(limite++));
		System.out.println(p.getPergunta());
		System.out.println(p.getCorreta());
	}
}
