package web;

import spark.Spark;
import spark.template.handlebars.HandlebarsTemplateEngine;

public class Router {
	
	public static void initialize(){
		HandlebarsTemplateEngine engine = HandlebarsTemplateEngineBuilder
				.create()
				.withDefaultHelpers()
				.withHelper("isTrue", BooleanHelper.isTrue)
				.build();
		UserController uContr = new UserController();
		Spark.staticFileLocation("/static");
		Spark.get("/", HomeController::principal, engine);
		Spark.get("/admin/ingreso", uContr::adminLog, engine);
		Spark.post("/admin/ingreso", uContr::adminLogPost, engine);
		Spark.get("/admin/workspace", uContr::adminShow, engine);
		Spark.post("/admin/workspace", uContr::showPois, engine);
		Spark.post("/admin/workspace/eliminar", uContr::deletePOI, engine);
		
		Spark.get("/admin/terminales", uContr::adminTerminalShow, engine);
		Spark.post("/admin/terminales", uContr::showTerminales, engine);
		Spark.get("/admin/terminales/agregar", uContr::showAddTerminal,engine);
		Spark.post("/admin/terminales/agregar", uContr::addTerminal,engine);
		Spark.get("/admin/terminales/editar/:id", uContr::showEditTerminal,engine);
		Spark.post("/admin/terminales/editar/:id", uContr::editTerminal,engine);
		Spark.post("/admin/terminales/eliminar", uContr::deleteTerminal,engine);
		
		Spark.get("/admin/consultas", uContr::adminConsultasShow, engine);
		Spark.post("/admin/consultas", uContr::showConsultas, engine);
		
		Spark.get("/admin/poi/:id", uContr::showPOI, engine);
		Spark.post("/admin/poi/editar/:id", uContr::editPOI, engine);
		
		Spark.get("/admin/admin_out", uContr::adminClose, engine);
		
		
		Spark.get("/terminal/ventanaDeTerminal", uContr::ventanaTerminal,engine);
		Spark.post("/terminal/ventanaDeTerminal", uContr::showPoisParaUsuario, engine);
		Spark.get("/terminal/poi/:id", uContr::showPOIParaUsuario, engine);
	}
}
