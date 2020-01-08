package DCT;

import ij.*;
import ij.plugin.filter.*;
import ij.process.*;
import ij.gui.*;
public class validation_ implements PlugInFilter{

	ImagePlus imp;	// Fen�tre contenant l'image de r�f�rence
    int width;		// Largeur de la fen�tre
    int height;		// Hauteur de la fen�tre

    public int setup(String arg, ImagePlus imp) {
    	this.imp = imp;
		return PlugInFilter.DOES_8G;
    }
        
	
    public void run(ImageProcessor ip) {

       
        FloatProcessor fp =    ip.toFloat();
        fp.subtract(128);
        forwardDCT(fp);
        ImagePlus im = new ImagePlus("Resultat DCT2D",fp);
        im.show();

    }
    
    /**
	 * Transformation DCT 1D directe (m�thode de classe)
	 * @param f(m) Signal 1D d'entr�e (double[])
	 * @return F(u) Signal transform� (double[])
	 */ 
	public static double[] forwardDCT1D(double[] f) {
		int M = f.length;	// Taille du signal
		double k = Math.sqrt(2.0 / M); // Facteur de normalisation
		double[] F = new double[M];	// r�sulat
		for (int u = 0; u < M; u++) {
			double cu = 1.0;
			if (u == 0)
				cu = 1.0 / Math.sqrt(2);	// Facteur de normalisation
			double somme = 0.0;
			for (int m = 0; m < M; m++) {
				somme = somme + f[m] * Math.cos(Math.PI * (m + 0.5) * u / M);
			}
			F[u] = k * cu * somme;
		}
		return F;
	}

	// ---------------------------------------------------------------------------------
	/**
	 * Transformation DCT 1D inverse (m�thode de classe)
	 * @param F(u) Signal 1D transform� (double[])
	 * @return f(m) signal inverse (double[])
	 */
	public static double[] inverseDCT1D(double[] F) {
		int M = F.length;	// Taille du signal
		double k = Math.sqrt(2.0 / M);	// Facteur de normalisation
		double[] f = new double[M];	// r�sulat
		for (int m = 0; m < M; m++) {
			double somme = 0;
			for (int u = 0; u < M; u++) {
				double cu = 1.0;
				if (u == 0)
					cu = 1.0/Math.sqrt(2);	// Facteur de normalisation d�pendant de u
				somme = somme + cu * F[u] * Math.cos(Math.PI * (m + 0.5) * u / M);
			}
			f[m] = k * somme;
		}
		return f;
	}
	
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
				double[] lineY = forwardDCT1D(fp.getLine(0,y,width,y));
				for(int x = 0; x < width; x++) {
					fp.putPixel(x,y,lineY[x]);
				}
			}
			
			// Traiter les colonnes de l'image r�sultant du traitement des lignes
			/* � compl�ter */
			for(int x = 0; x < width; x++) {
				double[] lineX = forwardDCT1D(fp.getLine(x,0,x,height));
				for(int y = 0; y < height; y++) {
					fp.putPixel(x,y,lineX[y]);
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
