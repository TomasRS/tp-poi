package deApoyo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Convert;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;

import org.uqbar.geodds.Point;
import org.uqbar.geodds.Polygon;

import converters.PointConverter;

@Entity
public class Poligono {
	
	@Id @GeneratedValue
	private long id;
	
//	@ElementCollection(targetClass=String.class)
//	@Convert(converter = PointConverter.class)
	@ElementCollection
	private List<String> sPuntos;//lista auxiliar para persistir puntos
	@Transient
	private List<Point> puntos;
	
	public Poligono(){
		puntos = new ArrayList<Point>();
		sPuntos = new ArrayList<String>();
	}

	public Poligono(List<Point> unosPuntos) {
		this.puntos = unosPuntos;
		sPuntos = new ArrayList<String>();
		unosPuntos.forEach(
				unPunto -> sPuntos.add((new PointConverter()).convertToDatabaseColumn(unPunto)));
	}
	
//	public Poligono(List<String> unosSPuntos) {
//		this.sPuntos = unosSPuntos;
//		this.puntos = new ArrayList<Point>();
//		unosSPuntos.forEach(
//				unSPunto -> puntos.add((new PointConverter()).convertToEntityAttribute(unSPunto)));
//	}

	public boolean isInside(Point unaCoordenada) {
		return this.getPolygon().isInside(unaCoordenada);
	}
	
	public void add(Point unPunto){
		this.puntos.add(unPunto);
		this.sPuntos.add((new PointConverter()).convertToDatabaseColumn(unPunto));
	}
	
	private Polygon getPolygon(){
		return new Polygon(this.puntos);
	}
	
	private void setSPuntos(List<String> unosPuntos){
		this.sPuntos = unosPuntos;
		this.puntos = new ArrayList<Point>();
		unosPuntos.forEach(unSPoint -> (new PointConverter()).convertToEntityAttribute(unSPoint));
	}
}
