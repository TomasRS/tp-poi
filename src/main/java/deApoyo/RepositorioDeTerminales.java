package deApoyo;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.uqbarproject.jpa.java8.extras.PerThreadEntityManagers;

import ar.edu.TPPOI.Terminal;

public class RepositorioDeTerminales {

	private static EntityManager entityManager = PerThreadEntityManagers.getEntityManager();
	private static List<Terminal> terminales;

	private static void loadDB() {
		try {
			System.out.println("Init transaction");
			System.out.println("Traigo de DB");
			TypedQuery<Terminal> query = entityManager.createQuery("SELECT t FROM Terminal t", Terminal.class);
			List<Terminal> terminales = query.getResultList();
			System.out.println(terminales.size());
//			terminales.addAll(terminales_enc);
		} catch (Exception e) {
			System.out.println("paso algo");
			e.printStackTrace();
		}
	}

	public static List<Terminal> getTerminales() {
		if (terminales == null) {
			terminales = new ArrayList<>();
//			loadDB();
		}
		loadDB();
		return terminales;
	}

	public static List<Terminal> searchByDescripcion(String searchText) {
		return getTerminales().stream().filter(aTerminal -> aTerminal.cumpleBusqueda(searchText))
			.collect(Collectors.toList());
	}
	
	public static List<Terminal> searchByComuna(String searchText) {
		return getTerminales().stream().filter(
			aTerminal -> aTerminal.cumpleBusquedaComuna(searchText))
			.collect(Collectors.toList());
	}

	public static void agregarTerminal(Terminal aTerminal) {
		System.out.println("Agregar terminal");
		entityManager.persist(aTerminal);
		getTerminales().add(aTerminal);
	}

	public static void clean() {
		terminales.clear();
	}
}
