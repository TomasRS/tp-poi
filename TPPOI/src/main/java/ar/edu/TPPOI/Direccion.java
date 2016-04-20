package ar.edu.TPPOI;

import java.util.ArrayList;
import java.util.List;

public class Direccion {
	
	private String calle1;
	private String calle2;
	private Integer numero;
	private String callePrincipal;
	private Integer piso;
	private String depto;
	private String unidad;
	private String codigoPostal;
	private String localidad;
	private String barrio;
	private String provincia;
	private String pais;
	
	//No tocar por ahora , lo estoy usando como guia para los metodos
	public Direccion(Integer numero, String callePrincipal, Integer piso, String depto,
			String unidad, String codigoPostal, String localidad, String barrio, String provincia, String pais) {
		this.numero = numero;
		this.callePrincipal = callePrincipal;
		this.piso = piso;
		this.depto = depto;
		this.unidad = unidad;
		this.codigoPostal = codigoPostal;
		this.localidad = localidad;
		this.barrio = barrio;
		this.provincia = provincia;
		this.pais = pais;
	}
		
	public Direccion() {
		
	}

	public void setCalles(String calle1, String calle2){
		this.calle1 = calle1;
		this.calle2 = calle2;
	}
	
	public List<String> posiblesPalabrasClaves(){
		List<String> posiblesPalabrasClaves = new ArrayList<>();
		posiblesPalabrasClaves.add(this.calle1);
		posiblesPalabrasClaves.add(this.calle2);
		/*posiblesPalabrasClaves.add(String.valueOf(numero));
		posiblesPalabrasClaves.add(callePrincipal);
		posiblesPalabrasClaves.add(String.valueOf(piso));
		posiblesPalabrasClaves.add(depto);
		posiblesPalabrasClaves.add(unidad);
		posiblesPalabrasClaves.add(codigoPostal);
		posiblesPalabrasClaves.add(localidad);
		posiblesPalabrasClaves.add(barrio);
		posiblesPalabrasClaves.add(provincia);
		posiblesPalabrasClaves.add(pais);*/
		return posiblesPalabrasClaves;
	}
	
}
