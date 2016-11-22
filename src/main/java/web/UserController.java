package web;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;

import org.uqbarproject.jpa.java8.extras.PerThreadEntityManagers;

import acciones.Almacenar;
import acciones.Notificar;
import ar.edu.TPPOI.MapaPOI;
import ar.edu.TPPOI.Terminal;
import clasesParaTests.SoporteDeInstanciasParaTestsBuilder;
import deApoyo.Comuna;
import deApoyo.RepositorioDeTerminales;
import excepciones.POINoExistente;
import pois.POI;
import spark.ModelAndView;
import spark.Request;
import spark.Response;
import users.UserManager;

public class UserController {
	
	MapaPOI mapa;
	UserManager uMan;
	EntityManager em;
	
	public UserController(MapaPOI aMap){
		SoporteDeInstanciasParaTestsBuilder soporte = new SoporteDeInstanciasParaTestsBuilder();
//		mapa = aMap;
		mapa = soporte.mapa();
		uMan = UserManager.getInstance();
		em = PerThreadEntityManagers.getEntityManager();
	}
	
	public ModelAndView adminLog(Request req, Response res){
		return new ModelAndView(null, "usuarios/admin_log.hbs");
	}
	
	public ModelAndView ventanaTerminal(Request req, Response res){
		return new ModelAndView(null, "usuarios/ventana_terminal.hbs");
	}
	
	public ModelAndView adminPOIS(Request req, Response res){
		return new ModelAndView(null, "admin/admin_pois.hbs");
	}
	
	public ModelAndView adminLogPost(Request req, Response res){
//		System.out.println("Datos recibidos");
		String username = req.queryParams("txt_username");
		String password = req.queryParams("txt_password");
		if (esUsuario(username, password)){
//			System.out.println("LOG OK");
			res.cookie("admin", "true");
			res.redirect("/admin/workspace");
			return adminPOIS(req, res);
		} else {
			return adminLog(req, res);
		}
	}
	
	public ModelAndView adminShow(Request req, Response res){
		verificarLogueo(req, res);
		return adminPOIS(req, res);
	}
	
	public ModelAndView adminTerminalShow(Request req, Response res){
		verificarLogueo(req, res);
		return adminTerminal(req, res);
	}
	
	public ModelAndView adminConsultasShow(Request req, Response res){
		verificarLogueo(req, res);
		return adminConsultas(req, res);
	}
	
	public ModelAndView showPois(Request req, Response res){
		verificarLogueo(req, res);
		System.out.println("Muestro pois");
		String cadenaABuscar = req.queryParams("buscar_pois");
		List<POI> pois = mapa.buscar(cadenaABuscar);
//		List<POI> pois = mapa.getListaDePOIs();
		System.out.println(pois.size());
		HashMap<String, List<POIShowStruct>> hmap = new HashMap<>();
		hmap.put("pois", pois2show(pois));
		return new ModelAndView(hmap, "admin/admin_pois_founded.hbs");
	}
	/*public ModelAndView filterPois(Request req, Response res){
		
	}*/
	
	public ModelAndView showAddTerminal(Request req, Response res){
		verificarLogueo(req, res);
		HashMap< String, List<Comuna>> hmap = new HashMap<>();
		List<Comuna> comunas = mapa.getComunas();
//		Comuna otra = new Comuna();
//		otra.
//		otra.setDescripcion("descripcion");
//		comunas.add(otra);
		hmap.put("comunas", comunas);
		return new ModelAndView(hmap
			,"admin/admin_terminales_add.hbs");
	}
	
	public ModelAndView addTerminal(Request req, Response res) {
		verificarLogueo(req, res);
		System.out.println("agregar terminal");
		System.out.println("---------------------------");
		String terminalAAgegar = req.queryParams("nombreTerminal");
		System.out.println(terminalAAgegar);
		String almacenarSI = req.queryParams("almacenar");
		System.out.println(almacenarSI);
		String notificarSI = req.queryParams("notificar");
		System.out.println(notificarSI);
		Terminal unaT = new Terminal();
		Boolean chkbxNotificarSI = (notificarSI != null);
		unaT.setDescripcion(terminalAAgegar);
		Boolean chkbxAlmacenarSI = (almacenarSI != null);
		if (chkbxNotificarSI) {
			Notificar n = new Notificar();
			unaT.activarAccion(n);
		}
		if (chkbxAlmacenarSI) {
			Almacenar a = new Almacenar();
			unaT.activarAccion(a);
		}
		long unId = Long.parseLong(req.queryParams("comuna"));
		Comuna comuna = mapa.getComunaById(unId);
		unaT.setComuna(comuna);
		em.getTransaction().begin();
		RepositorioDeTerminales.agregarTerminal(unaT);
		em.getTransaction().commit();
		System.out.println("finnn-------------------");
		return new ModelAndView(null, "admin/admin_terminales.hbs");

	}
	public ModelAndView adminTerminal(Request req, Response res){
		return new ModelAndView(null, "admin/admin_terminales.hbs");
	}
	
	public ModelAndView showTerminales(Request req, Response res){
		verificarLogueo(req, res);
		HashMap<String, List<Terminal>> hmap = new HashMap<>();
		String textSearch = req.queryParams("buscar_terminales");
		List<Terminal> terminales = new ArrayList<>();;
		String criteria = req.queryParams("criteria");
		System.out.println(criteria);
		if (criteria==null){
			System.out.println("muestro todas las terminales");
			terminales = RepositorioDeTerminales.getTerminales();
		} else if (criteria.equalsIgnoreCase("comunaBox")){
			System.out.println("busco por comuna");
			terminales = RepositorioDeTerminales.searchByComuna(textSearch);
		} else if (criteria.equalsIgnoreCase("nombreBox")) {
			System.out.println("busco por comuna");
			terminales = RepositorioDeTerminales.searchByDescripcion(textSearch);
		}
		System.out.println("------");
		System.out.println(terminales.size());
		hmap.put("terminales", terminales);
		return new ModelAndView(hmap, "admin/admin_terminales_founded.hbs");
	}
	
	public ModelAndView showEditTerminal(Request req, Response res){
		verificarLogueo(req, res);
		System.out.println("muestro edicion terminal");
		System.out.println("---------------------");
		String id = req.params("id");
		Terminal terminal = RepositorioDeTerminales.getTerminalById(Long.parseLong(id));
		if (terminal!=null){
			HashMap< String, Object> hmap = new HashMap<>();
			List<Comuna> comunas = mapa.getComunas();
			hmap.put("comunas", comunas);
			hmap.put("id", id);
			return new ModelAndView(hmap, "admin/admin_terminales_edit.hbs");
		} else {
			return new ModelAndView(null, "admin/terminal_no_existente.hbs");
		}
	}
	
	public ModelAndView editTerminal(Request req, Response res){
		verificarLogueo(req, res);
		System.out.println("editar terminal");
		System.out.println("---------------------------");
		String terminalAAgegar = req.queryParams("nombreTerminal");
		System.out.println(terminalAAgegar);
		String almacenarSI = req.queryParams("almacenar");
		System.out.println(almacenarSI);
		String notificarSI = req.queryParams("notificar");
		System.out.println(notificarSI);
		String termId = req.params("id");
		Terminal unaT = RepositorioDeTerminales.getTerminalById(Long.parseLong(termId));
		unaT.desactivarTodasAcciones();
		Boolean chkbxNotificarSI = (notificarSI != null);
		unaT.setDescripcion(terminalAAgegar);
		Boolean chkbxAlmacenarSI = (almacenarSI != null);
		if (chkbxNotificarSI) {
			Notificar n = new Notificar();
			if (!(unaT.getAcciones().stream().anyMatch(accion->accion.getClass().equals(n.getClass())))){
			unaT.activarAccion(n);
			}
		}
		if (chkbxAlmacenarSI) {
			Almacenar a = new Almacenar();
			if (!(unaT.getAcciones().stream().anyMatch(accion->accion.getClass().equals(a.getClass())))){
				unaT.activarAccion(a);
				}
		}
		long unId = Long.parseLong(req.queryParams("comuna"));
		Comuna comuna = mapa.getComunaById(unId);
		unaT.setComuna(comuna);
		em.getTransaction().begin();
		RepositorioDeTerminales.actualizarTerminal(unaT);
		em.getTransaction().commit();
		System.out.println("finnn-------------------");
		return new ModelAndView(null, "admin/admin_terminales.hbs");
	}
	
	public ModelAndView deleteTerminal(Request req, Response res){
		Set<String> terminalesId =req.queryParams();
		System.out.println(terminalesId);
		List<Terminal> terminales = terminalesId.stream().map(
			aT->RepositorioDeTerminales.getTerminalById(Long.parseLong(aT)))
			.collect(Collectors.toList());
		em.getTransaction().begin();
		terminales.forEach(aT->RepositorioDeTerminales.eliminarTerminal(aT));
		em.getTransaction().commit();
		res.redirect("/admin/terminales");
		return null;
	}
	
	public ModelAndView adminConsultas(Request req, Response res){
		return new ModelAndView(null, "admin/admin_consultas.hbs");
	}
	
	public ModelAndView showConsultas(Request req, Response res){
//		HashMap<String, List<Terminal>> hmap = new HashMap<>();
//		hmap.put("terminales", new ArrayList<>());
		return new ModelAndView(null, "admin/admin_consultas_founded.hbs");
	}
	
	public ModelAndView adminClose(Request req, Response res){
		if(cookieOk(req, "admin", "true")){
			res.cookie("admin", "false");
		}
		res.redirect("/");
		return null;
	}
	
	public ModelAndView terminalClose(Request req, Response res){
		if(cookieOk(req, "terminal", "true")){
			res.cookie("terminal", "false");
		}
		res.redirect("/");
		return null;
	}
	
	public ModelAndView showPOI(Request req, Response res){
		verificarLogueo(req, res);
		System.out.println("muestro poi");
		System.out.println("---------------------");
		String id = req.params("id");
		POI aPOI;
		try {
			aPOI = mapa.getPOIbyId(Long.parseLong(id));

			System.out.println(aPOI);
			POIShowStruct pShow = aPOI.toShow();
			return new ModelAndView(pShow, "admin/poi_spec.hbs");
		} catch (POINoExistente e) {
			// TODO Auto-generated catch block
			return new ModelAndView(null, "admin/poi_no_existente.hbs");
		}
	}
	
	private boolean esUsuario(String user, String password){
		boolean status = uMan.anyMatch(user, password);
//		System.out.println("OK?");
//		System.out.println(status);
		return status;
	}
	
	private boolean cookieOk(Request req, String key, String val){
		String cookieVal = req.cookie(key);
		System.out.printf("CookieStat:%s\n", cookieVal);
		if (cookieVal!=null){
			return cookieVal.contentEquals(val);
		} else {
			return false;
		}
	}
	
	private List<POIShowStruct> pois2show(List<POI> pois){
		List<POIShowStruct> poisShow = new ArrayList<>();
		for (POI aPOI:pois){
			poisShow.add(aPOI.toShow());
		}
		return poisShow;
	}
	
	private void verificarLogueo(Request req, Response res){
		if(!cookieOk(req, "admin", "true")){
			res.redirect("/admin/ingreso");
		}
	}
	
}
