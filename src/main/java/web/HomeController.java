package web;

import spark.ModelAndView;
import spark.Request;
import spark.Response;

public class HomeController {

	public static ModelAndView principal(Request req, Response res){
//		System.out.println("principal");
		return new ModelAndView(null, "home/principal.hbs");
	}
}
