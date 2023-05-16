/*
 * Sistemas Multimidia
 * 
 * Alunos: 
 * 			Aristofanes Lira
 * 			Diego Barbosa
 * 			Andre Luis
 */

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.stream.IntStream;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.awt.image.Raster;

public class Main {
	
	//inicializando as variaveis globais
	static BufferedImage imagem = null;
    static File arquivo = null;
    static int altura = 0;
	static int largura = 0;
	static int [] totalDeTonsDeCinza = null;
	static int[] tonsUnicos = null;
	static double[] probabilidadeTons = null;
	
	int x = 0; 
    int y = 0; 

	
	public static void LerImagem()
	{

	    //lendo a imagem
	    
	    try{
	      arquivo = new File("C:\\Users\\arist\\Documents\\UEPB 2018.1\\MULTIMIDIA\\img.jpg");
	      imagem = ImageIO.read(arquivo);
	    }catch(IOException e){
	      System.out.println(e);
	    }
	    
	    	    	    
	}

	//Lê os pixels, tira os RGBs e faz os calculos para greyscale
	public static void LerPixels() {
		int contadorElementos = 0;

	    //recolhendo as dimensões da imagem
	    
		largura = imagem.getWidth();
	    altura = imagem.getHeight();
	    	    
	    totalDeTonsDeCinza = new int[(largura*altura)];
	    
	    //System.out.println("largura , altura: " + largura + ", " + altura);
	    
	    
	    for (int i = 0; i < altura; i++) 
	    {
	      
	    	for (int j = 0; j < largura; j++)
	    		{       
	    			int pixel = imagem.getRGB(j, i);
	    			int vermelho = (pixel >> 16) & 0xFF;
	    			int verde = (pixel >> 8) & 0xFF;
	    			int azul = (pixel & 0xFF);
	    			int cinza = (vermelho + verde + azul)/3;
	    			totalDeTonsDeCinza[contadorElementos]= cinza;
	    			contadorElementos++;
	    			
	    		}
	    } 
	   //separar os elementos únicos 
	    tonsUnicos = IntStream.of(totalDeTonsDeCinza).distinct().toArray();
	  	    
	}
	
	public static void CalcularProbabilidade() {
		
		probabilidadeTons = new double[tonsUnicos.length];
		  double frequencia = 0;
		  double qtdPixels = altura*largura;
		  //primeiro calcular as probabilidades
		  //pra isso eu preciso saber a quantidade de vezes que cada tom aparece na imagem, e dividir os valores pelo total que é a quantidade de pixels (altura*largura)
	
		  //conta quantas vezes um elemento aparece, dividir pelo total e colocar a probabilidade em outro vetor	
	      for (int i = 0; i < tonsUnicos.length; i++) {
	    	  
	    	for(int k = 0; k < totalDeTonsDeCinza.length; k++) {
	    			
	    		if (tonsUnicos[i] == totalDeTonsDeCinza[k])
	    			{
			          frequencia++;
	    			}
	    		
	    		
	    	}
	    	probabilidadeTons[i] = (frequencia / qtdPixels) ;
  		//System.out.println("Ton["+tonsUnicos[i]+"]"+" frequencia["+frequencia+"]"+" probabilidade["+ probabilidadeTons[i]+"] Valor total["+ totalDeTonsDeCinza.length +"].");
	        frequencia = 0;
	      }
	}
	
	public static void CalcularEntropia() {
		
		//Calculamos a probabilidade de cada elemento unico
		CalcularProbabilidade();
		// a formula é o somatório de - Probabilidade[numa posição N] * log2 [probabilidade posição N]
	    //os resultados serão então calculados 1 a 1 dentro do for, e adicionados a uma variavel double (com a maior precisão) 
		double entropia = 0;
		for (int i = 0; i < probabilidadeTons.length ; i++) {
			
			entropia += (probabilidadeTons[i] * (Math.log(probabilidadeTons[i])/Math.log(2)))*(-1);
			
		}
		
		System.out.println("A entropia da imagem é de["+entropia+"].");

	}
	
	public static void CalcularRLE() {
		
		//RLE funciona contando quantos elementos consecutivos do mesmo termo por exemplo aaabbccc, vira a3,b2,c3
		//pra isso uso o vetor com todos os tons, pego o primeiro elemento e comparo com o proximo, se for igual, o contador sobe +1, caso contrario, ele escreve o 		
		// elemento que ele está testando, seguido da quantidade de elementos contados até ali
		
		int contadorElementosRLE = 0;
		int[] arrayRLE;
		int [] qtdRLE;
		
	    Map<Integer, Integer> RLE = new HashMap<>();
	    Map<Integer, Integer> contadorRLE = new HashMap<>();
	    int j = 0;
		for(int i = 0; i <totalDeTonsDeCinza.length; i++)
		{
			
			if (i < (totalDeTonsDeCinza.length - 1)) {
					if (totalDeTonsDeCinza[i] == totalDeTonsDeCinza[i+1]) 
						{
					
							contadorElementosRLE++;
					
				
						}else {
								if (contadorElementosRLE == 0)
								{
							    contadorElementosRLE= 1;

								}
								RLE.put(j,totalDeTonsDeCinza[i]);
								contadorRLE.put(j,contadorElementosRLE);
							    contadorElementosRLE = 0;
							    j++;
						}
			
				}
		}
		
	
		arrayRLE = new int[(RLE.entrySet().toArray()).length];
		qtdRLE = new int[(contadorRLE.entrySet().toArray()).length];
		int resultadoRLE[][] = new int[(arrayRLE.length+qtdRLE.length)][2];

				for (int i = 0; i < arrayRLE.length; i++) {
					resultadoRLE[i][0] = arrayRLE[i];
					resultadoRLE[i][1] = qtdRLE[i];
					}	
		
	;
	double percentagem = 0;
	double tamanhoRLE = resultadoRLE.length;
	double totalPixels = totalDeTonsDeCinza.length;
	percentagem  = ((tamanhoRLE * 100) / totalPixels);
	System.out.println("Após a RLE sem perdas a imgem é ["+ percentagem+"]% do valor original");
	

	}
	

	public static void main(String[] args) {
		 
		LerImagem();
		LerPixels();
		CalcularEntropia();
		CalcularRLE();

	}

}
