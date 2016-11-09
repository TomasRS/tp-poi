package web;

import spark.ModelAndView;
import spark.Request;
import spark.Response;

public class UserController {
	
	public static ModelAndView adminLog(Request req, Response res){
//		System.out.println("Admin Logging");
		return new ModelAndView(null, "usuarios/admin_log.hbs");
	}
	
	public static ModelAndView ventanaTerminal(Request req, Response res){
		return new ModelAndView(null, "usuarios/ventana_terminal.hbs");
	}
}
