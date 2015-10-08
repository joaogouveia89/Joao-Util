package joao.util.numcal;

import java.util.ArrayList;

public class Interpolation {
	
	public static double LagrangeInterpol(ArrayList<Float> x, ArrayList<Float> fx, float desirex){
		
		ArrayList<Double> l = new ArrayList<Double>();
		
		int sizex = x.size();
		int sizefx = fx.size();
		double dominador = 1;
		double denominador = 1;
		double lval;
		double interpol = 0;
		
		try{
			for(int n = 0; n < sizex; n++){
				dominador = 1;
				denominador = 1;
				for(int m = 0; m < sizex; m++){
					if(m!=n){
						dominador *= (desirex - x.get(m));
						denominador *= (x.get(n) - x.get(m));
					}				
				}
				lval = dominador/denominador;
				l.add(lval);
			}
			
			for(int n = 0; n < sizex; n++){
				interpol += (fx.get(n) * l.get(n));				
			}
			return interpol;
		}
		catch(Exception e){
			if(sizex != sizefx){
				System.out.println("ERROR!!! x array size MUST have to be equal to fx array size");
			}
		}		
		return 0.000001;
	}
}
