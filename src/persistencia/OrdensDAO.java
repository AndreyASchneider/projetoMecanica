package persistencia;

import apoio.db.IDAO;
import java.util.Collection;
import negocio.Ordens;

public interface OrdensDAO extends IDAO<Ordens> {

    public Collection<?> lerComFiltro(String datamin, String datamax);
}
