import java.util.ArrayList;
import java.util.Collections;


public class Filtros {
	
	private String filtro;
	private double[][] operador = new double[3][3];
	private double fator;
	
	/**
	 * Método de execução do filtro determinado pelo usuario
	 * @param filtro 
	 */
	public void setFiltro(String filtro){
		this.filtro = filtro;
		this.fator = 0;
		processar();
		
	}
	/**
	 * Método de execução do filtro determinado pelo usuario
	 * @param filtro
	 * @param fator Fator A determinado pelo usuario para o filtro "Alto Reforço"
	 */
	public void setFiltro(String filtro, double fator){
		this.filtro = filtro;
		this.fator = (9*fator)-1;
		processar();
	
	}
	
	/**
	 * Muda o filtro de acordo com o nome passado pelo usuario ao método setFiltro() e executa a convolução
	 */
	public void processar(){
		switch (filtro) {
		
		case "media":
			double aux = 1.0/9.0;
			setOperador(aux, aux, aux, aux, aux, aux, aux, aux, aux);
			break;
			
		case "mediana":
			setOperador(1, 1, 1, 1, 1, 1, 1, 1, 1);
			break;
			
		case "passa alta basico":
			setOperador(-1.0, -1.0, -1.0, -1.0, 8.0, -1.0, -1.0, -1.0, -1.0);
			break;
			
		case "alto reforco":
			setOperador(-1.0, -1.0, -1.0, -1.0, fator, -1.0, -1.0, -1.0, -1.0);
			break;
			
		case "sobel x":
			setOperador(-1, -2, -1, 0, 0 , 0, 1, 2, 1);
			break;
			
		case "sobel y":
			setOperador(-1, 0, 1, -2, 0 , 2, -1, 0, 1);
			break;
			
		case "sobel magnitude":
			setOperador(-2, -2, 0, -2, 0, 2, 0, 2, 2);
			break;
			
		case "prewitt x":
			setOperador(-1, -1, -1, 0, 0 , 0, 1, 1, 1);
			break;
			
		case "prewitt y":
			setOperador(-1, 0, 1, -1, 0 , 1, -1, 0, 1);
			break;
			
		case "prewitt magnitude":
			setOperador(-2, -1, 0, -1, 0, 1, 0, 1, 2);
			break;
			
		case "roberts x":
			setOperador(0, 0, 0, 0, 1 , 0, 0, -1, 0);
			break;
			
		case "roberts y":
			setOperador(0, 0, 0, 0, 1 , -1, 0, 0, 0);
			break;
			
		case "roberts magnitude":
			setOperador(0, 0, 0, 0, 2 , -1, 0, -1, 0);
			break;
			
		case "roberts cruzado x":
			setOperador(0, 0, 0, 0, 1 , 0, 0, 0, -1);
			break;
			
		case "roberts cruzado y":
			setOperador(0, 0, 0, 0, 0 , 1, 0, -1, 0);
			break;
			
		case "roberts cruzado magnitude":
			setOperador(0, 0, 0, 0, 1 , 1, 0, -1, -1);
			break;
			
		default:
			break;
		}
		
		executaConvolucao();
		
	}
	
	/**
	 * Modifica o Operador do filtro de acordo com os parâmetros
	 * @param a11
	 * @param a12
	 * @param a13
	 * @param a21
	 * @param a22
	 * @param a23
	 * @param a31
	 * @param a32
	 * @param a33
	 */
	public void setOperador(double a11, double a12, double a13, double a21, double a22, double a23, double a31, double a32, double a33){
		operador[0][0] = a11;
		operador[0][1] = a12;
		operador[0][2] = a13;
		
		operador[1][0] = a21;
		operador[1][1] = a22;
		operador[1][2] = a23;
		
		operador[2][0] = a31;
		operador[2][1] = a32;
		operador[2][2] = a33;
		
	}
	
	/**
	 * Operação de convolução que utiliza o array de dados da imagem original e o operador do filtro para gerar os dados
	 * da imagem resultado.
	 */
	public void executaConvolucao() {
		
		int total = PanelFiltros.dadosImagemOriginal.size();
		
		//System.out.println("Total: "+ total);
		
		int[] vertice = new int[2];
		int min = 0;
		int max = 255;
		ArrayList<Integer> listaPixel = new ArrayList<>();
		
		for (int i = 0; i < total; i++) {
			listaPixel.clear();
			double pixelFinal = 0;
			
			//System.out.println((i % PanelFiltros.largura)+"");
			
			int x = (int) (i % PanelFiltros.largura);
			int y = (int) (i / PanelFiltros.largura);
			
			for (int j = 0; j < 3; j++) {
				
				vertice[0] = Math.min(Math.max(x+j, 0), PanelFiltros.largura-1);
	
				for (int k = 0; k < 3; k++) {
					vertice[1] = Math.min(Math.max(y+k, 0), PanelFiltros.altura-1);
					double pixelImage  = PanelFiltros.dadosImagemOriginal.get((vertice[1] * PanelFiltros.largura) + vertice[0]);
					double pixelFiltro = operador[j][k];
					
					pixelFinal += pixelImage * pixelFiltro;
					listaPixel.add((int) (pixelImage * pixelFiltro));
					
				}
			}
			
			//truncar
			pixelFinal = (pixelFinal > 255) ? 255 : ((pixelFinal < 0) ? 0 : pixelFinal); 
			
			//mediana
			if (filtro.equals("mediana")) {
				if((listaPixel.get(4) < (min + 8)) || (listaPixel.get(4) > (max - 8))){
					Collections.sort(listaPixel);
				}
				min = (int) ((pixelFinal < min)? pixelFinal : min);
				max = (int) ((pixelFinal > max)? pixelFinal : max);
				
				pixelFinal = listaPixel.get(4);
				
			}
			
			int valor = (int) pixelFinal;
			
			PanelFiltros.dadosImagemResultado.set(i, valor);
			
			
		}
		
	}
	
}
