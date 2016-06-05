package ar.edu.TPPOI;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TerminalTest {

	Terminal terminalAbasto = new Terminal();
	Notificar notificarDeTerminalAbasto = new Notificar();
	
	@Before
	public void init(){
		SoporteDeInstanciasParaTestsBuilder soporteParaTests = new SoporteDeInstanciasParaTestsBuilder();
		
		notificarDeTerminalAbasto.setActivado(true);
	//	terminalAbasto.setTiempoLimite(/*setear un valor menor a lo que tarda la busqueda*/);
		
	}
}
