package DCT;

import ij.process.*;	// Pour classe Float Processor
import java.awt.Rectangle;

abstract public class DCT2D {
	
	// ---------------------------------------------------------------------------------
	/**
	 * Transformation DCT 2D directe (m�thode de classe) utilisant la s�parabilit�
	 * @param fp Signal 2D d'entr�e et de sortie (MxN) (FloatProcessor)
	 */ 
	public static void forwardDCT(FloatProcessor fp) {
		
		int width = fp.getWidth();
		int height = fp.getHeight();
		
		// Traiter les lignes
		for(int y = 0; y < height; y++) {
			double[] lineY = DCT1D.forwardDCT(fp.getLine(0,y,width,y));
			for(int x = 0; x < width; x++) {
				fp.putPixel(x,y,lineX[x]);
			}
		}
		
		// Traiter les colonnes de l'image r�sultant du traitement des lignes
		/* � compl�ter */
		for(int x = 0; x < width; x++) {
			double[] lineX = DCT1D.forwardDCT(fp.getLine(x,0,x,height));
			for(int y = 0; y < height; y++) {
				fp.putPixel(x,y,lineY[y]);
			}
		}
	}

	// ---------------------------------------------------------------------------------
	/**
	 * Transformation DCT 2D inverse (m�thode de classe)
	 * @param fp Signal 2D d'entr�e et de sortie (FloatProcessor)
	 */
	public static void inverseDCT(FloatProcessor fp) {

		// Traiter les lignes
		/* � compl�ter */
		
		// Traiter les colonnes de l'image r�sultant du traitement des lignes
		/* � compl�ter */
	}
}