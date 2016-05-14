package ar.edu.TPPOI;

import java.util.ArrayList;
import java.util.List;

public class Rango {

	private List<List<Intervalo>> rangos;

	public List<List<Intervalo>> getRangos() {
		return rangos;
	}

	public void setRangos(List<List<Intervalo>> rangos) {
		this.rangos = rangos;
	}
	
	public List<List<Intervalo>> traer(){
		Intervalo intervalo1=new Intervalo();
		intervalo1.setHoraInicio(9);
		intervalo1.setMinutoInicio(0);
		intervalo1.setHoraFin(18);
		intervalo1.setMinutoFin(0);
		List<Intervalo> horariosLunes= new ArrayList <Intervalo>();
		List<Intervalo> horariosMartes= new ArrayList <Intervalo>();
		List<Intervalo> horariosMiercoles= new ArrayList <Intervalo>();
		List<Intervalo> horariosJueves= new ArrayList <Intervalo>();
		List<Intervalo> horariosViernes= new ArrayList <Intervalo>();
		horariosLunes.add(intervalo1);
		horariosMartes.add(intervalo1);
		horariosMiercoles.add(intervalo1);
		horariosJueves.add(intervalo1);
		horariosViernes.add(intervalo1);
		rangos.add(horariosLunes);
		rangos.add(horariosMartes);
		rangos.add(horariosMiercoles);
		rangos.add(horariosJueves);
		rangos.add(horariosViernes);
		return rangos;
	}
	
}
