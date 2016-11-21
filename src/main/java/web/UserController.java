package web;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import acciones.Almacenar;
import acciones.Notificar;
import ar.edu.TPPOI.MapaPOI;
import ar.edu.TPPOI.Terminal;
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
	
	public UserController(MapaPOI aMap){
		mapa = aMap;
		uMan = UserManager.getInstance();
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
		if(cookieOk(req, "admin", "true")){
			return adminPOIS(req, res);
		} else {
			res.redirect("/admin/ingreso");
			return null;
		}
	}
	
	public ModelAndView addTerminales (Request req, Response res){
		res.redirect("/admin/agregarTerminal");
		return null;
	}
	
	public ModelAndView adminTerminalShow(Request req, Response res){
		if(cookieOk(req, "admin", "true")){
			return adminTerminal(req, res);
		} else {
			res.redirect("/admin/ingreso");
			return null;
		}
	}
	
	public ModelAndView adminConsultasShow(Request req, Response res){
		if(cookieOk(req, "admin", "true")){
			return adminConsultas(req, res);
		} else {
			res.redirect("/admin/ingreso");
			return null;
		}
	}
	
	public ModelAndView showPois(Request req, Response res){
		System.out.println("Muestro pois");
		String cadenaABuscar = req.queryParams("buscar_pois");
		List<POI> pois = mapa.buscar(cadenaABuscar);
//		List<POI> pois = mapa.getListaDePOIs();
		System.out.println(pois.size());
		HashMap<String, List<POIShowStruct>> hmap = new HashMap<>();
		hmap.put("pois", pois2show(pois));
		return new ModelAndView(hmap, "admin/admin_pois_founded.hbs");
	}
	public ModelAndView addTerminal(Request req, Response res){
	String terminalAAgegar=req.queryParams("agregarNombreTerminal");
	String notificarSI=req.queryParams("NotificarSI");
	String almacenarSI=req.queryParams("AlmacenarSI");
	Terminal unaT=new Terminal();
	Boolean chkbxNotificarSI=(notificarSI!=null);
	unaT.setDescripcion(terminalAAgegar);
	Boolean chkbxAlmacenarSI=(almacenarSI!=null);
	if (chkbxNotificarSI){
		Notificar n=new Notificar();
		unaT.activarAccion(n);
	}
	if (chkbxAlmacenarSI){
		Almacenar a=new Almacenar();
		unaT.activarAccion(a);
	}
	RepositorioDeTerminales.agregarTerminal(unaT);
	return new ModelAndView(RepositorioDeTerminales.getTerminales()
		,"admin/admin_terminales.hbs");
	
}
	public ModelAndView adminTerminal(Request req, Response res){
		return new ModelAndView(null, "admin/admin_terminales.hbs");
	}
	
	public ModelAndView showTerminales(Request req, Response res){
		HashMap<String, List<Terminal>> hmap = new HashMap<>();
		String textSearch = req.queryParams("buscar_terminales");
		List<Terminal> terminales;
		System.out.println(req.queryParams("criteria"));
		if (req.queryParams("criteria").equalsIgnoreCase("allBox")){
			System.out.println("muestro todas las terminales");
			terminales = RepositorioDeTerminales.getTerminales();
		} else {
			terminales = RepositorioDeTerminales.buscar(textSearch);
		}
		System.out.println("------");
		System.out.println(terminales.size());
		hmap.put("terminales", terminales);
		return new ModelAndView(hmap, "admin/admin_terminales_founded.hbs");
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
	
}
