package uepb.model;

import org.opencv.core.CvType;
import org.opencv.core.Mat;
import org.opencv.highgui.Highgui;

public class DCT {

	double dct = 0.0;
	int x, y;
	final double PI = Math.PI;
	Mat imagem;
	
	
	public DCT(Mat img) {
		this.imagem = img;
	}
	
	// largura e altura vão variar de 0 a 7
	public void calcularDCT(int largura, int altura) {
		
		if(altura==4 || largura==4){
			redimensionaImagem();
			altura = 8;
			largura = 8;
		}
		
		int matriz[][] = new int [altura][largura];
		for (int u = 0; u < largura; u++) {
			for (int v = 0; v < altura; v++) {
				
				for (int x = 0; x < 7; x++) {
					for (int y = 0; y < 7; y++) {
						dct += imagem.get(x, y)[0]
								* Math.cos(((2 * x + 1) * u * PI) / 16)
								* Math.cos(((2 * y + 1) * v * PI) / 16);
					}
				}
				dct = 0.25 * verificar(u) * verificar(v) * dct;
				matriz[u][v]=(int) dct;
			}
			
		}
		
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[0].length; j++) {
				System.out.print(matriz[i][j]+"\t");
			}
			System.out.println();
		}
		quantizacao(matriz);
	}

	private void redimensionaImagem() {
		Mat imgRedimensionada = new Mat(imagem.height()*2, imagem.width()*2,
				CvType.CV_8UC3);
		int linha=0, coluna=0;
		for (int i = 0; i < imagem.height(); i++) {
			coluna=0;
			for (int j = 0; j < imagem.width(); j++) {
				imgRedimensionada.put(linha, coluna, imagem.get(i, j));
				imgRedimensionada.put(linha, coluna+1, imagem.get(i, j));
				imgRedimensionada.put(linha+1, coluna, imagem.get(i, j));
				imgRedimensionada.put(linha+1, coluna+1, imagem.get(i, j));
				
				coluna+=2;
			}
			linha+=2;
			
		}
		imagem = imgRedimensionada;
		
		Highgui.imwrite("src/uepb/icones/IM.jpg", imagem);
	}

	private double verificar(int x) {
		if (x == 0) {
			return Math.sqrt(2) / 2;
		}
		return 1;
	}
	
	public int[][] quantizacao(int[][] DCT){
		int[][] Q = getMatrizQ();
		int[][] DCTQuantizada = new int[8][8];
		
		for (int i = 0; i < DCTQuantizada.length; i++) {
			for (int j = 0; j < DCTQuantizada[0].length; j++) {
				
				DCTQuantizada[i][j] = Math.round(DCT[i][j]/Q[i][j]);
				
			}
		}
		System.out.println("\n\n");
		for (int i = 0; i < DCTQuantizada.length; i++) {
			for (int j = 0; j < DCTQuantizada[0].length; j++) {
				System.out.print(DCTQuantizada[i][j]+"\t");
			}
			System.out.println();
		}
		return DCTQuantizada;
	}
	
	int[][] getMatrizQ(){
		int [][] Q = {{16,11,10,16,24,40,51,61},
				{12,12,14,19,26,58,60,55},
				{14,13,16,24,40,57,69,56},
				{14,17,22,29,51,87,80,62},
				{18,22,37,56,68,109,103,77},
				{24,35,55,64,81,104,113,92},
				{49,64,71,87,103,121,120,101},
				{72,92,95,98,112,100,103,99}};
		
		return Q;
	}
}
