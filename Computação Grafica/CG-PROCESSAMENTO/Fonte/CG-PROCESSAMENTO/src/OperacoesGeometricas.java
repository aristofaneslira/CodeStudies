import java.util.ArrayList;


public class OperacoesGeometricas {
	
	public static int novaAltura;
	public static int novaLargura;

	/**
	 * Realiza a operação de Rotação com imagem
	 * @param dadosImagem
	 * @param angulo
	 * @param largura
	 * @param altura
	 * @return
	 */
	public ArrayList<Integer> opRotacao(ArrayList<Integer> dadosImagem, int angulo, int largura, int altura){
		ArrayList<Integer> dadosImagemResultado = new ArrayList<>();
			
		//converte para radiano
		double radA = (Math.toRadians(angulo));
		double cosA = Math.cos(radA);
		double senoA = -Math.sin(radA);
		
		//calcular os pontos extremos da nova imagem
		double pontoX1 = (-altura * senoA);
		double pontoY1 = (altura * cosA);
		double pontoX2 = (largura * cosA - altura * senoA);
		double pontoY2 = (altura * cosA + largura * senoA);
		double pontoX3 = (largura * cosA);
		double pontoY3 = (largura * senoA);
		
		//Definir x e y maximos e minimos
		double minx = Math.round(Math.min(0, Math.min(pontoX1, Math.min(pontoX2, pontoX3))));
		double miny = Math.round(Math.min(0, Math.min(pontoY1, Math.min(pontoY2, pontoY3))));
		double maxx = Math.round(Math.max(pontoX1, Math.max(pontoX2, pontoX3)));
		double maxy = Math.round(Math.max(pontoY1, Math.max(pontoY2, pontoY3)));
	
		
		//Definir as Dimensões Finais
		novaLargura = (int)(Math.ceil(Math.abs(maxx) - minx));
		novaAltura = (int)(Math.ceil(Math.abs(maxy) - miny));
		
		//Tamanho do Array inicial
		int tamanho = largura*altura;
		//Tamanho do novo Array da imagem
		int novoTamanho = novaLargura*novaAltura;
		fillArrayList(dadosImagemResultado, novoTamanho);
		
		 // processa rotacao
        for (int x = 0; x < novaLargura; x++){
             for (int y = 0; y < novaAltura; y++){
                
                  // Linhas e Colunas da Imagem Original
                 int pre_x = (int)((x + minx) * cosA + (y + miny) * senoA);
                 int pre_y = (int)((y + miny) * cosA - (x + minx) * senoA);
                
                  // indice do pixel original
                int pre_i = (pre_x >= 0 && pre_x < largura && pre_y >= 0 && pre_y < altura) ? (pre_y * largura) + pre_x : -1;
                  
                  // indice do pixel resultante
                int pos_i = (y * novaLargura) + x;
     
                  // atualiza a matriz resultante     
                 if (pre_i >= 0 && pre_i < tamanho) {
                      dadosImagemResultado.set(pos_i, dadosImagem.get(pre_i));
                    
                 }
             
            }
   
        }
		 
        //System.out.println(dadosImagemResultado);
		return dadosImagemResultado;
		
	}
	
	/**
	 * Realiza a operação de Escala positiva e negativa com imagem
	 * @param dadosImagem
	 * @param fator
	 * @param largura
	 * @param altura
	 * @return
	 */
	public ArrayList<Integer> opEscala(ArrayList<Integer> dadosImagem, double fator, int largura, int altura) {
		
		 //Definir as dimensões finais
		 
		 novaLargura = (int)(largura*fator);
		 novaAltura = (int)(altura*fator);
		 ArrayList<Integer> dadosImagemResultado = new ArrayList<>();
		 
		//Tamanho do Array inicial
		 int tamanho = largura*altura;
		 
		 //Tamanho do novo Array da imagem
		 int novoTamanho = novaLargura*novaAltura;
		 fillArrayList(dadosImagemResultado, novoTamanho);       
		 
		 for (int x = 0; x < novaLargura; x++){
	            for (int y = 0; y < novaAltura; y++){
	                
	                 // Linhas e Colunas da Imagem Original
	                 int pre_x = (int)(x / fator);
	                 int pre_y = (int)(y / fator);
	                
	                 // indice do pixel original
	                 int pre_i = (pre_y * largura) + pre_x;
	                
	                 // indice do pixel resultante
	                 int pos_i = (y * novaLargura) + x;
	                
	                 // atualiza a matriz resultante     
	                 if (pre_i >= 0 && pre_i < tamanho) {
	                      dadosImagemResultado.set(pos_i, dadosImagem.get(pre_i));
	                    
	                 }          
	            }
	        }
		
		return dadosImagemResultado;
		
	}
	
	/**
	 * Realiza operação de Cisalhamento com a imagem
	 * @param dadosImagem
	 * @param cisX
	 * @param cisY
	 * @param largura
	 * @param altura
	 * @return
	 */
	public ArrayList<Integer> opCisalhamento(ArrayList<Integer> dadosImagem, double cisX, double cisY, int largura, int altura){
        
        // Definir as Dimensoes Finais
        novaLargura  = (int)(largura + (Math.abs(cisX) * altura));
        novaAltura   = (int)(altura + (Math.abs(cisY) * largura));
        
        //tamanho do novo array
        int novoTamanho   = novaLargura*novaAltura;
        
        //Definindo o array da nova imagem
        ArrayList<Integer> dadosImagemResultado = new ArrayList<>();
        fillArrayList(dadosImagemResultado, novoTamanho);
        
        // Definir os pixels cisalhados em dadosImagemResultado
        for (int x = 0; x < largura; x++){
             for (int y = 0; y < altura; y++){
                
                // Linhas e Colunas da Imagem Resultante                
                int pos_x = (int)(x + (cisX * y) + (cisX < 0 ? novaLargura-largura : 0));
                int pos_y = (int)(y + (cisY * x) + (cisY < 0 ? novaAltura-altura : 0));            
                
                // indice do pixel original
                int pre_i = (y * largura) + x;  
                    
                // indice do pixel resultante
                int pos_i = (pos_y * novaLargura) + pos_x;
                
                // atualiza a matriz resultante
                dadosImagemResultado.set(pos_i, dadosImagem.get(pre_i));
            }
        }
       
		
		return dadosImagemResultado;
		
	}
	
	/**
	 * Operação de Reflexão em X, Y e XY com a imagem
	 * @param dadosImagem
	 * @param tipo
	 * @param largura
	 * @param altura
	 * @return
	 */
	public ArrayList<Integer> opReflexao(ArrayList<Integer> dadosImagem, String tipo, int largura, int altura){
		int pos_x = 0;
		int pos_y = 0;
		int pre_i;
		int pos_i;
		
		//criando array de pixels resultado
		ArrayList<Integer> dadosImagemResultado = new ArrayList<>();
		int tamanho = largura*altura;
		fillArrayList(dadosImagemResultado, tamanho);
		  
		for (int x = 0; x < largura; x++){
	          for (int y = 0; y < altura; y++){
	              switch (tipo){
	                  case "x": {
	                	  pos_x = x;
                          pos_y = -y + altura;
                          break;
	                  }
	                  case "y": {
	                      pos_x = -x + largura;
	                      pos_y = y;
	                      break;
	                  }
	                  case "xy": {
	                      pos_x = -x + largura;
	                      pos_y = -y + altura;
	                      break;
	                  }
	              }
	                
			       // indice do pixel original
			      pre_i = (y * largura) + x;
			                
			       // indice do pixel resultante
			      pos_i = (pos_y * largura) + pos_x;
			      
			      	//normalizando
			      if(pos_i > tamanho-1) {
					pos_i = tamanho-1;
			      }
			                
			       // atualiza a matriz resultante
			      dadosImagemResultado.set(pos_i, dadosImagem.get(pre_i));
			      
			      
	          }
		}
		return dadosImagemResultado;
		
		
	}
	
	/**
	 * Preenche e Itera ArrayList para o tamanho recebido
	 * @param array
	 * @param tamanho
	 */
	public void fillArrayList(ArrayList<Integer> array, int tamanho){
		for (int x = 0; x < tamanho; x++) {
			array.add(255);
		}
	}
	
}
