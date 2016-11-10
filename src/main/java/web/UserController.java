package web;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import ar.edu.TPPOI.MapaPOI;
import ar.edu.TPPOI.Terminal;
import deApoyo.Punto;
import pois.Direccion;
import pois.POI;
import pois.ParadaDeColectivo;
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
		ArrayList<POIShowStruct> pois = new ArrayList<>();
		POI poi1 = new ParadaDeColectivo("114 Lugano", new Punto(12.312, 12.312), new Direccion("Mozart", 2000));
		POI poi2 = new ParadaDeColectivo("151 Medrano", new Punto(12.312, 12.312), new Direccion("Medrano", 790));
		pois.add(poi1.toShow());
		pois.add(poi2.toShow());
		System.out.println(poi1.toShow().toString());
		HashMap<String, List<POIShowStruct>> hmap = new HashMap<>();
		hmap.put("pois", pois);
		return new ModelAndView(hmap, "admin/admin_pois_founded.hbs");
	}
	
	public ModelAndView adminTerminal(Request req, Response res){
		return new ModelAndView(null, "admin/admin_terminales.hbs");
	}
	
	public ModelAndView showTerminales(Request req, Response res){
		HashMap<String, List<Terminal>> hmap = new HashMap<>();
		hmap.put("terminales", new ArrayList<>());
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
	
	private boolean esUsuario(String user, String password){
		boolean status = uMan.anyMatch(user, password);
//		System.out.println("OK?");
//		System.out.println(status);
		return status;
	}
	
	private boolean cookieOk(Request req, String key, String val){
		String cookieVal = req.cookie(key);
		System.out.println(cookieVal);
		if (cookieVal!=null){
			return cookieVal.contentEquals(val);
		} else {
			return false;
		}
	}
	
}
