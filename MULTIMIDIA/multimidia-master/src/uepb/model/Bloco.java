package uepb.model;

import org.opencv.core.CvType;
import org.opencv.core.Mat;

public class Bloco {
	
	private Mat imagem;
	
	private Mat imagemOriginal;
	private int tamanhoBloco;//se bloco=8, então imagem será do tamanho 8x8
	
	public Bloco(Mat imagemOriginal, int tamanhoBloco) {
		this.tamanhoBloco=tamanhoBloco;
		this.imagemOriginal=imagemOriginal;
	}
	
	
	public Mat getImagem(int x, int y) {
		imagem = new Mat(tamanhoBloco, tamanhoBloco, CvType.CV_8UC3);
		for(int i=x;i<x+tamanhoBloco;i++){
			for(int j=y; j<y+tamanhoBloco;j++){
				imagem.put(i-x, j-y, imagemOriginal.get(i, j));
			}
		}
		
		return imagem;
	}

	public void setImagem(Mat imagem) {
		this.imagem = imagem;
	}
	

}
