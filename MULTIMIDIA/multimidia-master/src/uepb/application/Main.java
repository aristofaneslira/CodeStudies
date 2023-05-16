package uepb.application;

import org.opencv.core.Mat;
import org.opencv.highgui.Highgui;

import uepb.controller.ConverterBlocosParaYUV;
import uepb.model.Bloco;
import uepb.model.DCT;

public class Main {

	public static void main(String[] args) {

		System.loadLibrary("opencv_java2410");

		Mat imagemOriginal = new Mat();
			imagemOriginal = Highgui.imread("imagem/field.bmp");
		
		Bloco bloco = new Bloco(imagemOriginal, 8);
		
		//Cria as 3 imagens de 8x8. (Ceu, grama e horizonte)
		Mat ceu = bloco.getImagem(107,557);
		Mat grama = bloco.getImagem(339,215);
		Mat ceu_grama = bloco.getImagem(316,83);
		
		// Salva as imagens na pasta.
		Highgui.imwrite("src/uepb/icones/ceu.png", ceu);
		Highgui.imwrite("src/uepb/icones/grama.png", grama);
		Highgui.imwrite("src/uepb/icones/ceuGrama.png", ceu_grama);
		
		// Conversão para o YUV.
		ConverterBlocosParaYUV converterBlocosParaYUV = new ConverterBlocosParaYUV();
			
		Mat[] ceuYUV = converterBlocosParaYUV.getImagem(ceu);
		Mat[] gramaYUV = converterBlocosParaYUV.getImagem(grama);
		Mat[] ceuGramaYUV = converterBlocosParaYUV.getImagem(ceu_grama);
		
		Highgui.imwrite("src/uepb/icones/ceuY.jpg", ceuYUV[0]);
		Highgui.imwrite("src/uepb/icones/ceuU.jpg", ceuYUV[1]);
		Highgui.imwrite("src/uepb/icones/ceuV.jpg", ceuYUV[2]);
		
		Highgui.imwrite("src/uepb/icones/gramaY.jpg", gramaYUV[0]);
		Highgui.imwrite("src/uepb/icones/gramaU.jpg", gramaYUV[1]);
		Highgui.imwrite("src/uepb/icones/gramaV.jpg", gramaYUV[2]);
		
		Highgui.imwrite("src/uepb/icones/ceuGramaY.jpg", ceuGramaYUV[0]);
		Highgui.imwrite("src/uepb/icones/ceuGramaU.jpg", ceuGramaYUV[1]);
		Highgui.imwrite("src/uepb/icones/ceuGramaV.jpg", ceuGramaYUV[2]);
		
		DCT dct = new DCT(ceuYUV[0]);
		dct.calcularDCT(8, 8);

		DCT dctGrama = new DCT(gramaYUV[0]);
		dctGrama.calcularDCT(8, 8);
	
		DCT dctHorizonte = new DCT(ceuGramaYUV[0]);
		dctHorizonte.calcularDCT(8, 8);
		
		DCT dctU = new DCT(ceuYUV[1]);
		dctU.calcularDCT(4, 4);
	}
}
