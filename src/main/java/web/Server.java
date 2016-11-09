package web;

import spark.Spark;
import spark.template.handlebars.HandlebarsTemplateEngine;

public class Server {
	public static void main(String[] args) {
		Spark.port(9000);
		HandlebarsTemplateEngine engine = HandlebarsTemplateEngineBuilder
				.create()
				.withDefaultHelpers()
				.withHelper("isTrue", BooleanHelper.isTrue)
				.build();
		Spark.staticFileLocation("/static");
		Spark.get("/", HomeController::principal, engine);
		Spark.get("/admin/ingreso", UserController::adminLog, engine);
		Spark.get("/terminal/ventanaDeTerminal",UserController::ventanaTerminal,engine);
		Spark.post("/admin/ingreso", UserController::adminLogPost, engine);
		Spark.get("/admin/workspace", UserController::adminShow, engine);
		Spark.post("/admin/workspace", UserController::showPois, engine);
		Spark.get("/admin/terminales", UserController::adminTerminalShow, engine);
		Spark.post("/admin/terminales", UserController::showTerminales, engine);
		Spark.get("/admin/consultas", UserController::adminConsultasShow, engine);
		Spark.post("/admin/consultas", UserController::showConsultas, engine);
		Spark.get("/admin/admin_out", UserController::adminClose, engine);
	}

}