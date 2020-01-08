package DCT;

import ij.process.*;	// Pour classe Float Processor
import java.awt.Rectangle;

abstract public class DCT2D {
	
	// ---------------------------------------------------------------------------------
	/**
	 * Transformation DCT 2D directe (méthode de classe) utilisant la séparabilité
	 * @param fp Signal 2D d'entrée et de sortie (MxN) (FloatProcessor)
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
		
		// Traiter les colonnes de l'image résultant du traitement des lignes
		/* à compléter */
		for(int x = 0; x < width; x++) {
			double[] lineX = DCT1D.forwardDCT(fp.getLine(x,0,x,height));
			for(int y = 0; y < height; y++) {
				fp.putPixel(x,y,lineY[y]);
			}
		}
	}

	// ---------------------------------------------------------------------------------
	/**
	 * Transformation DCT 2D inverse (méthode de classe)
	 * @param fp Signal 2D d'entrée et de sortie (FloatProcessor)
	 */
	public static void inverseDCT(FloatProcessor fp) {

		// Traiter les lignes
		/* à compléter */
		
		// Traiter les colonnes de l'image résultant du traitement des lignes
		/* à compléter */
	}
}