package motor;

public class Partida {
	private long duracao;
	private String jogador;
	private int pontos;
	
	public Partida() {
		
	}
	
	public void setInicioPartida (long tempo) {
		this.duracao = tempo;
	}
}
