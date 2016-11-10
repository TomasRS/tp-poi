package web;

import ar.edu.TPPOI.MapaPOI;
import spark.Spark;
import spark.template.handlebars.HandlebarsTemplateEngine;

public class Router {
	
	public static void initialize(MapaPOI aMapaPOI){
		HandlebarsTemplateEngine engine = HandlebarsTemplateEngineBuilder
				.create()
				.withDefaultHelpers()
				.withHelper("isTrue", BooleanHelper.isTrue)
				.build();
		UserController uContr = new UserController(aMapaPOI);
		Spark.staticFileLocation("/static");
		Spark.get("/", HomeController::principal, engine);
		Spark.get("/admin/ingreso", uContr::adminLog, engine);
		Spark.get("/terminal/ventanaDeTerminal", uContr::ventanaTerminal,engine);
		Spark.post("/admin/ingreso", uContr::adminLogPost, engine);
		Spark.get("/admin/workspace", uContr::adminShow, engine);
		Spark.post("/admin/workspace", uContr::showPois, engine);
		Spark.get("/admin/terminales", uContr::adminTerminalShow, engine);
		Spark.post("/admin/terminales", uContr::showTerminales, engine);
		Spark.get("/admin/consultas", uContr::adminConsultasShow, engine);
		Spark.post("/admin/consultas", uContr::showConsultas, engine);
		Spark.get("/admin/admin_out", uContr::adminClose, engine);
	}
}
