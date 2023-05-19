import javax.swing.JLabel;

public class CountThread implements Runnable{
	int segundos = 0;
	int minutos = 0;
	JLabel label;
	Thread processo;
	
	/**
	 * Construtor
	 * @param processo
	 * @param label
	 */
	public CountThread(Thread processo, JLabel label){
		this.label = label;
		this.processo = processo;
	}
	/**
	 * Executa o timer ao iniciar a Thread
	 */
	@Override
	public void run() {
		while (true) {
			try {
				if (processo.isAlive()){
					Thread.sleep(1000);
					segundos++;
					if (segundos > 59){
						segundos -= 60;
						minutos++;
					}
					
					label.setText("Tempo Decorrido: " + minutos + " min e "+ segundos +" s");
					
					
				}
				
			} catch (InterruptedException e) {
				
			}
			
			
		}
		
	}
}
