package ar.edu.TPPOI;

import java.util.ArrayList;
import java.util.List;

public class Direccion {
	
	private String calle1;
	private String calle2;
	private Integer numero;
	private String callePrincipal;
	private Integer piso;
	private String letraDepto;
	private String unidad;
	private String localidad;
	private String barrio;
	private String provincia;
	private String pais;
	
	public Direccion() {
		//Constructor para instanciar la clase sin atributos
	}
	
	public Direccion(String callePrincipal, Integer numero){
		//constructor que se deberia utilizar siempre
		this.callePrincipal = callePrincipal;
		this.numero = numero;
	}
	
	public void setPrincipal(String callePrincipal, Integer numero){
		this.callePrincipal = callePrincipal;
		this.numero = numero;
	}

	public void setCalles(String calle1, String calle2){
		this.calle1 = calle1;
		this.calle2 = calle2;
	}
	
	public void setDepartamento(Integer piso, String letraDepto){
		this.piso = piso;
		this.letraDepto = letraDepto;
	}
	
	public void setJurisdiccion(String localidad, String barrio, String provincia, String pais){
		this.localidad = localidad;
		this.barrio = barrio;
		this.provincia = provincia;
		this.pais = pais;
	}
	
	public void setUnidad(String unidad){
		this.unidad = unidad;
	}
	
	public List<String> posiblesPalabrasClaves(){
		List<String> posiblesPalabrasClaves = new ArrayList<>();
		posiblesPalabrasClaves.add(this.calle1);
		posiblesPalabrasClaves.add(this.calle2);
		posiblesPalabrasClaves.add(String.valueOf(numero));
		posiblesPalabrasClaves.add(callePrincipal);
		posiblesPalabrasClaves.add(String.valueOf(piso));
		posiblesPalabrasClaves.add(letraDepto);
		posiblesPalabrasClaves.add(unidad);
		posiblesPalabrasClaves.add(localidad);
		posiblesPalabrasClaves.add(barrio);
		posiblesPalabrasClaves.add(provincia);
		posiblesPalabrasClaves.add(pais);
		return posiblesPalabrasClaves;
	}
	
}
