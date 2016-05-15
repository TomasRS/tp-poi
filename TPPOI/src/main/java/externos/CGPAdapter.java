package externos;

import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import ar.edu.TPPOI.CGP;
import ar.edu.TPPOI.Direccion;
import ar.edu.TPPOI.Horario;
import ar.edu.TPPOI.POI;
import ar.edu.TPPOI.Servicio;

public class CGPAdapter implements SistemaExternoAdapterInterface{
	
	CGPExternoImpostor CGPExternoImpostor;
	
	public CGPAdapter(CGPExternoImpostor unSistemaConsultaDeCGPsExterno) {
		CGPExternoImpostor = unSistemaConsultaDeCGPsExterno;
	}

	public List<POI> buscar(String unTextoLibre){
		List<CentroDTO> listaDeCGPsExternos = CGPExternoImpostor.buscar(unTextoLibre);
		List<POI> listaCGPEncontrados = new ArrayList<>();
		if (listaDeCGPsExternos==null){//code smells, no se ve bien comparar con null
			System.out.println("hay null");
		} else {
			listaCGPEncontrados = this.generarNuevosCGPs(listaDeCGPsExternos);
		}
		return listaCGPEncontrados;
	}

	private List<POI> generarNuevosCGPs(List<CentroDTO> listaDeCGPsExternos) {
		List<POI> nuevasCGPs = new ArrayList<>();
		listaDeCGPsExternos.stream().forEach(unCGPExterno->nuevasCGPs.add(crearCGPDeExterno(unCGPExterno)));
		return nuevasCGPs;
	}

	private CGP crearCGPDeExterno(CentroDTO unCGPExterno){
		CGP nuevoCGP = new CGP(partirDomicilio(unCGPExterno));
		nuevoCGP.setId(unCGPExterno.getId());
		//comuna en nuestro sistema es polygon y externamente es un entero
		nuevoCGP.setZonasQueIncluye(unCGPExterno.getZonas());
		Arrays.stream(unCGPExterno.getServiciosDTO()).forEach(
				unServicioDTO -> 
				nuevoCGP.agregarServicio(convertirServicioExterno(unServicioDTO)));
		return nuevoCGP;
	}
	
	private Servicio convertirServicioExterno(ServicioDTO servicioDTO){
		String nombre = servicioDTO.getNombreServicio();
		List<Horario> horariosDTO = new ArrayList<>();
		servicioDTO.getRangosServicioDTO().stream().forEach(
				unRango -> 
				horariosDTO.add(convertirRangosServicioExterno(unRango)));
		Servicio servicioNuevo = new Servicio(nombre, horariosDTO);
		return servicioNuevo;
	}
	
	private Horario convertirRangosServicioExterno(Integer[] rangoServicioDTO){
		DayOfWeek diaDeSemana = DayOfWeek.of(rangoServicioDTO[0]);
		LocalTime horaInicio = LocalTime.of(
				rangoServicioDTO[1], 
				rangoServicioDTO[2]);
		LocalTime horaFin = LocalTime.of(
				rangoServicioDTO[3], 
				rangoServicioDTO[4]);
		Horario nuevoHorario = new Horario(
				diaDeSemana,
				horaInicio,
				horaFin);
		return nuevoHorario;
	}
	
	private Direccion partirDomicilio(CentroDTO unCGPExterno) {
		Integer numeracion=0;
		String callePrincipal="";
		String str = unCGPExterno.getDomicilioCompleto();
		String delimiter = "";
		String[] temp;
		temp = str.split(delimiter);
		for (int i = unCGPExterno.getDomicilioCompleto().length()-1;i==0; i--)
		{
		numeracion=Integer.parseInt(temp[1]);
		callePrincipal=str.substring(0, str.length()-temp.length);
		}
		Direccion domicilioConvertido= new Direccion();
		domicilioConvertido.setPrincipal(callePrincipal, numeracion);
		return domicilioConvertido;
	}

	@Override
	public List<POI> buscar(String unTextoLibre, String otroTextoLibre) {
		return buscar(unTextoLibre);
	}
}

