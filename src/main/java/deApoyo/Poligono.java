package deApoyo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Convert;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

import org.uqbar.geodds.Point;
import org.uqbar.geodds.Polygon;

@Entity
public class Poligono {
	
	@Id @GeneratedValue
	private long id;

	@OneToMany(cascade=CascadeType.ALL)
	private List<Punto> surface;
	
	public Poligono(){
		surface = new ArrayList<Punto>();
	}

	public Poligono(List<Punto> unosPuntos) {
		this.surface = unosPuntos;
	}
	
	public void add(Punto unPunto){
		this.surface.add(unPunto);
	}
	
	public boolean isInside(Punto unPunto){
		return getPoligon().isInside(new Point(unPunto.latitude(), unPunto.longitude()));
	}
	
	public Polygon getPoligon(){
		Polygon polygon = new Polygon();
		surface.forEach(unPunto->polygon.add(
			new Point(unPunto.latitude(), unPunto.longitude())));
		return polygon;
	}
	
}
