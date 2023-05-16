package projeto;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import javax.media.CannotRealizeException;
import javax.media.Manager;
import javax.media.NoPlayerException;
import javax.media.Player;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
 
public class AbrindoMidia extends JPanel{
	private Container container;
	private  JFileChooser fileChooser;
	private URL mediaURL;
	
    
	public AbrindoMidia(URL mediaURL){
		
	}
 	   
		public void abrindo(){
			
		   	  
          fileChooser = new JFileChooser();
   
          // mostram diálogo abrir arquivo
          int result = fileChooser.showOpenDialog( null );
          
          // usa pra escolher a midia como url
         if ( result == JFileChooser.APPROVE_OPTION ){
             URL mediaURL = null;
   
             try{
                //obtem o arquivo como URL
                mediaURL = fileChooser.getSelectedFile().toURL();
             } 
             catch ( MalformedURLException malformedURLException ){
                System.err.println( "Não foi possível criar URL para o arquivo" );
             } 
             
         	setLayout( new BorderLayout() );
		 	  
		 	   // melhora e balanceia os componentes de compatibilidade
		 	   Manager.setHint( Manager.LIGHTWEIGHT_RENDERER, true );
		      
		       try{
		          // cria um player para reproduzir a mídia especificada na URL
		          Player mediaPlayer = Manager.createRealizedPlayer( mediaURL );

		          // Obtém os componentes para o vídeo e os controles de reprodução
		          Component video = mediaPlayer.getVisualComponent();
		          Component controls = mediaPlayer.getControlPanelComponent();
		         
		          if ( video != null )
		             add( video, BorderLayout.CENTER );
		          // foi adicionado a midia 

		          if ( controls != null )
		             add( controls, BorderLayout.SOUTH ); 
		          // adicionado os controles
		          
		          // inicia a execucao da midia
		          mediaPlayer.start(); 
		       } 
		       catch ( NoPlayerException noPlayerException ){
		          System.err.println( "Nenhuma midia foi executada" );
		          }
		       catch ( CannotRealizeException cannotRealizeException ){
		          System.err.println( "Não foi possível iniciar media player" );
		       } 
		       catch ( IOException iOException ){
		          System.err.println( "Erro ao ler a partir da fonte" );
		       } 
 	   
   
             if ( mediaURL != null ) {
            	 
                JFrame midiaTest = new JFrame( "Midia" );
                midiaTest.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
   
                AbrindoMidia midia = new AbrindoMidia( mediaURL);
                midiaTest.add( midia );
   
                midiaTest.setSize( 300, 300 );
                midiaTest.setVisible( true );
             } 
         } 
       } 
    } 
 
 
