package web;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.swing.JCheckBox;

import acciones.Almacenar;
import acciones.Notificar;
import ar.edu.TPPOI.MapaPOI;
import ar.edu.TPPOI.Terminal;
import deApoyo.Punto;
import deApoyo.RepositorioDeTerminales;
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
		String cadenaABuscar = req.queryParams("buscar");
		List<POI> pois = mapa.buscar(cadenaABuscar);
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
		RepositorioDeTerminales unR=RepositorioDeTerminales.getSingletonInstance();
		unR.agregarTerminal(unaT);
		return new ModelAndView(unR,"admin/admin_terminales.hbs");
		
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
	
	private List<POIShowStruct> pois2show(List<POI> pois){
		List<POIShowStruct> poisShow = new ArrayList<>();
		for (POI aPOI:pois){
			poisShow.add(aPOI.toShow());
		}
		return poisShow;
	}
	
}
