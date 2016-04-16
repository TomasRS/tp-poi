package ar.edu.TPPOI;

import java.util.ArrayList;
import java.util.List;
import org.uqbar.geodds.Point;
import org.uqbar.geodds.Polygon;

public class PruebaPolygon {

	public static void main(String [ ] args)
	{
		Point coordenadaMia = new Point(-58.41059446334839, -34.60421247366349);
		Point coordenadaParada114= new Point(-58.459845185279846, -34.558164509672146);
		List<Point> puntos = new ArrayList<>();

		puntos.add(new Point(-58.411898, -34.597984));
		puntos.add(new Point(-58.426446, -34.597878));
		puntos.add(new Point(-58.433334, -34.602696));
		puntos.add(new Point(-58.430051, -34.615469));
		puntos.add(new Point(-58.427899, -34.622162));
		puntos.add(new Point(-58.412372, -34.620890));
		Polygon poligono = new Polygon(puntos);
		
		/*Debería dar true*/
		System.out.println(poligono.isInside(coordenadaMia));
		System.out.println(poligono.isInside(coordenadaParada114));	
	}
}
