package motor;

import java.util.ArrayList;
import java.util.List;

import utilidades.Conversor;

public class Pergunta {
	private String pergunta = null;
	private List<String> respostas = new ArrayList<String>();
	private int correta = -1;
	
	public Pergunta (String pergunta) {
		setPergunta(pergunta);
	}
	
	public void setPergunta (String pergunta) {
		this.pergunta = pergunta;
	}
	
	public void setRespostas (String respostaA, String respostaB, String respostaC) {
		this.respostas.add(respostaA);
		this.respostas.add(respostaB);
		this.respostas.add(respostaC);
	}
	
	public void setCorreta (int valor) {
		if (valor == 0 || valor == 1 || valor == 2) this.correta = valor;
		else System.err.println("Argumento \"" + valor + "\" inválido! Corrija isso aí...");
	}
	
	public void setCorreta (char arg) {
		int valor = Conversor.convertaCharToInt(arg);
		if (valor == 0 || valor == 1 || valor == 2) this.correta = valor;
		else System.err.println("Argumento \"" + arg + "\" inválido! Corrija isso aí...");
	}

	public String getPergunta() {
		return pergunta;
	}

	public List<String> getRespostas() {
		return respostas;
	}

	public char getCorreta() {
		return Conversor.convertaIntToChar(correta);
	}
}
