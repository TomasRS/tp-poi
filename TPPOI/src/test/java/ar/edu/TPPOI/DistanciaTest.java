package ar.edu.TPPOI;

import org.junit.Before;
import org.junit.Test;
import junit.framework.Assert;

public class DistanciaTest{
	private SucursalBanco banco;
	private LocalComercial farmacia;
	private Punto puntoBanco;
	private Punto puntoFarmacia;
	private ParadaDeColectivo paradaLinea65;
	private Punto puntoCabildoYJuramento;
	private SucursalBanco bancoGalicia;
	private Punto puntoBancoGalicia;
	@Before
	public void init(){
		puntoBanco = new Punto();
		puntoBanco.setLatitud(-34.612857);   //Barrio de Buenos Aires
		puntoBanco.setLongitud(-58.500933);
		puntoBancoGalicia = new Punto();
		puntoBancoGalicia.setLatitud(-34.560188);
		puntoBancoGalicia.setLongitud(-58.453834);
		puntoCabildoYJuramento= new Punto();
		puntoCabildoYJuramento.setLatitud(-34.562175);
		puntoCabildoYJuramento.setLongitud(-58.456473);
		puntoFarmacia = new Punto();
		puntoFarmacia.setLatitud(41.890074);   //Coliseo Romano
		puntoFarmacia.setLongitud(12.492242);
		banco = new SucursalBanco();
		bancoGalicia=new SucursalBanco();
		farmacia = new LocalComercial();
		banco.setPunto(puntoBanco);
		farmacia.setPunto(puntoFarmacia);
		paradaLinea65 = new ParadaDeColectivo();
		paradaLinea65.setLinea("65");
		paradaLinea65.setPunto(puntoCabildoYJuramento);
		bancoGalicia.setPunto(puntoBancoGalicia);
	}
	
		@Test
		public void noEstanCerca(){
			Assert.assertFalse(banco.estoyCercaRespectoA(farmacia));	
		}
		
		@Test
		public void laParadaDel65YElBancoGaliciaEstanCerca(){
			Assert.assertFalse(bancoGalicia.estoyCercaRespectoA(paradaLinea65));
		}
	}
