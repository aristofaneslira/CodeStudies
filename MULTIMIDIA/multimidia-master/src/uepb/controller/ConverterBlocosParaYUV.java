package uepb.controller;

import org.opencv.core.CvType;
import org.opencv.core.Mat;

public class ConverterBlocosParaYUV {

	public Mat[] getImagem(Mat blocoOriginal) {

		Mat imagemY = new Mat(blocoOriginal.height(), blocoOriginal.width(),
				CvType.CV_8UC3);
		Mat imagemU = new Mat(blocoOriginal.height(), blocoOriginal.width(),
				CvType.CV_8UC3);
		Mat imagemV = new Mat(blocoOriginal.height(), blocoOriginal.width(),
				CvType.CV_8UC3);

		Mat imagemUReduzida = new Mat(blocoOriginal.height() / 2,
				blocoOriginal.width() / 2, CvType.CV_8UC3);
		Mat imagemVReduzida = new Mat(blocoOriginal.height() / 2,
				blocoOriginal.width() / 2, CvType.CV_8UC3);

		double rgb[] = new double[3];
		double y, u, v;

		for (int i = 0; i < blocoOriginal.height(); i++) {
			for (int j = 0; j < blocoOriginal.width(); j++) {
				rgb = blocoOriginal.get(i, j);
				
				// o método get(i,j) retorna um vetor com os valores de B, G e
				// R, respectivamente
				y = 0.299 * rgb[2] + 0.587 * rgb[1] + 0.114 * rgb[0];
				u = Math.abs(rgb[0] - y);
				v = Math.abs(rgb[2] - y);

				rgb[0] = y;
				rgb[1] = y;
				rgb[2] = y;
				imagemY.put(i, j, rgb);

				rgb[0] = u;
				rgb[1] = u;
				rgb[2] = u;
				imagemU.put(i, j, rgb);

				rgb[0] = v;
				rgb[1] = v;
				rgb[2] = v;
				imagemV.put(i, j, rgb);
			}
		}

		// Gerar as imagens de U e V reduzidas.
		int linha = 0, col = 0;
		for (int i = 0; i < blocoOriginal.height() - 1; i += 2) {
			col = 0;
			for (int j = 0; j < blocoOriginal.width() - 1; j += 2) {

				rgb = imagemU.get(i, j);
				rgb = soma(rgb, imagemU.get(i, j + 1));
				rgb = soma(rgb, imagemU.get(i + 1, j));
				rgb = soma(rgb, imagemU.get(i + 1, j + 1));
				
				rgb[0] = rgb[0] / 4;
				rgb[1] = rgb[1] / 4;
				rgb[2] = rgb[2] / 4;
				imagemUReduzida.put(linha, col, rgb);

				rgb = imagemV.get(i, j);
				rgb = soma(rgb, imagemV.get(i, j + 1));
				rgb = soma(rgb, imagemV.get(i + 1, j));
				rgb = soma(rgb, imagemV.get(i + 1, j + 1));
				
				rgb[0] = rgb[0] / 4;
				rgb[1] = rgb[1] / 4;
				rgb[2] = rgb[2] / 4;
				imagemVReduzida.put(linha, col, rgb);

				col++;
			}
			linha++;
		}

		Mat[] blocos = new Mat[3];

		blocos[0] = imagemY;
		blocos[1] = imagemUReduzida;
		blocos[2] = imagemVReduzida;

		return blocos;
	}

	private double[] soma(double[] v1, double[] v2) {

		double result[] = new double[v1.length];
		for (int i = 0; i < result.length; i++) {
			result[i] = v1[i] + v2[i];
		}

		return result;
	}

	/*
	 * public Mat getImagem(Mat blocoOriginal) { imagem = new
	 * Mat(blocoOriginal.height(), blocoOriginal.width(), CvType.CV_8UC3);
	 * double rgb[] = new double[3]; double y, Cr, Cb; for(int
	 * i=0;i<blocoOriginal.height();i++){ for(int j=0;
	 * j<blocoOriginal.width();j++){ rgb = blocoOriginal.get(i, j); y =
	 * 0.299*rgb[2] + 0.587*rgb[1] + 0.114*rgb[0]; //o método get(i,j) retorna
	 * um vetor com os valores de B, G e R, respectivamente Cr =
	 * ((rgb[2]-y)/1.6)+0.5; Cb = ((rgb[0]-y)/2)+0.5; rgb[2] = y; rgb[1] = Cr;
	 * rgb[0] = Cb; imagem.put(i, j, rgb); } }
	 * 
	 * return imagem; }
	 */
}
