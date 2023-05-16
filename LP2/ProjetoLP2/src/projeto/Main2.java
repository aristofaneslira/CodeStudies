package projeto;

import java.io.File;
import java.io.IOException;

public class Main2 {
    final static String ARQUIVO_PERFIL = "src/ArquivoPerfil.dat", ARQUIVO_AGENDA = "src/ArquivoAgenda.dat";
    
    public static boolean isArquivoExistente(String nomeDoArquivo) {
		File arq = new File(nomeDoArquivo);
		if (arq.exists())
			return true;
		return false;
	}
    
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                try {
					new AgendaMultitudoUI().setVisible(true);
				} catch (IOException e) {
					e.printStackTrace();
				}
            }
        });
    
        if (!(isArquivoExistente(ARQUIVO_PERFIL))) {
            java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new DesejaAtualizarPerfilUI().setVisible(true);
            }
        });
        }
    }
}
