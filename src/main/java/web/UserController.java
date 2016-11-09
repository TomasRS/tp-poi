package web;

import spark.ModelAndView;
import spark.Request;
import spark.Response;

public class UserController {
	
	public static ModelAndView adminLog(Request req, Response res){
		return new ModelAndView(null, "usuarios/admin_log.hbs");
	}
	
	public static ModelAndView ventanaTerminal(Request req, Response res){
		return new ModelAndView(null, "usuarios/ventana_terminal.hbs");
	}
	
	public static ModelAndView adminPOIS(Request req, Response res){
		return new ModelAndView(null, "admin/admin_pois.hbs");
	}
	
	public static ModelAndView adminLogPost(Request req, Response res){
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
	
	public static ModelAndView adminShow(Request req, Response res){
		if(cookieOk(req, "admin", "true")){
			return adminPOIS(req, res);
		} else {
			res.redirect("/admin/ingreso");
			return null;
		}
	}
	public static ModelAndView adminClose(Request req, Response res){
		if(cookieOk(req, "admin", "true")){
			res.cookie("admin", "false");
		}
		res.redirect("/");
		return null;
	}
	
	private static boolean esUsuario(String user, String password){
		boolean status = user.contentEquals("root")&&password.contentEquals("");
		System.out.println("OK?");
		System.out.println(status);
		return status;
	}
	
	private static boolean cookieOk(Request req, String key, String val){
		String cookieVal = req.cookie(key);
		System.out.println(cookieVal);
		if (cookieVal!=null){
			return cookieVal.contentEquals(val);
		} else {
			return false;
		}
	}
	
}
