package motor;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Partida {
	private long duracao;
	private String jogador;
	private int pontos;
	private ArrayList<Pergunta> perguntasDaPartida;
	private int contador = 0;
	private boolean partidaFinalizada = false;
	
	public Partida(long tempo, ArrayList<Pergunta> perguntas) {
		setInicioPartida(tempo);
		setPerguntas(perguntas);
	}
	
	public void setJogador (String s) {
		this.jogador = s;
	}
	
	public String getJogador () {
		return jogador;
	}
	
	private void setInicioPartida (long tempo) {
		this.duracao = tempo;
	}
	
	private void setPerguntas (ArrayList<Pergunta> ps) {
		perguntasDaPartida = ps;
	}
	
	private void getNext () {
		/**
		 * Retorna a pergunta como um System.out.println(); diretamente no console mais pr�ximo.
		 */
		Scanner scanner = new Scanner(System.in);
		System.out.println(perguntasDaPartida.get(contador).getPergunta());
		System.out.println(" ");
		System.out.println("A) " + perguntasDaPartida.get(contador).getRespostas().get(0));
		System.out.println("B) " + perguntasDaPartida.get(contador).getRespostas().get(1));
		System.out.println("C) " + perguntasDaPartida.get(contador).getRespostas().get(2));
		System.out.println("Digite sua resposta:");
		char respostaUsuario = Character.toLowerCase(scanner.next().charAt(0));
		if (perguntasDaPartida.get(contador).getCorreta() == respostaUsuario) pontos++;
		scanner.close();
		contador++;
	}
        
        public String getNextPergunta(){
            return perguntasDaPartida.get(contador).getPergunta();
        }
        
        public List<String> getRespostas(){
            List<String> respostas = perguntasDaPartida.get(contador).getRespostas();
            contador++;
            return respostas;
        }
	
	public boolean isLastPergunta() {
		/**
		 * Retorna se � a �ltima pergunta.
		 * Bom para usar como condicional de um loop para passar as perguntas.
		 */
		return (perguntasDaPartida.size() == contador);
	}
	
	public void setFimPartida (long tempoFinal) {
		duracao = tempoFinal - duracao;
		partidaFinalizada = true;
	}
	
	public int getPontos() {
		return pontos;
	}
	
	public long getTempo() {
		return duracao;
	}
	
	public boolean isPartidaFinalizada () {
		return partidaFinalizada;
	}
}
