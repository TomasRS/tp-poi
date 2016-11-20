package criteriosFiltradoTerminales;

import java.util.ArrayList;
import java.util.List;

import ar.edu.TPPOI.Terminal;

public abstract class Criterio {

	public abstract List<Terminal> filtrarTerminales(List<Terminal> list);


}
