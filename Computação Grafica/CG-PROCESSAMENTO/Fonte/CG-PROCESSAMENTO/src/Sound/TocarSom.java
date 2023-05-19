package Sound;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;

import javax.sound.sampled.*;

public class TocarSom {
	  private  Clip clip;
	  AudioInputStream stream;
	  public void TocaAudioGato(){ 
		
	            try {  
	            //audio do gato 
	            stream = AudioSystem.getAudioInputStream(new File("sound/soundcat.wav")); 
	            // definicao  
	            AudioFormat format = stream.getFormat();  
	              
	        if (format.getEncoding() != AudioFormat.Encoding.PCM_SIGNED) {  
	            format = new AudioFormat(  
	                    AudioFormat.Encoding.PCM_SIGNED,  
	                    format.getSampleRate(),  
	                    format.getSampleSizeInBits()*2,  
	                    format.getChannels(),  
	                    format.getFrameSize()*2,  
	                    format.getFrameRate(),  
	                    true);        // big endian  
	            stream = AudioSystem.getAudioInputStream(format, stream);  
	          
	        }  
	            // Create the clip  
	        DataLine.Info info = new DataLine.Info(  
	            Clip.class, stream.getFormat(), ((int)stream.getFrameLength()*format.getFrameSize()));  
	        clip = (Clip) AudioSystem.getLine(info);  
	      
	        // This method does not return until the audio file is completely loaded  
	         
	            clip.open(stream); 
	      
	        // Start playing  
	        clip.start();  
	        
	     
	  
	      } catch (MalformedURLException e) {  
	    } catch (IOException e) {  
	    } catch (LineUnavailableException e) {  
	    } catch (UnsupportedAudioFileException e) {  
	    
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
	    }  
	  
	  /**
	   * Método de fechamento do canal de comunicação 
	   */
	  public void done(){
		  try {
			stream.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	  }

}
