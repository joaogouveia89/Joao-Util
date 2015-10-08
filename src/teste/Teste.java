package teste;

import java.util.ArrayList;

import joao.util.numcal.Interpolation;

public class Teste {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ArrayList<Float> x = new ArrayList<Float>();
		ArrayList<Float> fx = new ArrayList<Float>();
		
		x.add((float)-2);
		x.add((float)-1);
		x.add((float)0);
		x.add((float)1);
		x.add((float)2);
		
		fx.add((float)4);
		fx.add((float)1);
		fx.add((float)0);
		fx.add((float)1);
		fx.add((float)4);

		double a = Interpolation.LagrangeInterpol(x, fx, (float)1);
		
		System.out.println(a);
	}

}
