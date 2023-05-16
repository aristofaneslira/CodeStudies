package projeto;

import java.awt.BorderLayout;  
import java.awt.Color;  
import java.awt.Component;  
import java.awt.Container;  
import java.awt.event.ActionEvent;  
import java.awt.event.ActionListener;  
import java.io.IOException;  
import java.net.MalformedURLException;  
  
import javax.media.CannotRealizeException;  
import javax.media.Manager;  
import javax.media.NoPlayerException;  
import javax.media.Player;  
import javax.swing.BorderFactory;  
import javax.swing.JButton;  
import javax.swing.JFileChooser;  
import javax.swing.JFrame;  
import javax.swing.JOptionPane;  
import javax.swing.JPanel;  
  
  
public class TocarAudio extends JFrame {  
  
   private JButton tocar , parar , selecionar;  
    private Container c = getContentPane();  
    private JPanel painel ;  
    private Audio audio = new Audio();  
   Player player = null;  
      
    public TocarAudio() {  
            
      this.setTitle("Midia MP3");  
      this.setLocation(260,100);  
      this.setSize(300,320);  
      c.setLayout(null);  
      c.setBackground(Color.black);  
       
              
      tocar = new JButton("play");  
      tocar.addActionListener(new AcaoBotao());  
      tocar.setBounds(163,170,100,25);  
        
      parar = new JButton("stop");  
      parar.addActionListener(new AcaoBotao());  
      parar.setBounds(100,210,85,25);  
        
      selecionar = new JButton("localizar");  
      selecionar.setBounds(19,170,100,25);  
      selecionar.addActionListener(new AcaoBotao());  
     
      painel = new JPanel();  
      painel.setBorder(BorderFactory.createLineBorder(Color.blue,5));  
      painel.setBounds(16,20,250,245);  
             
      c.add(tocar);  
      c.add(parar);  
      c.add(selecionar);  
         
      this.setVisible(true);          
        
   }  
     
   public void adicionarComponente(JPanel p){  
        
      c.add(p);  
        
   }  
     
  
private class AcaoBotao implements ActionListener  {  
     
      JFileChooser arqMusica = null ;  
      
             
      public void actionPerformed(ActionEvent e)  {   
           
         if(e.getSource() == tocar){  
              
                try {  
                      
                   if(audio.getAudioMP3() != null ){  
                      player = Manager.createRealizedPlayer(audio.getAudioMP3());  
                      Component controle = player.getControlPanelComponent() ;  
                      painel.add(controle,BorderLayout.SOUTH);  
                      adicionarComponente(painel);  
                      repaint();  
                      player.start();  
                   }  
                     
                     
                     
               } catch (NoPlayerException e1) {  
                  e1.printStackTrace();  
               } catch (IOException e2) {  
                  e2.printStackTrace();  
               } catch (CannotRealizeException e3) {  
                  e3.printStackTrace();  
                 
               }  
                  
                       
         }  
           
         if(e.getSource() == parar){  
              
            //JOptionPane.showMessageDialog(null," Você clicou no botao " + ((JButton) e.getSource()).getActionCommand(),"Janela de Botao",JOptionPane.INFORMATION_MESSAGE);  
            player.stop();
         }  
           
         if(e.getSource() == selecionar){  
              
                    arqMusica = new JFileChooser();  
                      
                    int resultado = arqMusica.showOpenDialog(null);  
                      
                    if(resultado == JFileChooser.APPROVE_OPTION){  
                     
                       try {  
                                       
                          audio.setAudioMP3(arqMusica.getSelectedFile().toURL());  
       
                                                  
                       } catch (MalformedURLException e1) {  
              
                          JOptionPane.showMessageDialog( null , " Erro ao criar URL " , " Erro " , JOptionPane.ERROR_MESSAGE );  
                       }  
                      
                    }  
               }  
           
        
      }     
     
}
     
     
   public static void main(String arg[]){  
     
      TocarAudio t = new TocarAudio();  
      t.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
        
   }  
     
}  
