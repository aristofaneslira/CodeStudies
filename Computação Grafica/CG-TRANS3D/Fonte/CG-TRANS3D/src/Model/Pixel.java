package Model;

import java.awt.image.BufferedImage;

import View.PanelTela3D;

public class Pixel {
	
	/**
	 * Pinta o pixel representado pelas coordenadas (x,y) com a cor Preta
	 * @param x
	 * @param y
	 * @param bufferedImage
	 */
	public static void setPixel(int x, int y, BufferedImage bufferedImage) {
		
		try {
			bufferedImage.setRGB(PanelTela3D.xInit + x, PanelTela3D.yInit - y, PanelTela3D.corPixel);
			
		} catch (Exception e) {
			// TODO: handle exception
			
		}
		
	}
	
}
