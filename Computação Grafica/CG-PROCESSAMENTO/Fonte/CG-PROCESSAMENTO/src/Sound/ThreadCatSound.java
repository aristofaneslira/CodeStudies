package Sound;

public class ThreadCatSound implements Runnable	{
	Thread iteracoes;
	TocarSom sound = new TocarSom();
	public ThreadCatSound(Thread iteracoes){
		this.iteracoes = iteracoes;
	}
	/**
	 * Inicia o som ao término da Thread de Iterações (loops do gato de arnold)
	 */
	@Override
	public void run() {
		while (true){
			if (!iteracoes.isAlive()){
				sound.TocaAudioGato();
				sound.done();
				break;
				
			}
		}
		
	}

	
}
